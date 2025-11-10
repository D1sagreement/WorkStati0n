package home_work_3.runners;

import home_work_3.calcs.api.IСalculator;
import home_work_3.calcs.decorator.CalculatorWithCounterAutoDecorator;
import home_work_3.calcs.decorator.CalculatorWithMemoryDecorator;
import home_work_3.calcs.simple.CalculatorWithMathExtends;

public class CalculatorDecoratorMain {
    public static void main(String[] args) {
        IСalculator calc = new CalculatorWithCounterAutoDecorator(
                new CalculatorWithMemoryDecorator(
                        new CalculatorWithMathExtends()
                )
        );

        double part1 = calc.multiply(15, 7);
        double part2 = calc.divide(28,5);
        double part3 = calc.exp(part2, 2);
        double part4 = calc.add(4.1, part1);
        double result = calc.add(part4, part3);

        System.out.println("Результат " + result);

        if (calc instanceof CalculatorWithCounterAutoDecorator) {
            CalculatorWithCounterAutoDecorator counterAutoDecorator = (CalculatorWithCounterAutoDecorator) calc;
            System.out.println("Кол-во операций " + counterAutoDecorator.getCalculator());

            IСalculator innerCalc = counterAutoDecorator.getCalculator();
            if (innerCalc instanceof CalculatorWithMemoryDecorator) {
                CalculatorWithMemoryDecorator memoryDecorator = (CalculatorWithMemoryDecorator) innerCalc;

                memoryDecorator.save();
                System.out.println("Сохранение операций: " + memoryDecorator.load());
            }
        }
    }
}
