package Home_Work_2F.arrays;

public class DoWhileOperation implements IArraysOperation {
    @Override
    public void printAllElements(int[] array) {
        System.out.print("Все элементы do-while: ");
        int i = 0;
        if (array.length > 0) {
            do {
                System.out.print(array[i] + " ");
                i++;
            } while (i < array.length);
        }
        System.out.println();
    }

    @Override
    public void printEverySecondElement(int[] array) {
        System.out.print("Каждый второй элемент do-while: ");
        int i = 1;
        if (array.length > 1) {
            do {
                System.out.print(array[i] + " ");
                i += 2;
            } while (i < array.length);
        }
        System.out.println();
    }

    @Override
    public void printReverseOrder(int[] array) {
        System.out.print("Обратный порядок do-while ");
        int i = array.length - 1;
        if (i >= 0) {
            do {
                System.out.print(array[i] + " ");
                i --;
            } while (i >= 0);
        }
        System.out.println();
    }

}
