package home_work_3.calcs.aditional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterClassic extends CalculatorWithMathExtends {
    private long count;

    public void incrementCountOperation() {
        count++;
    }

    public long getCountOopetion() {
        return count;
    }
}
