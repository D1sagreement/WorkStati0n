package home_work_3.calcs.simple;

import home_work_3.calcs.api.IСalculator;

public class CalculatorWithOperatorCopy implements IСalculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Нельзя делить на ноль");
        }
        return a / b;
    }

    public double exp(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public double absolute(double a) {
        return Math.abs(a);
    }

    public double squareRoot(double a) {
        return Math.sqrt(a);
    }
}
