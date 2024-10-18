package laboratories.lab1;

public class Buffer {
    private String message;
    private boolean empty = true;

    public synchronized void put(String message){
        while(!empty){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        this.message = message;
        System.out.println("Produced "+this.message);
        empty = false;
        notifyAll();

    }
    public synchronized String take(){
        while(empty){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        empty = true;
        String messageTaken = this.message;
        System.out.println("Took " + messageTaken);
        notifyAll();
        return messageTaken;
    }

}
