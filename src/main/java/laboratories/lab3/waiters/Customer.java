package laboratories.lab3.waiters;

public class Customer implements Runnable {
    private Waiter monitor;
    private int id;
    public Customer(Waiter monitor, int id) {
        this.monitor = monitor;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) Math.floor(Math.random() * 10000));
            System.out.println("Booking table for  " + id);
            monitor.bookTable(id);
            Thread.sleep((int) Math.floor(Math.random() * 1000));
            monitor.releaseTable();
            System.out.println("Finished  " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
