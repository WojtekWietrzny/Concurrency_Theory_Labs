package laboratories.lab4.factory;

// Abstract class to represent a processor in the pipeline
    public abstract class StageProcessor implements Runnable {
        protected BufferMonitor buffer;
        protected int id;

        public StageProcessor(BufferMonitor buffer, int id) {
            this.buffer = buffer;
            this.id = id;
        }

        public void run() {
            for (int i = 0; i < buffer.getPipelineSize(); i++) {
                processStage(i);
            }
        }

        public void processStage(int position) {
            try {
                buffer.beginStage(position, id);
                Thread.sleep((int) Math.floor(Math.random() * 1000));
                buffer.completeStage(position, id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
