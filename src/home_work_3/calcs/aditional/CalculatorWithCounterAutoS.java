package home_work_3.calcs.aditional;

import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorWithCounterAutoS extends CalculatorWithMathExtends {
    private long count;

    @Override
    public double add(double a, double b) {
        count++;
        return super.add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        count++;
        return super.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        count++;
        return super.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {
        count++;
        return super.divide(a, b);
    }

    @Override
    public  double exp(double base, int exponent) {
        count++;
        return super.exp(base, exponent);
    }

    @Override
    public double absolute(double a) {
        count++;
        return super.absolute(a);
    }

    @Override
    public double squareRoot(double a) {
        count++;
        return super.squareRoot(a);
    }

    public long getCountOperation() {
        return count;
    }
}
