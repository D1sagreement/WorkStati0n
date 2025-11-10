package home_work_3.calcs.aditional;

import home_work_3.calcs.api.IСalculator;

public class CalculatorWithCAAI implements IСalculator {
    private final IСalculator calculator;
    private long count;

    public CalculatorWithCAAI(IСalculator calculator) {
        this.calculator = calculator;
    }

    public double add(double a, double b) {
        count++;
        return calculator.add(a, b);
    }

    public double subtract(double a, double b) {
        count++;
        return calculator.subtract(a, b);
    }

    public double multiply(double a, double b) {
        count++;
        return calculator.multiply(a, b);
    }

    public double divide(double a, double b) {
        count++;
        return calculator.divide(a, b);
    }

    public double exp(double base, int exponent) {
        count++;
        return calculator.exp(base, exponent);
    }

    public double absolute(double a) {
        count++;
        return calculator.absolute(a);
    }

    public double squareRoot(double a) {
        count++;
        return calculator.squareRoot(a);
    }

    public long getCountOperation() {
        return count;
    }
}
