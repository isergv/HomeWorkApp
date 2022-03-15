package lesson2;

import lesson1.HomeWorkApp;

public class HomeWorkAppLesson2 {
    public static void main(String[] args) {
        System.out.println(whatSum(5, 10));
        positiveNumber(-5);
        System.out.println(positiveNumberBoolean(-4));
        numberOfLines("Тот-кого-нельзя-называть", 3);
        System.out.println(whatYear(1800));
    }

    //1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
    // (включительно), если да – вернуть true, в противном случае – false.
    public static boolean whatSum(int a, int b) {
        boolean c;
        if (a + b >= 10 && a + b <= 20) {
            c = true;
        } else {
            c = false;
        }
        return c;
    }

    //2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void positiveNumber(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    //3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    // если число отрицательное, и вернуть false если положительное.
    public static boolean positiveNumberBoolean(int a) {
        boolean b;
        if (a >= 0) {
            b = true;
        } else {
            b = false;
        }
        return b;
    }

    //4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль
    // указанную строку, указанное количество раз;
    public static void numberOfLines(String string, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(string);
        }
    }

    //5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean
    // (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го,
    // при этом каждый 400-й – високосный.
    public static boolean whatYear(int a) {
        int b = a % 400;
        int c = a % 100;
        int d = a % 4;
        boolean e = ((b == 0) || ((c != 0) && (d == 0)));
        return e;
    }
}
