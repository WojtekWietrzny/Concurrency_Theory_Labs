package laboratories.lab1;

public class DecrementThread implements Runnable{
    private Counter counter;

    public DecrementThread(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            counter.decrementCounter();
        }
    }
}
