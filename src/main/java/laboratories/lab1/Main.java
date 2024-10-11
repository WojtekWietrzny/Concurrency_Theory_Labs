package laboratories.lab1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);
        DecrementThread decrement = new DecrementThread(counter);
        IncrementThread increment = new IncrementThread(counter);

        Thread t1 = new Thread(decrement);
        Thread t2 = new Thread(increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCounter());

    }
}