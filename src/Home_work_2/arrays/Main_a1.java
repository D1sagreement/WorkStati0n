package Home_work_2.arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main_a1 {
    static class ArraysUtils {
        public static int[] arrayFromConsole() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();
            int[] array = new int[size];

            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < size; i++) {
                System.out.print("Элемент " + (i + 1) + ": ");
                array[i] = scanner.nextInt();
            }
            return array;
        }
        public static int[] arrayRandom(int size, int maxValueExclusion) {
            Random random = new Random();
            int[] array = new int[size];

            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt(maxValueExclusion);
            }
            return array;
        }
    }
    static class ArraysIteration {
        public static class DoWhileOperation {
            public static void printAllElements (int[] array) {
                System.out.println("Все элементы (do, while...");
                int i = 0;
                if (array.length > 0) {
                    do {
                        System.out.print(array[i] + " ");
                        i++;
                    } while (i < array.length);
                }
                System.out.println();
            }
            public static void printEverySecondElement(int[] array) {
                System.out.println("Каждый второй элемент (do, while...");
                int i = 1;
                if (array.length > 1) {
                    do {
                        System.out.print(array[i] + " ");
                        i += 2;
                    } while (i < array.length);
                }
                System.out.println();
            }
            public static void printReverseOrder(int[] array) {
                System.out.println("Обратный порядок (do, while...");
                int i = array.length - 1;
                if (i >= 0) {
                    do {
                        System.out.print(array[i] + " ");
                        i--;
                    } while (i >= 0);
                }
                System.out.println();
            }
        }
        public static class WhileOperation {
            public static void printAllElements (int[] array) {
                System.out.println("Все элементы (while):");
                int i = 0;
                while (i < array.length) {
                    System.out.print(array[i] + " ");
                    i++;
                }
                System.out.println();
            }
            public static void printEverySecondElement(int[] array) {
                System.out.println("Каждый второй элемент (while)");
                int i = 1;
                while (i < array.length) {
                    System.out.print(array[i] + " ");
                    i += 2;
                }
                System.out.println();
            }
            public static void printReverseOrder(int[] array) {
                System.out.println("Обратный порядок (while):");
                int i = array.length - 1;
                while (i >= 0) {
                    System.out.print(array[i] + " ");
                    i--;
                }
                System.out.println();
            }
        }
        public static class ForOperation {
            public static void printAllElements(int[] array) {
                System.out.println("Все элементы (for):");
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
            }
            public static void printReverseOrder(int[] array) {
                System.out.println("Обратный порядок (for):");
                for (int i = array.length - 1; i >= 0; i--) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
            }

            public static void printEverySecondElement(int[] array) {
                System.out.println("Каждый второй элемент (for):");
                for (int i = 1; i < array.length; i += 2) {
                    System.out.println(array[i] + " ");
                }
                System.out.println();
            }
        }
        public static class ForEachOperation {
            public static void printAllElements(int[] array) {
                System.out.println("Все элементы (foreach):");
                for (int element : array) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
            public static void printEverySecondElement(int[] array) {
                System.out.println("Каждый второй элемент (foreach):");
                int counter = 0;
                for (int element : array) {
                    if (counter % 2 == 1) {
                        System.out.print(element + " ");
                    }
                    counter++;
                }
                System.out.println();
            }
            public static void printReverseOrder (int[] array) {
                System.out.println("Обратный порядок (foreach) - нельзя сделать без доп массивов");
            }
        }
    }
    static class ArrayTasks {
        public static int sumEvenPositiveElements(int[] array) {
            int sum = 0;
            for (int num : array) {
                if (num > 0 && num % 2 == 0) {
                    sum += num;
                }
            }
            return sum;
        }
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
        public static int [] elementsLessThanAverage(int[] array) {
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
            return new int[]{min1, min2};
        }
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
        public static int sumOfDigits (int[] array) {
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
        public static void demonstrateTasks(){
            int[] array = ArraysUtils.arrayRandom(10, 100);
            System.out.println("Исход. массив: " + Arrays.toString(array));
            System.out.println("2.4.1. Сумма четных положительных элементов: " + sumEvenPositiveElements(array));
            System.out.println("2.4.2. Максимальный элемент с четным индексом: " + maxEvenIndexElement(array));
            System.out.println("2.4.3. Элементы меньше среднего: " + Arrays.toString(elementsLessThanAverage(array)));
            System.out.println("2.4.4. Два наименьших элемента: " + Arrays.toString(twoMinElements(array)));

            int a = 20, b = 50;
            int[] compresseded = compressArray(array, a, b);

            System.out.println("2.4.5. Сжатый массив (без элементов [" + a + "," + b + "]): " + Arrays.toString(compresseded));
            System.out.println("2.4.6. Сумма всех цифр массива: " + sumOfDigits(array));


        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Полная программа для работы с массивами");

        System.out.println("1. Демонстрация 2.1.1.1 - arrayFromConsole()");
        System.out.println("Введите данные для создания массива:");
        int[] container1 = ArraysUtils.arrayFromConsole();
        System.out.print("Созданный массив: ");
        for (int num : container1) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        System.out.println("2. Демонстрация 2.1.2.1 - arrayRandom(5, 100)");
        int[] container2 = ArraysUtils.arrayRandom(5,100);
        System.out.print("Случайный массив: ");
        for (int num : container2) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        System.out.println("3. Демонстрация ArraysIteration");
        int[] testArray = {10,20,30,40,50,60,70,80};
        System.out.println("Тестовый массив: ");
        for (int num : testArray) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        System.out.println("DoWhile операции");
        ArraysIteration.DoWhileOperation.printAllElements(testArray);
        ArraysIteration.DoWhileOperation.printEverySecondElement(testArray);
        ArraysIteration.DoWhileOperation.printReverseOrder(testArray);

        System.out.println("While операции");
        ArraysIteration.WhileOperation.printAllElements(testArray);
        ArraysIteration.WhileOperation.printEverySecondElement(testArray);
        ArraysIteration.WhileOperation.printReverseOrder(testArray);

        System.out.println("For операции");
        ArraysIteration.ForOperation.printAllElements(testArray);
        ArraysIteration.ForOperation.printEverySecondElement(testArray);
        ArraysIteration.ForOperation.printReverseOrder(testArray);

        System.out.println("ForEach операции");
        ArraysIteration.ForEachOperation.printAllElements(testArray);
        ArraysIteration.ForEachOperation.printEverySecondElement(testArray);
        ArraysIteration.ForEachOperation.printReverseOrder(testArray);

        System.out.println("4. Демонстрация ArrayTasks");
        ArrayTasks.demonstrateTasks();

        System.out.println("Программа завершена");
    }
}
