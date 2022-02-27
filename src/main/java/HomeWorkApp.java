public class HomeWorkApp {
    public static void main(String[] args) {
        //ДЗ 1 занятие
        System.out.println("Домашнее задание первого занятия");
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("--- ДЗ1 пункт 2 ---");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println();
    }

    public static void checkSumSign() {
        System.out.println("--- ДЗ1 пункт 3 ---");
        int a = 10;
        int b = -11;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
        System.out.println();
    }

    public static void printColor() {
        System.out.println("--- ДЗ1 пункт 4 ---");
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
        System.out.println();
    }

    public static void compareNumbers() {
        System.out.println("--- ДЗ1 пункт 5 ---");
        int a = 10;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
        System.out.println();
    }
}
