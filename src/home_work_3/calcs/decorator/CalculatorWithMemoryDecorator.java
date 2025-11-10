package home_work_3.calcs.decorator;

import home_work_3.calcs.api.IСalculator;

public class CalculatorWithMemoryDecorator implements IСalculator {
    private final IСalculator calculator;
    private double memory;
    private double lastResult;

    public CalculatorWithMemoryDecorator(IСalculator calculator) {
        this.calculator = calculator;
    }

    public double add(double a, double b) {
        lastResult = calculator.add(a, b);
        return lastResult;
    }

    public double subtract(double a, double b) {
        lastResult = calculator.subtract(a, b);
        return lastResult;
    }

    public double multiply(double a, double b) {
        lastResult = calculator.multiply(a, b);
        return lastResult;
    }

    public double divide(double a, double b) {
        lastResult = calculator.divide(a, b);
        return lastResult;
    }

    public double exp(double base, int exponent) {
        lastResult = calculator.exp(base, exponent);
        return lastResult;
    }

    public double absolute(double a) {
        lastResult = calculator.absolute(a);
        return lastResult;
    }

    public double squareRoot(double a) {
        lastResult = calculator.squareRoot(a);
        return lastResult;
    }

    public void save() {
        memory = lastResult;
    }

    public double load() {
        double value = memory;
        memory = 0;
        return value;
    }

    public IСalculator getCalculator() {
        return calculator;
    }
}
