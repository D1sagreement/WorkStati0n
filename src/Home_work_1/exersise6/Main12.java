package Home_work_1.exersise6;

import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваше имя ");
        String name = scanner.nextLine();

        if ("Вася".equals(name)) {
            System.out.println("Привет!");
            System.out.println("Я тебя так долго ждал!");
        } else if ("Анастасия".equals(name)) {
            System.out.println("Я тебя так долго ждал");
        } else {
            System.out.println("Добрый день, а вы кто");
        }

    }
}
