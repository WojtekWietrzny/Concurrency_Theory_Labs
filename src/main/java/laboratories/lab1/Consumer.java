package laboratories.lab1;

public class Consumer implements Runnable {
    private Buffer buffer;
    private int amount;

    public Consumer(Buffer buffer, int amount) {
        this.buffer = buffer;
        this.amount = amount;
    }

    public void run() {

        for(int i = 0;  i < amount;   i++) {
            String message = buffer.take();
        }

    }
}