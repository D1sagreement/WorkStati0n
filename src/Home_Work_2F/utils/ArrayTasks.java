package Home_Work_2F.utils;

import java.util.Arrays;

public class ArrayTasks {

    // 2.4.1
    public static int sumEvenPositiveElements(int[] array) {
        int sum = 0;
        for (int num : array) {
            if (num > 0 && num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }

    // 2.4.2
    public static int maxEvenIndexElement(int[] array) {
        if (array.length == 0) return 0;
        int max = array[0];
        for (int i = 2; i < array.length; i += 2) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // 2.4.3
    public static int[] elementsLessThanAverage(int[] array) {
        if (array.length == 0) return new int[0];

        double sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = sum / array.length;

        int count = 0;
        for (int num : array) {
            if (num < average) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int num : array) {
            if (num < average) {
                result[index++] = num;
            }
        }
        return result;
    }

    // 2.4.4
    public static int[] twoMinElements(int[] array) {
        if (array.length < 2) {
            return array.length == 1 ? new int[]{array[0]} : new int[0];
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : array) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2 && num != min1) {
                min2 = num;
            }
        }

        if (min2 == Integer.MAX_VALUE) {
            return new int[]{min1};
        }

        return new int[]{min1, min2};
    }

    // 2.4.5
    public static int[] compressArray(int[] array, int a, int b) {
        if (array.length == 0) return new int[0];

        int count = 0;
        for (int num : array) {
            if (num < a || num > b) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int num : array) {
            if (num < a || num > b) {
                result[index++] = num;
            }
        }
        return result;
    }

    // 2.4.6
    public static int sumOfDigits(int[] array) {
        int totalSum = 0;
        for (int num : array) {
            int number = Math.abs(num);
            while (number > 0) {
                totalSum += number % 10;
                number /= 10;
            }
        }
        return totalSum;
    }

    public static void demonstrateTasks() {
        int[] array = ArraysUtils.arrayRandom(50, 100);

        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("2.4.1. Сумма четных положительных элементов: " + sumEvenPositiveElements(array));
        System.out.println("2.4.2. Максимальный элемент с четным индексом: " + maxEvenIndexElement(array));
        System.out.println("2.4.3. Элементы меньше среднего: " + Arrays.toString(elementsLessThanAverage(array)));
        System.out.println("2.4.4. Два наименьших элемента: " + Arrays.toString(twoMinElements(array)));

        int a = 20, b = 50;
        System.out.println("2.4.5. Сжатый массив (без элементов [" + a + "," + b + "]): " +
                Arrays.toString(compressArray(array, a, b)));
        System.out.println("2.4.6. Сумма всех цифр массива: " + sumOfDigits(array));
    }

    public static void main(String[] args) {
        demonstrateTasks();
    }
}
