package laboratories.lab2;

import laboratories.lab1.*;

//temporary_disabled
public class MainLab2 {
    public void main() throws InterruptedException {
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

        // Liczba filozofów
        int numPhilosophers = 5;

        // Semafory dla widelców (BinarySemaphore)
        BinarySemaphore[] forks = new BinarySemaphore[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new BinarySemaphore(true); // Inicjalizacja semaforów
        }

        // Semafor dla lokaja (CountingSemaphore)
        CountingSemaphore butler = new CountingSemaphore(numPhilosophers - 1);

        // Uruchomienie symulacji z lokajem
        System.out.println("Symulacja z lokajem:");
        for (int i = 0; i < numPhilosophers; i++) {
            PhilosopherWithButler philosopherWithButler = new PhilosopherWithButler(i, forks[i], forks[(i + 1) % numPhilosophers], butler);
            Thread thread = new Thread(philosopherWithButler);

        }

        // Opóźnienie przed uruchomieniem drugiej symulacji
        try {
            Thread.sleep(2000); // Czekaj 2 sekundy
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Uruchomienie symulacji z asymetrycznym podnoszeniem widelców
        System.out.println("Symulacja z asymetrycznym podnoszeniem widelców:");
        for (int i = 0; i < numPhilosophers; i++) {
            Philosopher philosopher = new Philosopher(i, forks[i], forks[(i + 1) % numPhilosophers]);
            new Thread(philosopher).start();
        }
    }


}