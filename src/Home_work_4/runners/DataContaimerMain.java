package Home_work_4.runners;

import Home_work_4.comparators.IntegerComparator;
import Home_work_4.comparators.StringComporator;
import Home_work_4.comparators.StringLengthComparator;
import Home_work_4.container.DataContainer;

public class DataContaimerMain {
    public static void main(String[] args) {
        System.out.println("DataContainer");

        System.out.println("Строки");
        testStringContainer();
        System.out.println("Числа");
        testIntegerContainer();
        System.out.println("Особые случаи ");
        testCases();
    }

    private static void testStringContainer() {
        DataContainer<String> container = new DataContainer<>(new String[2]);
        System.out.println("Добавление элементов");
        int index1 = container.add("Привет");
        int index2 = container.add("Как дела");
        int index3 = container.add("Работаю");
        int index4 = container.add("Давай потом");

        System.out.println("Индексы добавленных элементов: " + index1 + ", " + index2 + ", " + index3 + ", " + index4);

        String text1 = container.get(index1);
        String text2 = container.get(index2);
        String text3 = container.get(index3);
        String text4 = container.get(index4);

        System.out.println("Элементы по индексам");
        System.out.println(index1 + text1);
        System.out.println(index2 + text2);
        System.out.println(index3 + text3);
        System.out.println(index4 + text4);

        System.out.println("Удаление элемента 'Привет'");
        boolean delete = container.delete("Привет");
        System.out.println("Удаление успешно " + delete);
        System.out.println("Контейнер после удаления " + container);

        System.out.println("Сортировка по длине строк:");
        container.sort(new StringLengthComparator());
        System.out.println("После сортировки по длине: " + container);

        System.out.println("Сортировка по алфавиту");
        container.sort(new StringComporator());
        System.out.println("После сортировки по длине " + container);
    }

    private static void testIntegerContainer() {
        DataContainer<Integer> container = new DataContainer<>(new Integer[0]);

        System.out.println("Добавление чисел");
        container.add(3);
        container.add(1);
        container.add(3);
        container.add(777);
        container.add(2);
        System.out.println("Исходный контейнер" + container);

        System.out.println("Сортировка чисел");
        container.sort(new IntegerComparator());
        System.out.println("После сортировки: " + container);

        System.out.println("Удаление элемента по индексу 2");
        boolean delete = container.delete(2);
        System.out.println("Удаление успешно " + delete);
        System.out.println("После удаления " + container);
    }

    private static void testCases() {
        System.out.println("Тест особыйх случаев");

        DataContainer<String> container = new DataContainer<>(new String[3]);
        container.add("Первый");
        container.add(null);
        container.add("Третий");

        System.out.println("После добавления null " + container);
        boolean res1 = container.delete("Несуществующий");
        System.out.println("Удаление несуществующего элемента " + res1);

        boolean res2 = container.delete(10);
        System.out.println("Удаление несуществующего элемента " + res2);

        DataContainer<String> emptyContainer = new DataContainer<>(new String[0]);
        System.out.println("Пустой контейнер " + emptyContainer);

        String[] items = container.getItems();
        System.out.println("Массив через getItemes()");
        for (int i = 0; i < items.length; i++) {
            System.out.println(" [" + i + "] = " + items[i]);
        }
    }
}
