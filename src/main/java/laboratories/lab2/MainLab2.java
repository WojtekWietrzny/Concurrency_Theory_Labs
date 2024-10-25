package laboratories.lab2;

import laboratories.lab1.*;

//temporary_disabled
public class MainLab2 {
    public void main(String option) throws InterruptedException {
        CounterWithSemaphore counter = new CounterWithSemaphore(0);
        DecrementThread decrement = new DecrementThread(counter);
        IncrementThread increment = new IncrementThread(counter);

        Thread t1 = new Thread(decrement);
        Thread t2 = new Thread(increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter value after operations: " + counter.getCounter());

        System.out.println("Dining philosophers start");

        int numPhilosophers = 5;

        // Semafory dla widelców (BinarySemaphore)
        BinarySemaphore[] forks = new BinarySemaphore[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new BinarySemaphore(true); // Inicjalizacja semaforów
        }
        Thread[] tableThread = new Thread[numPhilosophers];

        switch(option){
            case "first": // dziala
                System.out.println("Symulacja z asymetrycznym podnoszeniem widelców:");

                // Tworzenie wątków filozofów
                for (int i = 0; i < numPhilosophers; i++) {
                    Philosopher philosopher = new Philosopher(i, forks[i], forks[(i + 1) % numPhilosophers]);
                    tableThread[i] = new Thread(philosopher);
                }
                for(int i = 0; i < numPhilosophers; i++){
                    tableThread[i].start();
                }
                break;
            case "second": // dziala
                System.out.println("Symulacja z asymetrycznym podnoszeniem widelców:");

                // Tworzenie wątków filozofów
                for (int i = 0; i < numPhilosophers; i++) {
                    PhilosopherAsynchronous philosopherAsynchronous = new PhilosopherAsynchronous(i, forks[i], forks[(i + 1) % numPhilosophers]);
                    tableThread[i] = new Thread(philosopherAsynchronous);
                }
                for(int i = 0; i < numPhilosophers; i++){
                    tableThread[i].start();
                }
                break;
            case "third": // dziala
                // Semafor dla lokaja
                CountingSemaphore butler = new CountingSemaphore(numPhilosophers - 1);

                System.out.println("Symulacja z lokajem:");

                // Tworzenie wątków filozofów
                for (int i = 0; i < numPhilosophers; i++) {
                    PhilosopherWithButler philosopherWithButler = new PhilosopherWithButler(i, forks[i], forks[(i + 1) % numPhilosophers], butler);
                    tableThread[i] = new Thread(philosopherWithButler);
                }

                for(int i = 0; i < numPhilosophers; i++){
                    tableThread[i].start();
                }
                break;
        }
    }


}