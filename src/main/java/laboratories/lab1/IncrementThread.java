package laboratories.lab1;

import laboratories.lab2.CounterInterface;

public class IncrementThread implements Runnable{
    private CounterInterface counter;

    public IncrementThread(CounterInterface counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            counter.incrementCounter();
        }
    }
}
