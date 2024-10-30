package laboratories.lab3;

import laboratories.lab3.printing.PrintThread;
import laboratories.lab3.printing.Printer;
import laboratories.lab3.printing.PrinterMonitor;
import laboratories.lab3.waiters.Waiter;
import laboratories.lab3.waiters.Customer;

public class MainLab3 {
    public void main(String option) {


        switch(option) {
            case "first":
                Printer[] printers = new Printer[5];
                for(int i = 0; i < printers.length; i++){
                    printers[i] = new Printer(i, false);
                }
                PrinterMonitor printerMonitor = new PrinterMonitor( 5,printers);
                PrintThread[] printThreads = new PrintThread[50];
                Thread[] threads = new Thread[50];
                for (int i = 0; i < threads.length; i ++){
                    printThreads[i] = new PrintThread(printerMonitor);
                    threads[i] = new Thread(printThreads[i]);
                }
                for(int i = 0; i < threads.length; i++){
                    threads[i].start();
                }
                break;
            case "second":
                Waiter waiterMonitor = new Waiter(25);
                Customer[] customers = new Customer[50];
                Thread[] customerThreads = new Thread[50];
                for (int i = 0; i < customers.length; i++) {
                    customers[i] = new Customer(waiterMonitor, i / 2);
                    customerThreads[i] = new Thread(customers[i]);
                }
                for (int i = 0; i < customerThreads.length; i++) {
                    customerThreads[i].start();
                }
                break;
        }
    }
}
