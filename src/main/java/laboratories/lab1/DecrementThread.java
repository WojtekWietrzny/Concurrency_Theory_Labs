package laboratories.lab1;

import laboratories.lab2.CounterInterface;

public class DecrementThread implements Runnable{
    private CounterInterface counter;

    public DecrementThread(CounterInterface counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            counter.decrementCounter();
        }
    }
}
