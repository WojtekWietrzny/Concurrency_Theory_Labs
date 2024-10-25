package laboratories.lab2;

public class CountingSemaphore {
    // true means up and available
    private int capacity;
    private int count;
    public CountingSemaphore(int count) {
        this.count = count;

    }

    public synchronized void free(){
        notify();
        this.count += 1;


    }
    public synchronized void acquire(){
        while (count == 0) {
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        this.count -= 1;
    }



}