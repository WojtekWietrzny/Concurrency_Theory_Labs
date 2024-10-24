package laboratories.lab2;

public class PhilosopherWithButler implements Runnable {
    private final int id;
    private final BinarySemaphore leftFork;
    private final BinarySemaphore rightFork;
    private final CountingSemaphore butler;

    public PhilosopherWithButler(int id, BinarySemaphore leftFork, BinarySemaphore rightFork, CountingSemaphore butler) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.butler = butler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                butler.acquire(); // Filozof pyta lokaja, czy może podejść do stołu

                leftFork.block();
                rightFork.block();

                eat();

                leftFork.release();
                rightFork.release();

                butler.free(); // Filozof odchodzi od stołu, zwalniając miejsce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Filozof " + id + " myśli.");
        //Thread.sleep(100);
    }

    private void eat() throws InterruptedException {
        System.out.println("Filozof " + id + " je.");
        //Thread.sleep(100);
    }
}
