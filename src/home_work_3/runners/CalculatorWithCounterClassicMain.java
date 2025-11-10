package home_work_3.runners;

import home_work_3.calcs.aditional.CalculatorWithCounterClassic;

public class CalculatorWithCounterClassicMain {
    public static void main(String[] args) {
        CalculatorWithCounterClassic calc = new CalculatorWithCounterClassic();

        double part1 = calc.multiply(15,7);
        calc.incrementCountOperation();

        double part2 = calc.divide(28,5);
        calc.incrementCountOperation();

        double part3 = calc.exp(part2,2);
        calc.incrementCountOperation();

        double part4 = calc.add(4.1,part1);
        calc.incrementCountOperation();

        double result = calc.add(part4,part3);
        calc.incrementCountOperation();

        System.out.println("Результат " + result);
        System.out.println("Кол-во операций " + calc.getCountOopetion());
    }
}
