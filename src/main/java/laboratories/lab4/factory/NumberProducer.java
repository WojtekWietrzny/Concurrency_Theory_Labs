package laboratories.lab4.factory;

// Producer class for initializing values in the pipeline
public  class NumberProducer extends StageProcessor {

    public NumberProducer(BufferMonitor buffer, int id) {
        super(buffer, id);
    }

    @Override
    public void processStage(int position) {
        super.processStage(position);
        System.out.println("NumberProducer initialized position " + position);
    }
}