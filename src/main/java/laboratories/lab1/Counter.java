package laboratories.lab1;

public class Counter {
    private int value;

    public Counter(int value){
        this.value = value;
    }

    public synchronized int  incrementCounter(){
        this.value += 1;
        return this.value;
    }
    public synchronized int decrementCounter(){
        this.value -= 1;
        return this.value;
    }

    public int getCounter(){
        return this.value;
    }
}