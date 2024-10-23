package laboratories.lab2;

public class BinarySemaphore {
    // true means up and available
    private boolean state = true;
    public BinarySemaphore(boolean state) {
        this.state = state;
    }

    public synchronized void block(){
        while(!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.state = false;
    }
    public synchronized void release(){
        this.state = true;
        notify();
    }



}