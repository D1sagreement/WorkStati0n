package Home_Work_2F.arrays;

public class WhileOperation implements IArraysOperation {
    @Override
    public void printAllElements(int[] array) {
        System.out.print("Все элементы while: ");
        int i = 0;
        while (i < array.length) {
            System.out.print(array[i] + " ");
            i++;
        }
        System.out.println();
    }

    @Override
    public void printEverySecondElement(int[] array) {
        System.out.print("Каждый второй элемент while: ");
        int i = 1;
        while (i < array.length) {
            System.out.print(array[i] + " ");
            i+= 2;
        }
        System.out.println();
    }

    @Override
    public void printReverseOrder(int[] array) {
        System.out.print("Обратный порядок while: ");
        int i = array.length - 1;
        while (i >= 0) {
            System.out.print(array[i] + " ");
            i--;
        }
        System.out.println();
    }
}
