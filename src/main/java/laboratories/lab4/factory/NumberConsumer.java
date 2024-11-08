package laboratories.lab4.factory;

public class NumberConsumer extends StageProcessor {

    public NumberConsumer(BufferMonitor buffer, int id) {
        super(buffer, id);
    }

    @Override
    public void processStage(int position) {
        super.processStage(position);
        System.out.println("NumberConsumer consumed position " + position);
    }
}
