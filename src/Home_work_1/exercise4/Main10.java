package Home_work_1.exercise4;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        if (a(year)) {
            System.out.println(year + "leap year");
        } else {
            System.out.println(year + "it's not a leap year");
        }

        scanner.close();
    }

    public static boolean a(int year) {
        //Год вискоксный если:
        //Делится на 4 &&
        //Не делится на 100 || делится на 400)
        return (year % 4 == 0) && (year % 100 != 0 || year %400 == 0);
    }
}