package Home_work_1.exercise4;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Number");
        int a = console.nextInt();
        System.out.println("Enter another number");
        int b = console.nextInt();
        System.out.println("Enter one more number");
        int c = console.nextInt();

        int res = (a + b + c) / 3;

        System.out.println("Avarage = " +res);

    }
}