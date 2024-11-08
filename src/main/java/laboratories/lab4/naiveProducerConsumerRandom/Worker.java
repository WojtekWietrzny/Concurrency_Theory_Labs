package laboratories.lab4.naiveProducerConsumerRandom;

public abstract class Worker implements Runnable {
        protected Buffer buffer;
        private int limit;

        public Worker(Buffer buffer, int limit) {
            this.buffer = buffer;
            this.limit = limit;
        }

        public void run() {
            int randomInt = (int) (Math.random() * limit);
            doIt(randomInt);
        }

        public abstract void doIt(int randomInt);

    }