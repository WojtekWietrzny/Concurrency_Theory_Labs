package laboratories.lab3.waiters;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiter {
    private final Lock lock = new ReentrantLock();
    // condition for table
    private Condition table = lock.newCondition();
    // condition for each pair
    private Condition[] pairs;
    private int[] booked;
    private int personAtTable = 0;
    public Waiter(int size) {
        // condition for each pair
        pairs = new Condition[size];
        booked = new int[size];
        for (int i = 0; i < size; i++) {
            pairs[i] = lock.newCondition();
            booked[i] = 0;
        }
    }
    public void bookTable(int number) throws InterruptedException {
        lock.lock();
        try {

            while (personAtTable > 0) {
                table.await();
            }
            if (booked[number] == 0) {
                booked[number] = 1;
                while (booked[number] == 1) {
                    pairs[number].await();
                }
            } else {
                booked[number] = 0;
                personAtTable = 2;
                pairs[number].signal();
            }

        } finally {
            lock.unlock();
        }
    }

    public void releaseTable() {
        lock.lock();
        try {
            personAtTable--;
            if (personAtTable == 0) {
                table.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}


