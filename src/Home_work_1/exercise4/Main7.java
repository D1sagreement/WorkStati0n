package Home_work_1.exercise4;

import java.util.Scanner;

public  class Main7 {
    public static boolean chekDivisibility (int a, int b) {
        if (b == 0) {
            return  false;
        }
        return a % b == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter number: ");

            int a = scanner.nextInt();
            System.out.println("Enter another number: ");
            int b = scanner.nextInt();

            if (chekDivisibility(a, b)) {
                System.out.println(a + " divided by " +b); //разделенный на
                System.out.println("Result of division: " + (a / b)); // результат деления
            } else {
                System.out.println(a + "Not divisible by " + b); //Не делится на
                System.out.println("Remainder of division: " + (a % b)); //Остаток деления
            }

        } catch (Exception exception) {
            System.out.println("Error: Please enter valid numbers");
        } finally {
            scanner.close();
        }

    }
}
