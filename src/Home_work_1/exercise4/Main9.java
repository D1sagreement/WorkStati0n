package Home_work_1.exercise4;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enet a character: ");
        char a = scanner.next().charAt(0);

        System.out.println("Symbol analysis: " + a + " ");
        System.out.println("Unicode code: " + (int) a);

        if (Character.isLetter(a)) {
            System.out.println("Yes it's a LETTER");
            System.out.println("Capital: " + Character.isUpperCase(a));
            System.out.println("Lowercase " + Character.isUpperCase(a));

        } else if (Character.isDigit(a)) {
            System.out.println("Yes this is a NUMBER");
        } else if (Character.isWhitespace(a)) {
            System.out.println("Yes it's space");
        } else if (Character.isLetterOrDigit(a)) {
            System.out.println("Yes LETTER or NUMBER");
        } else {
            System.out.println("Yes, this is ANOTHER Symbol");
        }


    }
}