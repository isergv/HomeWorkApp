package lesson3;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkAppLesson3 {
    public static void main(String[] args) {
        one();
        two();
        tree();
        four();
        fifth();
        six();
        seven();
        eight();
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void one() {
        System.out.println("-------- Задание 1 --------");
        int[] myArray = new int[10];
        Random random = new Random();
        System.out.println("Заданый массив:");
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(2);
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        System.out.println("Обработанный массив:");
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == 1) {
                myArray[i] = 0;
            } else {
                myArray[i] = 1;
            }
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }

    // 2. Задать пустой целочисленный массив длиной 100.
    // С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    public static void two() {
        System.out.println("-------- Задание 2 --------");
        int[] myArray = new int[100];
        System.out.println("Сгенерированный массив:");
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i + 1;
            System.out.print(myArray[i] + " ");
        }
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void tree() {
        System.out.println();
        System.out.println("-------- Задание 3 --------");
        int[] myArray = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Заданый массив:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        System.out.println("Обработанный массив:");
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] < 6) {
                myArray[i] = myArray[i] * 2;
            }
            System.out.print(myArray[i] + " ");
        }
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    // если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
    // индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    public static void four() {
        System.out.println();
        System.out.println("-------- Задание 4 --------");
        int[][] myArray = new int[10][10];
        System.out.println("Заданый массив:");
        int arrayLenght = myArray.length;
        for (int i = 0; i < myArray.length; i++) {
            arrayLenght = arrayLenght - 1;
            for (int j = 0; j < myArray.length; j++) {
                if (i == j) {
                    myArray[i][j] = 1;
                }
                myArray[i][arrayLenght] = 1;
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 5. Написать метод, принимающий на вход два аргумента: len и initialValue,
    // и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    public static void fifth() {
        System.out.println();
        System.out.println("-------- Задание 5 --------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте длину массива ");
        int len = scanner.nextInt();
        System.out.println("Задайте данные массива ");
        int initialValue = scanner.nextInt();
        int[] myArray = new int[len];
        System.out.println("Полученный массив:");
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = initialValue;
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }

    // 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы;
    public static void six() {
        System.out.println();
        System.out.println("-------- Задание 6 --------");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте длину массива ");
        int len = scanner.nextInt();
        int[] myArray = new int[len];
        int myArrayMin = len;
        int myArrayMax = -1;
        System.out.println("Сгенерированный масиив:");
        for (int i = 0; i < len; i++) {
            myArray[i] = random.nextInt(len);
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < len; i++) {
            if (myArray[i] < myArrayMin) {
                myArrayMin = myArray[i];
            }
            if (myArray[i] > myArrayMax) {
                myArrayMax = myArray[i];
            }
        }
        System.out.println("Минимальное значение в массиве = " + myArrayMin);
        System.out.println("Максимальное значение в массиве = " + myArrayMax);
    }

    // 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    //**Примеры:
    //checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
    //checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
    //
    //граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
    public static void seven() {
        System.out.println();
        System.out.println("-------- Задание 7 --------");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте длину массива ");
        int len = scanner.nextInt();
        int[] myArray = new int[len];
        boolean check = false;
        System.out.println("Сгенерированный масиив:");
        for (int i = 0; i < len; i++) {
            myArray[i] = random.nextInt(2);
            //myArray[i] = random.nextInt(len);
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        int myArrayLeft = 0;
        for (int i = 0; i < len - 1; i++) {
            int myArrayRight = 0;
            myArrayLeft = myArrayLeft + myArray[i];
            for (int j = i; j < len - 1; j++) {
                myArrayRight = myArrayRight + myArray[j + 1];
            }
            if (myArrayLeft == myArrayRight) {
                check = true;
                System.out.println("Результат " + check);
            }
        }
    }

    // 8. *** Написать метод, которому на вход подается одномерный массив и число n
    // (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
    // Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    // При каком n в какую сторону сдвиг можете выбирать сами.
    public static void eight() {
        System.out.println();
        System.out.println("-------- Задание 8 --------");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте длину массива ");
        int len = scanner.nextInt();
        int temp;
        System.out.println("Задайте смещение массива ");
        int n = scanner.nextInt();
        int[] myArray = new int[len];
        System.out.println("Сгенерированный масиив:");
        for (int i = 0; i < len; i++) {
            myArray[i] = random.nextInt(len);
            System.out.print(myArray[i] + " ");
        }
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                temp = myArray[len - 1];
                for (int j = len; j > 1; j--) {
                    myArray[j - 1] = myArray[j - 2];
                }
                myArray[0] = temp;
            }
        } else {
            for (int i = 0; i < Math.abs(n); i++) {
                temp = myArray[0];
                for (int j = 0; j < len - 1; j++) {
                    myArray[j] = myArray[j + 1];
                }
                myArray[len - 1] = temp;
            }
        }
        System.out.println();
        System.out.println("Обработанный массив:");
        for (int i = 0; i < len; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
}

