package Home_Work_2F.utils;

import java.util.Random;
import java.util.Scanner;

public class ArraysUtils {
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
