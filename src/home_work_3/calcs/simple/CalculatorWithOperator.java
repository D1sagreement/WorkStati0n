package home_work_3.calcs.simple;

import home_work_3.calcs.api.IСalculator;

    public class CalculatorWithOperator implements IСalculator {

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
                throw new ArithmeticException("Деление на 0 невозможно");
            }
            return a / b;
        }

        public double exp(double base, int exponent) {
            if (exponent < 0) {
                throw new IllegalArgumentException("число не должно быть отрицательным");
            }

            double result = 1;
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        }

        public double absolute(double a) {
            return a < 0 ? -a : a;
        }

        public double squareRoot(double a) {
            if (a < 0) {
                throw new IllegalArgumentException("Невозможно вычислить квадратный корень из отрицательного числа");
            }
            return Math.sqrt(a);

        }

    }
