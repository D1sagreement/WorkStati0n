package home_work_3.calcs.simple;

import home_work_3.calcs.api.IСalculator;

public class CalculatorWithMathExtends extends CalculatorWithOperator implements IСalculator {

    @Override
    public  double exp(double base,int exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public  double absolute(double a) {
        return Math.abs(a);
    }

    @Override
    public  double squareRoot(double a) {
        return Math.sqrt(a);
    }
}
