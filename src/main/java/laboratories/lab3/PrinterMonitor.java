 package laboratories.lab3;

 import java.util.concurrent.locks.Condition;
 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantLock;

 public class PrinterMonitor {
    final Printer[] printers;
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    public PrinterMonitor(Printer[] printers) {
        this.printers = printers;
    }


    /*class BoundedBuffer<E> {
        final Lock lock = new ReentrantLock();
        final Condition notFull  = lock.newCondition();
        final Condition notEmpty = lock.newCondition();

        final Object[] items = new Object[100];
        int putptr, takeptr, count;

        public void put(E x) throws InterruptedException {
            lock.lock();
            try {
                while (count == items.length)
                    notFull.await();
                items[putptr] = x;
                if (++putptr == items.length) putptr = 0;
                ++count;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public E take() throws InterruptedException {
            lock.lock();
            try {
                while (count == 0)
                    notEmpty.await();
                E x = (E) items[takeptr];
                if (++takeptr == items.length) takeptr = 0;
                --count;
                notFull.signal();
                return x;
            } finally {
                lock.unlock();
            }
        }
    }*/




    public int reserve(){

    }
    public void release(int Id){

    }

    public Printer getPrinterById(int id){
        for (Printer p : printers) {
            if(p.id() == id){
                return p;
            }
        }
        return null;
    }
}
