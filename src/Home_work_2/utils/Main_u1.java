package Home_work_2.utils;

import java.util.Arrays;
import java.util.Scanner;

class SortsUtils {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[i] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
    public static void shake(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            left++;
        }
    }
}
class ArraysUtils {
    public static int[] arrayRandom(int size, int maxValue) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        return arr;
    }
    public static int[] arrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Введите " + size + " элементов массива:");

        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}

public class Main_u1 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5,6};
        testSorts("Тест 1 (пузырьковая)", arr1, "sort");

        int[] arr2 = new int[]{1,1,1,1};
        testSorts("Тест 2 (шейкерная)", arr2, "shake");

        int[] arr3 = new int[]{9,1,5,99,9,9};
        testSorts("Тест 3 (пузырьковая)", arr3, "sort");

        int[] arr4 = new int[]{};
        testSorts("Тест 4 (шейкерная)", arr4, "shake");

        int[] arr5 = new int[]{6,5,4,3,2,1};
        testSorts("Тест 5 (пузырьковая)", arr5, "sort");

        System.out.println("Тест с рандомным массивом");
        int[] randomArray = ArraysUtils.arrayRandom(50, 100);
        int[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);
        SortsUtils.sort(randomArrayCopy);
        System.out.println(Arrays.toString(randomArray) + " -> " + Arrays.toString(randomArrayCopy));

        System.out.println("Тест с массивом из консоли");
        int[] consoleArray = ArraysUtils.arrayFromConsole();
        int[] consoleArrayCopy = Arrays.copyOf(consoleArray, consoleArray.length);
        SortsUtils.shake(consoleArrayCopy);
        System.out.println(Arrays.toString(consoleArray) + " -> " + Arrays.toString(consoleArrayCopy));

    }
    private static void testSorts(String testName, int[] arr, String sortType) {
        int[] original = Arrays.copyOf(arr, arr.length);

        if ("sort".equals(sortType)) {
            SortsUtils.sort(arr);
        } else if ("shake".equals(sortType)) {
            SortsUtils.shake(arr);
        }
        System.out.println(testName + ": " + Arrays.toString(original) + " -> " + Arrays.toString(arr));
    }
}
