package home_work_3.calcs.aditional;

import home_work_3.calcs.api.IСalculator;

public class CalcularotWithMemory {
    private final IСalculator calculator;
    private double memory;

    public CalcularotWithMemory(IСalculator calculator) {
        this.calculator = calculator;
    }

    public double add(double a, double b) {
        return calculator.add(a, b);
    }

    public double substract(double a, double b) {
        return calculator.add(a, b);
    }

    public double multiply(double a, double b) {
        return calculator.multiply(a, b);
    }

    public double divide(double a, double b) {
        return calculator.divide(a, b);
    }

    public double exp(double base, int exponent) {
        return calculator.exp(base, exponent);
    }

    public double absolute(double a) {
        return calculator.absolute(a);
    }

    public double squareRoot(double a) {
        return calculator.squareRoot(a);
    }

    public void save() {
    }

    public double load() {
        double value = memory;
        memory = 0;
        return value;
    }

    public void setMemory(double value) {
        this.memory = value;
    }
}
