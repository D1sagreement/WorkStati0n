package Home_Work_2F.arrays;

public class ForEachOperation implements IArraysOperation {
    @Override
    public void printAllElements(int[] array) {
        System.out.print("Все элементы foreach: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    @Override
    public void printEverySecondElement(int[] array) {
        System.out.print("Каждый второй элемент foreach: ");
        int counter = 0;
        for (int element : array) {
            if (counter % 2 == 1) {
                System.out.print(element + " ");
            }
            counter++;
        }
        System.out.println();
    }

    @Override
    public void printReverseOrder(int[] array) {
        System.out.print("Обратный порядок (foreach): ");
        System.out.print("требует дополнительного массива");
        System.out.println();
    }
}