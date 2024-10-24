package laboratories.lab1;
// temporary disabled
public class MainLab1 {
    public void main(String option) throws InterruptedException {
        Counter counter = new Counter(0);
        DecrementThread decrement = new DecrementThread(counter);
        IncrementThread increment = new IncrementThread(counter);

        Thread t1 = new Thread(decrement);
        Thread t2 = new Thread(increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter value after operations: " + counter.getCounter());

        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer, 10);
        Consumer consumer = new Consumer(buffer, 10);

        Thread t3 = new Thread(producer);
        Thread t4 = new Thread(consumer);

        t3.start();
        t4.start();

        t3.join();
        t4.join();



    }
}