package laboratories.lab2;

public class BinarySemaphore {
    // true means up and available
    private boolean state = true;
    public BinarySemaphore(boolean state) {
        this.state = state;
    }

    public void free(){
        if(!state){
            notify();
        }
        this.state = true;


    }
    public void aquire(){
        while (!state) {
            try{
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        this.state = true;
    }



}