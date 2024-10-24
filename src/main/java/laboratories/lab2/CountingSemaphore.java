package laboratories.lab2;

public class CountingSemaphore {
    // true means up and available
    private int capacity;
    private int count;
    public CountingSemaphore(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void free(){
        if(count > 0){
            notify();
        }
        this.count -= 1;


    }
    public synchronized void acquire(){
        while (count >= capacity) {
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        this.count += 1;
    }



}