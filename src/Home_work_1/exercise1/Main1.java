package Home_work_1.exercise1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter number");
        int a = console.nextInt(); //двоичный вид: 1 1000 (число 30)
        System.out.println("Enter another number");
        int b = console.nextInt(); //двоичный вид: 1 0000 (число 20)

        int res1 = a & b;
        int res2 = a | b;

        System.out.println(res1);
        System.out.println(res2);
    }
}