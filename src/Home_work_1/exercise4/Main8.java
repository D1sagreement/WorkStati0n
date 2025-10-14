package Home_work_1.exercise4;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select conversion:");
        System.out.println("1 - Bytes to kilobytes");
        System.out.println("2 - Kilobytes to bytes");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: //для первого выбора
                System.out.print("Enter number of bytes: ");
                int bytes = scanner.nextInt();
                double kb = bytes / 1024.0;
                System.out.println(bytes + " byte = " + kb + " kb");
                break;

            case 2: //для второго выбора
                System.out.print("Enter the number of kilobytes: ");
                double kilobytes = scanner.nextDouble();
                int resultBytes = (int) (kilobytes * 1024);
                System.out.println(kilobytes + " kb = " + resultBytes + " byte");
                break;

            default: //если был выбран выбор конверции которого нету
                System.out.println("error choice");
        }
    }
}