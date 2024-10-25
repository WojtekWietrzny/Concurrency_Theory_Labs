package laboratories.lab3;

public class Printer {
    private int printerId;
    private boolean isLocked;
    public Printer(int printerId, boolean isLocked) {
        this.printerId = printerId;
        this.isLocked = isLocked;
    }
    public void print(String text) {
        System.out.println(printerId + ": " + text);
    }
    public int id(){
        return printerId;
    }
    public boolean isLocked() {
        return isLocked;
    }
}
