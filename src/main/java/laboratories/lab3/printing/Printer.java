package laboratories.lab3.printing;

public class Printer {
    private int printerId;
    private boolean isLocked;
    public Printer(int printerId, boolean isLocked) {
        this.printerId = printerId;
        this.isLocked = isLocked;
    }
    public void print(String text) {
        System.out.println("printer id: " + printerId + " ,message: " + text);
    }
    public int id(){
        return printerId;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public void setLocked() {
        isLocked = true;
    }
    public void setUnlocked() {
        isLocked = false;
    }
}
