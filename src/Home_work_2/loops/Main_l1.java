package Home_work_2.loops;

import java.util.Scanner;
import java.util.Random;

public class Main_l1 {
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Факториал числа");
            System.out.println("2. Умножение цифр числа");
            System.out.println("3. Возведение в степень");
            System.out.println("4. Наибольшая цифра числа");
            System.out.println("5. Вероятность четных случайных чисел");
            System.out.println("6. Четные и нечетные цифры числа");
            System.out.println("7. Ряд Фибоначчи");
            System.out.println("8. Ряд чисел в диапазоне с шагом");
            System.out.println("9. Переворот числа");
            System.out.println("10. Таблица умножения");
            System.out.println("0. Выход");
            System.out.print("Выберите операцию (0-10): ");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    a1(scanner);
                    break;
                case "2":
                    a2(scanner);
                    break;
                case "3":
                    a3(scanner);
                    break;
                case "4":
                    a4(scanner);
                    break;
                case "5":
                    a5(scanner);
                    break;
                case "6":
                    a6(scanner);
                    break;
                case "7":
                    a7(scanner);
                    break;
                case "8":
                    a8(scanner);
                    break;
                case "9":
                    a9(scanner);
                    break;
                case "10":
                    a10();
                    break;
                case "0":
                    System.out.println("Программа завершена");
                    scanner.close();
                    return;
                default:
                    System.out.println("Введите число от 0 до 9");




            }
        }
    }

    public static void a1(Scanner scanner){
        System.out.println("Вычисление факториала");
        System.out.print("Введите положительное целое число: ");
        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            if (number < 1){
                System.out.println("Число должно быть положительным");
                return;
            }

            if (number > 20) {
                System.out.println("Число должно не превышать 20");
                return;
            }

            long res = 1L;
            StringBuilder process = new StringBuilder();

            for (int i = 1; i <= number; i++) {
                    if (q(res, i)) {
                        System.out.println("Переполнение! " + number + "Слишкос большое число");
                        return;
                    }
                    res *= i;
                    process.append(i);
                    if (i < number) {
                        process.append(" * ");
                }
            }
            System.out.println("Процесс:" + process + " = " + res);
            System.out.println("Результат:" + number + "! = " + res);
        } catch (NumberFormatException e) {
            System.out.println("Введите целое число");
        }
    }
    public static void a2(Scanner scanner) {
        System.out.println("Умножение цифр числа");
        System.out.print("Введите целое число: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Введено не число");
            return;
        }
        boolean isNegative = false;
        if (input.startsWith("-")) {
            isNegative = true;
            input = input.substring(1);
        }
        if (!input.matches("\\d+")) {
            System.out.println("Введено не число");
            return;
        }
        if (input.isEmpty() || input.equals("0")) {
            System.out.println("0 = 0");
            return;
        }
        long res = 1L;
        StringBuilder process = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            res *= digit;
            process.append(digit);

            if (i < input.length() - 1) {
                process.append(" * ");
            }
        }
        String finalProcess = isNegative ? "(-" + process + ")" : process.toString();
        System.out.println(finalProcess + " = " + formatNumber(res));
    }
    public static void a3(Scanner scanner) {
        System.out.println("Возведение в степень");
        System.out.print("Введите основание: ");
        String baseInput = scanner.nextLine();

        System.out.print("Введите степень: ");
        String exponentInput = scanner.nextLine();

        try {
            double base = Double.parseDouble(baseInput);
            int exponent = Integer.parseInt(exponentInput);
            if (exponent < 0) {
                System.out.println("Степень должна быть положительной!");
                return;
            }
            if (exponent == 0) {
                System.out.println(base + " ^ 0 = 1.0");
                return;
            }
            double res = 1.0;
            for (int i = 0; i < exponent; i++) {
                res *= base;
            }
            String baseFormatted = formatDouble(base);
            String resultFormatted = formatDouble(res);
            System.out.println(baseFormatted + " ^ " + exponent + " = " + resultFormatted);
        } catch (NumberFormatException e) {
            System.out.println("Введите корректные числа");
        }
    }
    public static void a4(Scanner scanner) {
        System.out.println("Наибольшая цифра числа");
        System.out.print("Введите натуральное число: ");
        String input = scanner.nextLine().trim();

        if (!input.matches("\\d+") || input.equals("0")) {
            System.out.println("Введите натуральное число");
            return;
        }
        int maxDigit = 0;
        StringBuilder digits = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            if (digit > maxDigit) {
                maxDigit = digit;
            }
            digits.append(digit);
            if (i < input.length() - 1) {
                digits.append(", ");
            }
        }
        System.out.println ("Цифры числа: " + digits);
        System.out.println ("Наибольшая цифра: " + maxDigit);
    }
    public static void a5(Scanner scanner) {
        System.out.println("Вероятность четных случайных чисел");
        System.out.print("Введите количество генерируемых чисел: ");

        try {
            int count = Integer.parseInt(scanner.nextLine());
            if (count <= 0) {
                System.out.println("Количество должно быть положительным");
                return;
            }
            int evenCount = 0;
            System.out.print("Сгенерированные числа: ");
            long seed = System.nanoTime();

            for (int i = 0; i < count; i++) {
                seed = (seed * 1664525 + 1013904223) & Long.MAX_VALUE;
                int randomNum = (int)((seed % 100) +1);
                System.out.print(randomNum);
                if (randomNum % 2 == 0) {
                    evenCount++;
                    System.out.print("(чет)");
                } else {
                    System.out.print("(нечет)");
                }
                if (i < count - 1) {
                    System.out.print(", ");
                }
            }
            double probability = (double) evenCount / count * 100;
            System.out.println("Кол-во четных чисел: " + evenCount + " из " + count);
            System.out.printf("Вероятонсть четных чисел: %.2f%%\n", probability);
        } catch (NumberFormatException e) {
            System.out.println("Введите целое число");
        }
    }
    public static void a6(Scanner scanner) {
        System.out.println("Четные и нечетные цифры числа");
        System.out.print("Введите целое число: ");
        String input = scanner.nextLine().trim();

        if (input.startsWith("-")) {
            input = input.substring(1);
        }
        if (!input.matches("\\d+")) {
            System.out.println("Введите целое число");
            return;
        }
        int evenCount = 0;
        int oddCount = 0;
        StringBuilder evenDigits = new StringBuilder();
        StringBuilder oddDigits = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);

            if (digit % 2 == 0) {
                evenCount++;
                evenDigits.append(digit).append(" ");
            } else {
                oddCount++;
                oddDigits.append(digit).append(" ");
            }
        }
        System.out.println("Четные цифры: " + (evenDigits.length() > 0 ? evenDigits : "Нет"));
        System.out.println("Нечетные цифры: " + (oddDigits.length() > 0 ? oddDigits : "Нет"));
        System.out.println("Кол-во четных цифр: " + evenCount);
        System.out.println("Кол-во нечетных цифр: " + oddCount);
    }
    public static void a7(Scanner scanner) {
        System.out.println("Ряд Фибоначчи");
        System.out.print("Введите кол-во чисел Фибоначчи: ");

        try {
            int count = Integer.parseInt(scanner.nextLine());
            if (count <= 0) {
                System.out.println("Кол-во должно быть положительным");
                return;
            }
            if (count > 50) {
                System.out.println("Кол-во не должно превышать 50");
                return;
            }
            long[] fibonacci = new long[count];
            StringBuilder sequence = new StringBuilder();

            for (int i = 0; i < count; i++) {
                if (i == 0) {
                    fibonacci[i] = 0;
                } else if (i == 1) {
                    fibonacci[i] = 1;
                } else {
                    fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
                }
                sequence.append(fibonacci[i]);
                if (i < count - 1) {
                    sequence.append(", ");
                }
            }
            System.out.println("Ряд Фибоначчи: " + sequence);
        } catch (NumberFormatException e) {
            System.out.println("Введите целое число");
        }
    }
    public static void a8(Scanner scanner){
        System.out.println("Ряд чисел в диапазоне с шагом");
        try {
            System.out.print("Введите начальное число: ");
            double start = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите конечное число: ");
            double end = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите шаг: ");
            double step = Double.parseDouble(scanner.nextLine());

            if (step == 0) {
                System.out.println("Шаг не может быть равен нулю");
                return;
            }
            if ((start < end && step < 0) || (start > end && step > 0)) {
                System.out.println("Невозможно достичь конечного числа с таким шагом!");
                return;
            }
            StringBuilder range = new StringBuilder();
            int count = 0;
            double current = start;

            if (step > 0) {
                while (current <= end) {
                    range.append(formatDouble(current));
                    count++;
                    current += step;
                    if (current <= end) {
                        range.append(", ");
                    }
                }
            } else {
                while (current >= end) {
                    range.append(formatDouble(current));
                    count++;
                    current += step;
                    if (current >= end) {
                        range.append(", ");
                    }

                }
            }
            System.out.println("Ряд чисел: " + range);
            System.out.println("Кол-во чисел: " + count);
        } catch (NumberFormatException e) {
            System.out.println("Введите корректные числа");
        }
    }
    public static void a9(Scanner scanner) {
        System.out.println("Переворот числа");
        System.out.print("Введите целое число: ");
        String input = scanner.nextLine().trim();
        boolean isNegative = false;
        if (input.startsWith("-")) {
            isNegative = true;
            input = input.substring(1);
        }
        if (!input.matches("\\d+")) {
            System.out.println("Введите целое число");
            return;
        }
        input = input.replaceFirst("^0+(?!$)", "");
        StringBuilder reversed = new StringBuilder(input).reverse();
        String reversedStr = reversed.toString();
        reversedStr = reversedStr.replaceFirst("^0+(?!$)", "");
        if (reversedStr.isEmpty()) reversedStr = "0";
        String res = isNegative ? "-" + reversedStr : reversedStr;
        System.out.println("Исходное число: " + (isNegative ? "-" + input : input));
        System.out.println("Перевернутое число: " + res);

    }
    public  static void a10() {
        System.out.println("Таблица умножения:");
        System.out.println();
        //Первая часть таблицы
        for (int i = 1; i <= 10; i++) {
            for (int j = 2; j <= 5; j++) {
                if (i == 8 && j == 3) {
                    System.out.print("3 x 8 = 24");
                } else {
                    System.out.print(j + " x " + i + " = " + (j * i));
                }
                if (j < 5) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i <= 10; i++) {
            for (int j = 6; j <= 9; j++) {
                System.out.print(j + " x " + i + " = " + (j * i));
                if (j < 9) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }

    }

    public static boolean q(long a, long b) {
        if (a == 0 || b == 0) return false;
        return a > Long.MAX_VALUE / b;
    }
    public static String formatNumber(long number) {
        return String.format("%,d", number).replace(",", " ");
    }
    public static String formatDouble(double number) {
        if (number == (long) number) {
            return String.format("%,d", (long) number).replace(",", " ");
        } else {
            String formatted = String.valueOf(number);
            if (formatted.contains(".")) {
                formatted = formatted.replaceAll("0*$", "").replaceAll("\\.$", "");
            }
            return formatted;
        }

    }
}