 package laboratories.lab3.printing;

 import java.util.concurrent.locks.Condition;
 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantLock;




 public class PrinterMonitor {
    private Printer[] printers;
    private final Lock lock = new ReentrantLock();
    private Condition printersCondition = lock.newCondition();
    private int counter;

    public PrinterMonitor(int size, Printer[] printers) {
        this.printers = printers;
        this.counter = size;
    }

     public boolean isAnyPrinterFree(){
         return counter > 0;
     }
     public int reserve() throws InterruptedException {
         lock.lock();
         try {
             while (!isAnyPrinterFree()) {
                 printersCondition.await();
             }
             int printer_id = -1;
             for (int i = 0; i < printers.length; i++) {
                 if (!printers[i].isLocked()) {
                     printers[i].setLocked();
                     counter --;
                     printer_id = printers[i].id();
                     break;
                 }
             }
             return printer_id;
         } finally {
             lock.unlock();
         }
     }

     public void release(Printer printer){
        lock.lock();
        try{
            printer.setUnlocked();
            counter ++;
            printersCondition.signal();
        } finally {
            lock.unlock();
        }
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
