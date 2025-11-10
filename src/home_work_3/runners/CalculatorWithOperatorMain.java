package home_work_3.runners;

import home_work_3.calcs.simple.CalculatorWithOperator;

public class CalculatorWithOperatorMain {
    public static void main(String[] args) {
        CalculatorWithOperator calc = new CalculatorWithOperator();

        double part1 = calc.multiply(15, 7);
        double part2 = calc.divide(28, 5);
        double part3 = calc.exp(part2, 2);
        double part4 = calc.add(4.1, part1);
        double result = calc.add(part4, part3);

        System.out.println("Результат " + result);
    }
}
