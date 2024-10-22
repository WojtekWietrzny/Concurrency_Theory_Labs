package laboratories.lab2;

import java.util.concurrent.Semaphore;

public class CounterWithSemaphore implements CounterInterface{
    private int value;
    private BinarySemaphore semaphore;

    public CounterWithSemaphore(int value){
        this.value = value;
        this.semaphore = new BinarySemaphore(false);
    }

    public int  incrementCounter(){
        semaphore.aquire();
        try {
            this.value += 1;
            return this.value;
        } finally {
            semaphore.free();
        }
    }
    public int decrementCounter(){
        semaphore.aquire();
        try{
            this.value -= 1;
            return this.value;
        } finally {
            semaphore.free();
        }
    }
    public int getCounter(){
        return this.value;
    }
}
