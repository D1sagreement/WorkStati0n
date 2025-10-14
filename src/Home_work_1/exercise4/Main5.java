package Home_work_1.exercise4;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        System.out.println("Enter number");
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        if ((a & 1) == 1) {
            System.out.println("Odd number"); //нечетное число
        } else {
            System.out.println("Even number"); //четное число
        }
    }
}