package laboratories.lab2;

import java.util.concurrent.Semaphore;

public class CounterWithSemaphore implements CounterInterface{
    private int value;
    private BinarySemaphore semaphore;

    public CounterWithSemaphore(int value){
        this.value = value;
        this.semaphore = new BinarySemaphore(true);
    }

    public int  incrementCounter(){
        semaphore.block();
        try {
            this.value += 1;
            return this.value;
        } finally {
            semaphore.release();
        }
    }
    public int decrementCounter(){
        semaphore.block();
        try{
            this.value -= 1;
            return this.value;
        } finally {
            semaphore.release();
        }
    }
    public int getCounter(){
        return this.value;
    }
}
