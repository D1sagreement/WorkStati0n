package Home_Work_2F.sorts;

import Home_Work_2F.utils.ArraysUtils;
import java.util.Arrays;

public class SortsMain {
    public static void main(String[] args) {
        testArray(new int[]{1, 2, 3, 4, 5, 6}, "Пузырьковая");
        testArray(new int[]{1, 1, 1, 1}, "Шейкерная");
        testArray(new int[]{9, 1, 5, 99, 9, 9}, "Пузырьковая");
        testArray(new int[]{}, "Шейкерная");
        testArray(new int[]{6, 5, 4, 3, 2, 1}, "Пузырьковая");

        System.out.println("\nТест с рандомным массивом");
        int[] randomArray = ArraysUtils.arrayRandom(50, 100);
        int[] randomCopy = Arrays.copyOf(randomArray, randomArray.length);
        SortsUtils.sort(randomCopy);
        System.out.println(Arrays.toString(randomArray) + " -> " + Arrays.toString(randomCopy));

        System.out.println("\nТест с массивом из консоли");
        int[] consoleArray = ArraysUtils.arrayFromConsole();
        int[] consoleCopy = Arrays.copyOf(consoleArray, consoleArray.length);
        SortsUtils.shake(consoleCopy);
        System.out.println(Arrays.toString(consoleArray) + " -> " + Arrays.toString(consoleCopy));
    }

    private static void testArray(int[] arr, String sortType) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        if ("Пузырьковая".equals(sortType)) {
            SortsUtils.sort(copy);
        } else {
            SortsUtils.shake(copy);
        }

        System.out.println(Arrays.toString(arr) + " -> " + Arrays.toString(copy) + " (" + sortType + ")");
    }
}