package Home_Work_2F.arrays;

public class ForOperation implements IArraysOperation {
    @Override
    public void printAllElements(int[] array) {
        System.out.print("Все элементы (for): ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void printEverySecondElement(int[] array) {
        System.out.print("Каждый второй элемент (for): ");
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void printReverseOrder(int[] array) {
        System.out.print("Обратный порядок (for): ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}