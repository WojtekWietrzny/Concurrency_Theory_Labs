package laboratories.lab2;

public class PhilosopherAsynchronous implements Runnable {
    private final int id;
    private final BinarySemaphore leftFork;
    private final BinarySemaphore rightFork;

    public PhilosopherAsynchronous(int id, BinarySemaphore leftFork, BinarySemaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                if (id % 2 == 0) {
                    // Parzysty filozof: najpierw podnosi prawy widelec
                    rightFork.block();
                    leftFork.block();
                } else {
                    // Nieparzysty filozof: najpierw podnosi lewy widelec
                    leftFork.block();
                    rightFork.block();
                }

                eat();

                // Odkłada widelce
                leftFork.release();
                rightFork.release();
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
