package Home_Work_2F.arrays;

import Home_Work_2F.utils.ArraysUtils;

public class ArraysIteration {
    public static void main(String[] args) {
        int[] array = ArraysUtils.arrayFromConsole();

        System.out.println("\nDoWhile");
        DoWhileOperation doWhile = new DoWhileOperation();
        doWhile.printAllElements(array);
        doWhile.printEverySecondElement(array);
        doWhile.printReverseOrder(array);

        System.out.println("\nWhile");
        WhileOperation whileOp = new WhileOperation();
        whileOp.printAllElements(array);
        whileOp.printEverySecondElement(array);
        whileOp.printReverseOrder(array);

        System.out.println("\nFor");
        ForOperation forOp = new ForOperation();
        forOp.printAllElements(array);
        forOp.printEverySecondElement(array);
        forOp.printReverseOrder(array);

        System.out.println("\nForEach");
        ForEachOperation forEach = new ForEachOperation();
        forEach.printAllElements(array);
        forEach.printEverySecondElement(array);
        forEach.printReverseOrder(array);
    }
}