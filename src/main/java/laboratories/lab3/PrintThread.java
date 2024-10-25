package laboratories.lab3;


import java.util.Random;

public class PrintThread implements Runnable {

    private PrinterMonitor printerMonitor;

    public PrintThread(PrinterMonitor printerMonitor) {
        this.printerMonitor = printerMonitor;
    }

    @Override
    public void run() {
        String toPrint = generatePrintJob(10);
        int printerId = PrinterMonitor.reserve();
        Printer printer = PrinterMonitor.getPrinterById(printerId);
        printer.print();
        PrinterMonitor.release();
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
