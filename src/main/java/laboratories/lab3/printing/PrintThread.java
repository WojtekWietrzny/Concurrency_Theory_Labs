package laboratories.lab3.printing;


import java.util.Random;

public class PrintThread implements Runnable {

    private PrinterMonitor printerMonitor;
    private int id;

    public PrintThread(PrinterMonitor printerMonitor) {
        this.printerMonitor = printerMonitor;
    }

    @Override
    public void run() {
        while (true) {
            try{
                String toPrint = generatePrintJob(10);
                int printerId = printerMonitor.reserve();
                Printer printer = printerMonitor.getPrinterById(printerId);
                printer.print(toPrint);
                printerMonitor.release(printer);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }


    }

    public String generatePrintJob(int length){
        String result = "";
        for(int i = 0; i < length; i++){
            Random myRandom = new Random();
            result += (char) (myRandom.nextInt(26) + 'a');
        }
        return result;
    }
}
