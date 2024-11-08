package laboratories.lab4.factory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferMonitor {
    private int[] pipeline;
    private Lock Lock;
    private Condition[] stageConditions;

    public BufferMonitor(int size, Lock Lock, Condition[] stageConditions) {
        this.pipeline = new int[size];
        this.Lock = Lock;
        this.stageConditions = stageConditions;
        for (int i = 0; i < size; i++) {
            pipeline[i] = -1;
        }
    }

    public void beginStage(int position, int stageId) throws InterruptedException {
        Lock.lock();
        try {
            while (pipeline[position] != stageId - 1) {
                stageConditions[stageId - 1].await();
            }
            System.out.println("Stage " + stageId + " acquired position " + position);
        } finally {
            Lock.unlock();
        }
    }

    public void completeStage(int position, int stageId) {
        Lock.lock();
        try {
            pipeline[position] = stageId;
            if (stageId < 6) {
                stageConditions[stageId].signal();
            }
        } finally {
            Lock.unlock();
        }
    }

    public int getPipelineSize() {
        return pipeline.length;
    }
}