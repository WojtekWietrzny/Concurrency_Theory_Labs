package laboratories.lab4;

import laboratories.lab4.factory.BufferMonitor;
import laboratories.lab4.factory.NumberProducer;
import laboratories.lab4.factory.NumberConsumer;
import laboratories.lab4.factory.NumberTransformer;
import laboratories.lab4.naiveProducerConsumerRandom.Buffer;
import laboratories.lab4.naiveProducerConsumerRandom.Consumer;
import laboratories.lab4.naiveProducerConsumerRandom.Producer;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainLab4 {

    private static void go(int bufferSize, int numberOfWorkers, FileWriter fileWriter)
            throws IOException, InterruptedException {
        Buffer buffer = new Buffer(bufferSize, fileWriter);
        Thread[] workers = new Thread[numberOfWorkers * 2];

        // Initialize worker threads
        for (int i = 0; i < numberOfWorkers; i++) {
            workers[i] = new Thread(new Producer(buffer, bufferSize));
            workers[i + numberOfWorkers] = new Thread(new Consumer(buffer, bufferSize));
        }

        // Start all worker threads
        for (int i = 0; i < 2 * numberOfWorkers; i++) {
            workers[i].start();
        }

        // Wait for all worker threads to finish
        for (int i = 0; i < 2 * numberOfWorkers; i++) {
            workers[i].join();
        }
    }

    public void main(String option) throws IOException, InterruptedException {
        switch(option) {
            case "first":
                Lock lock = new ReentrantLock();
                Condition[] stageConditions = new Condition[6];
                for (int i = 0; i < 6; i++) {
                    stageConditions[i] = lock.newCondition();
                }

                BufferMonitor buffer = new BufferMonitor(10, lock, stageConditions);

                Thread producer = new Thread(new NumberProducer(buffer, 0));
                Thread[] transformers = new Thread[5];
                for (int i = 1; i <= 5; i++) {
                    transformers[i - 1] = new Thread(new NumberTransformer(buffer, i));
                }
                Thread consumer = new Thread(new NumberConsumer(buffer, 6));

                producer.start();
                for (Thread transformer : transformers) {
                    transformer.start();
                }
                consumer.start();
                break;
            case "second":
                File assetsDir = new File("src/main/resources/assets");
                if (!assetsDir.exists()) {
                    assetsDir.mkdirs();
                }

                FileWriter fileWriter = new FileWriter("src/main/resources/assets/results.csv");

                go(1000, 10, fileWriter);
                go(10000, 100, fileWriter);
                go(100000, 1000, fileWriter);

                fileWriter.close();
                break;
            case "third":

                break;
        }
    }
}