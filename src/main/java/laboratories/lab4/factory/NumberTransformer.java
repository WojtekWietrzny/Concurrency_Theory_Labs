package laboratories.lab4.factory;

import java.util.ArrayList;

public class NumberTransformer extends StageProcessor {

    public NumberTransformer(BufferMonitor buffer, int id) {
        super(buffer, id);
    }

    @Override
    public void processStage(int position) {
        super.processStage(position);
        System.out.println("NumberTransformer at stage " + id + " processed position " + position);
    }
}