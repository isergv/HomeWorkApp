package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkAppLesson4 {

    private static final int SIZE = 8;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_PC = 'O';
    private static final char DOT_EMPTY = '•';
    private static final char[][] MAP = new char[SIZE][SIZE];

    public static void main(String[] args) {

        createMap();

        if (SIZE == 3) {
            while (true) {
                stepHuman();
                printMap();

                if (win(DOT_HUMAN)) {
                    System.out.println("Победа человека");
                    break;
                }
                if (canStep()) {
                    break;
                }

                stepPC();
                printMap();

                if (win(DOT_PC)) {
                    System.out.println("Победа PC");
                    break;
                }
                if (canStep()) {
                    break;
                }
            }
        } else if (SIZE > 3) {
            while (true) {
                stepHuman();
                printMap();

                if (win(DOT_HUMAN)) {
                    System.out.println("Победа человека");
                    break;
                }
                if (canStep()) {
                    break;
                }

                stepPC();
                printMap();

                if (win(DOT_PC)) {
                    System.out.println("Победа PC");
                    break;
                }
                if (canStep()) {
                    break;
                }
            }
        }
    }

    public static void headerMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }

    }

    public static void createMap() {
        headerMap();
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void stepHuman() {
        int x;
        int y;
        System.out.println("Введите координаты хода X и Y:");
        Scanner scanner = new Scanner(System.in);
        do {
            x = scanner.nextInt();
            y = scanner.nextInt();
            if ((x > 0 && x < SIZE + 1) && (y > 0 && y < SIZE + 1) && (MAP[x - 1][y - 1] == DOT_EMPTY)) {
                MAP[x - 1][y - 1] = DOT_HUMAN;
                break;
            } else System.out.println("Выбранная клетка занята, повторите попытку");
        }
        while (true);
    }

    public static void stepPC() {
        if (SIZE == 3) {
            int x;
            int y;
            System.out.println("Ход PC");
            Random random = new Random();
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
                if ((x > 0 && x <= SIZE) && (y > 0 && y <= SIZE) && (MAP[x - 1][y - 1] == DOT_EMPTY)) {
                    MAP[x - 1][y - 1] = DOT_PC;
                    break;
                } else System.out.println("Выбранная клетка занята, PC повторяет попытку");
            }
            while (true);
        } else if (SIZE > 4) {

            /*
                  Подсчитываем количество возможных ходов PC рядом с ходами человека
                  Возможным ходом считается координата рядом с DOT_HUMAN (по горизонтали/вертикали/диагонали)
                  со значением DOT_EMPTY
            */

            int potentialMove = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    //1
                    if ((i > 0) && MAP[i][j] == DOT_HUMAN && MAP[i - 1][j] == DOT_EMPTY) {
                        potentialMove++;
                    }
                    //2
                    if ((i > 0) && (j < SIZE - 1) && MAP[i][j] == DOT_HUMAN && MAP[i - 1][j + 1] == DOT_EMPTY) {
                        potentialMove++;
                    }
                    //3
                    if ((j < SIZE - 1) && MAP[i][j] == DOT_HUMAN && MAP[i][j + 1] == DOT_EMPTY) {
                        potentialMove++;
                    }
                    //4
                    if ((i < SIZE - 1) && (j < SIZE - 1) && MAP[i][j] == DOT_HUMAN && MAP[i + 1][j + 1] == DOT_EMPTY) {
                        potentialMove++;
                    }
                    //5
                    if ((i < SIZE - 1) && MAP[i][j] == DOT_HUMAN && MAP[i + 1][j] == DOT_EMPTY) {
                        potentialMove++;
                    }
                    //6
                    if ((i < SIZE - 1) && (j > 0) && MAP[i][j] == DOT_HUMAN && MAP[i + 1][j - 1] == DOT_EMPTY) {
                        potentialMove++;
                    }
                    //7
                    if ((j > 0) && MAP[i][j] == DOT_HUMAN && MAP[i][j - 1] == DOT_EMPTY) {
                        potentialMove++;
                    }
                    //8
                    if ((i > 0) && (j > 0) && MAP[i][j] == DOT_HUMAN && MAP[i - 1][j - 1] == DOT_EMPTY) {
                        potentialMove++;
                    }
                }
            }

            /*
            Объявляем двумерный массив, в который будем заносить все шаги PC в соответствии с ходами человека
            Массив состоит из 3 колонок и potentialMove строк
            В первой колонке значение идущих подряд ходов человека
            Во второй колонке координата потенциального хода PC по горизонтали
            В третьей колонке координата потенциального хода PC по вертикали
            Пример -
            •••••
            ••ХХ•
            •••••
            В строки массива запишутся данные:
            1, 0, 1
            1, 0, 2
            1, 0, 3
            1, 0, 4
            2, 1, 4
            2, 1, 1
            1, 2, 1
            1, 2, 2
            1, 2, 3
            1, 2, 4
            Т.е. будет 10 потенциальных ходов PC
            */

            int[][] potentialMovePC = new int[potentialMove][3];

            /*
                   Заполняем массив potentialMovePC данными. Для этого необходимо пройти по всему игровому полю
                   и найти все потенциальные координаты хода PC с учетом того,
                   как много ходов человека DOT_HUMAN идут подряд (по горизонтали/вертикали/диагонали)
             */
            int potentialMovePCStep = 0;



            /*
                    Если текущая координата = DOT_HUMAN и следующая координата = DOT_EMPTY
                    записываем в массив potentialMovePC moveManTemp++, координату хода PC по x и по y

            */
            //Поиск ходов по горизонталям слева направо
            for (int i = 0; i < SIZE; i++) {
                int moveMan = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (j < SIZE - 1 && MAP[i][j] == DOT_HUMAN && MAP[i][j + 1] == DOT_EMPTY) {
                        moveMan++;
                        potentialMovePC[potentialMovePCStep][0] = moveMan;
                        potentialMovePC[potentialMovePCStep][1] = i;
                        potentialMovePC[potentialMovePCStep][2] = j + 1;
                        potentialMovePCStep++;
                    }
                    if (j < SIZE - 1 && MAP[i][j] == DOT_HUMAN && MAP[i][j + 1] == DOT_HUMAN) {
                        moveMan++;
                    } else moveMan = 0;
                }
            }

            //Поиск ходов по горизонталям справа налево
            for (int i = 0; i < SIZE; i++) {
                int moveMan = 0;
                for (int j = SIZE - 1; j >= 0; j--) {
                    if (j > 0 && MAP[i][j] == DOT_HUMAN && MAP[i][j - 1] == DOT_EMPTY) {
                        moveMan++;
                        potentialMovePC[potentialMovePCStep][0] = moveMan;
                        potentialMovePC[potentialMovePCStep][1] = i;
                        potentialMovePC[potentialMovePCStep][2] = j - 1;
                        potentialMovePCStep++;
                    }
                    if (j > 0 && MAP[i][j] == DOT_HUMAN && MAP[i][j - 1] == DOT_HUMAN) {
                        moveMan++;
                    } else moveMan = 0;
                }
            }

            //Поиск ходов по вертикалям сверху вниз
            for (int j = 0; j < SIZE; j++) {
                int moveMan = 0;
                for (int i = 0; i < SIZE; i++) {
                    if (i < SIZE - 1 && MAP[i][j] == DOT_HUMAN && MAP[i + 1][j] == DOT_EMPTY) {
                        moveMan++;
                        potentialMovePC[potentialMovePCStep][0] = moveMan;
                        potentialMovePC[potentialMovePCStep][1] = i + 1;
                        potentialMovePC[potentialMovePCStep][2] = j;
                        potentialMovePCStep++;
                    }
                    if (i < SIZE - 1 && MAP[i][j] == DOT_HUMAN && MAP[i + 1][j] == DOT_HUMAN) {
                        moveMan++;
                    } else moveMan = 0;
                }
            }

            //Поиск ходов по вертикалям снизу вверх
            for (int j = 0; j < SIZE; j++) {
                int moveMan = 0;
                for (int i = SIZE - 1; i >= 0; i--) {
                    if (i > 0 && MAP[i][j] == DOT_HUMAN && MAP[i - 1][j] == DOT_EMPTY) {
                        moveMan++;
                        potentialMovePC[potentialMovePCStep][0] = moveMan;
                        potentialMovePC[potentialMovePCStep][1] = i - 1;
                        potentialMovePC[potentialMovePCStep][2] = j;
                        potentialMovePCStep++;
                    }
                    if (i > 0 && MAP[i][j] == DOT_HUMAN && MAP[i - 1][j] == DOT_HUMAN) {
                        moveMan++;
                    } else moveMan = 0;
                }
            }

            //Поиск ходов диагоналям \ сверху вниз
            for (int i = 0; i < SIZE; i++) {
                int a = 0;
                if (i == 0) {
                    int sizeTemp = SIZE - 1;
                    for (int iTemp = 0; iTemp < SIZE; iTemp++) {
                        int moveMan = 0;
                        for (int j = 0; j < sizeTemp; j++) {
                            if (j + 1 < SIZE && MAP[j][j + iTemp] == DOT_HUMAN && MAP[j + 1][j + iTemp + 1] == DOT_EMPTY) {
                                moveMan++;
                                potentialMovePC[potentialMovePCStep][0] = moveMan;
                                potentialMovePC[potentialMovePCStep][1] = j + 1;
                                potentialMovePC[potentialMovePCStep][2] = j + iTemp + 1;
                                potentialMovePCStep++;
                            }
                            if (j + 1 < SIZE && MAP[j][j + iTemp] == DOT_HUMAN && MAP[j + 1][j + iTemp + 1] == DOT_HUMAN) {
                                moveMan++;
                            } else moveMan = 0;
                        }
                        sizeTemp--;
                    }
                }
                if (i > 0) {
                    int moveMan = 0;
                    int sizeTemp = SIZE - 1;
                    for (int j = 0; j < sizeTemp - i; j++) {
                        if (MAP[j + i][j] == DOT_HUMAN && MAP[j + i + 1][j + 1] == DOT_EMPTY) {
                            moveMan++;
                            potentialMovePC[potentialMovePCStep][0] = moveMan;
                            potentialMovePC[potentialMovePCStep][1] = j + i + 1;
                            potentialMovePC[potentialMovePCStep][2] = j + 1;
                            potentialMovePCStep++;
                        }
                        if (MAP[j + i][j] == DOT_HUMAN && MAP[j + i + 1][j + 1] == DOT_HUMAN) {
                            moveMan++;
                        } else moveMan = 0;
                    }
                }
            }

            //Поиск ходов диагоналям / сверху вниз
            for (int i = 0; i < SIZE; i++) {
                if (i == 0) {
                    int moveMan = 0;
                    int sizeTemp = SIZE - 1;
                    for (int iTemp = 0; iTemp <= sizeTemp; sizeTemp--) { //Решили, сколько будет проходок
                        int a = 0; //По И всегда стартуем с 0
                        for (int j = sizeTemp; j >= 0; j--) {
                            if (j - 1 >= 0 && MAP[a][j] == DOT_HUMAN && MAP[a + 1][j - 1] == DOT_EMPTY) {
                                moveMan++;
                                potentialMovePC[potentialMovePCStep][0] = moveMan;
                                potentialMovePC[potentialMovePCStep][1] = a + 1;
                                potentialMovePC[potentialMovePCStep][2] = j - 1;
                                potentialMovePCStep++;
                            }
                            if (j - 1 >= 0 && MAP[a][j] == DOT_HUMAN && MAP[a + 1][j - 1] == DOT_HUMAN) {
                                moveMan++;
                            } else moveMan = 0;
                            a++;
                        }
                    }
                }
                if (i > 0) {
                    int moveMan = 0;
                    int b = 0;
                    for (int j = SIZE - 1; j > 0; j--) {
                        if (i + b < SIZE - 1 && MAP[i + b][j] == DOT_HUMAN && MAP[i + b + 1][j - 1] == DOT_EMPTY) {
                            moveMan++;
                            potentialMovePC[potentialMovePCStep][0] = moveMan;
                            potentialMovePC[potentialMovePCStep][1] = i + b + 1;
                            potentialMovePC[potentialMovePCStep][2] = j - 1;
                            potentialMovePCStep++;
                        }
                        if (i + b < SIZE - 1 && MAP[i + b][j] == DOT_HUMAN && MAP[i + b + 1][j - 1] == DOT_HUMAN) {
                            moveMan++;
                        } else moveMan = 0;
                        b++;
                    }
                }
            }

            //Поиск ходов диагоналям / снизу вверх
            for (int i = SIZE - 1; i >= 0; i--) {
                if (i == SIZE - 1) {
                    int moveMan = 0;
                    int b = 0;
                    for (int iTemp = 0; iTemp < SIZE - 1; iTemp++) {  //кол-во проходок
                        int a = SIZE - 1;
                        for (int j = b; j < SIZE - 1; j++) {
                            if (/*a - 1 <= 0 && j + 1 < SIZE - 1 && */MAP[a][j] == DOT_HUMAN && MAP[a - 1][j + 1] == DOT_EMPTY) {
                                moveMan++;
                                potentialMovePC[potentialMovePCStep][0] = moveMan;
                                potentialMovePC[potentialMovePCStep][1] = a - 1;
                                potentialMovePC[potentialMovePCStep][2] = j + 1;
                                potentialMovePCStep++;
                            }
                            if (/*a - 1 <= 0 && j + 1 < SIZE - 1 && */MAP[a][j] == DOT_HUMAN && MAP[a - 1][j + 1] == DOT_HUMAN) {
                                moveMan++;
                            } else moveMan = 0;
                            a--;
                        }
                        b++;
                    }
                }
                if (i < SIZE - 1) {
                    int moveMan = 0;
                    int sizeTemp = SIZE - 1;
                    int a = i;
                    for (int j = 0; j < sizeTemp; j++) {
                        if (a - 1 >= 0 && MAP[a][j] == DOT_HUMAN && MAP[a - 1][j + 1] == DOT_EMPTY) {
                            moveMan++;
                            potentialMovePC[potentialMovePCStep][0] = moveMan;
                            potentialMovePC[potentialMovePCStep][1] = a - 1;
                            potentialMovePC[potentialMovePCStep][2] = j + 1;
                            potentialMovePCStep++;
                        }
                        if (a - 1 >= 0 && MAP[i][j] == DOT_HUMAN && MAP[i - 1][j + 1] == DOT_HUMAN) {
                            moveMan++;
                        } else moveMan = 0;
                        a--;
                    }
                }
            }

            //Поиск ходов диагоналям \ снизу вверх
            for (int i = SIZE - 1; i >= 0; i--) {
                if (i == SIZE - 1) {
                    int moveMan = 0;
                    int b = SIZE - 1;
                    for (int iTemp = 0; iTemp <= SIZE - 1; iTemp++) { //кол-во проходок
                        int a = SIZE - 1;
                        for (int j = b; j >= 0; j--) {
                            if (a - 1 >= 0 && j - 1 >= 0 && MAP[a][j] == DOT_HUMAN && MAP[a - 1][j - 1] == DOT_EMPTY) {
                                moveMan++;
                                potentialMovePC[potentialMovePCStep][0] = moveMan;
                                potentialMovePC[potentialMovePCStep][1] = a - 1;
                                potentialMovePC[potentialMovePCStep][2] = j - 1;
                                potentialMovePCStep++;
                            }
                            if (a - 1 >= 0 && j - 1 >= 0 && MAP[a][j] == DOT_HUMAN && MAP[a - 1][j - 1] == DOT_HUMAN) {
                                moveMan++;
                            } else moveMan = 0;
                            a--;
                        }
                        b--;
                    }
                }
                if (i < SIZE - 1) {
                    int moveMan = 0;
                    int a = 0;
                    for (int j = SIZE - 1; j >= SIZE - 1 - i; j--) {
                        if (i - a - 1 >= 0 && MAP[i - a][j] == DOT_HUMAN && MAP[i - a - 1][j - 1] == DOT_EMPTY) {
                            moveMan++;
                            potentialMovePC[potentialMovePCStep][0] = moveMan;
                            potentialMovePC[potentialMovePCStep][1] = i - a - 1;
                            potentialMovePC[potentialMovePCStep][2] = j - 1;
                            potentialMovePCStep++;
                        }
                        if (i - a - 1 >= 0 && MAP[i - a][j] == DOT_HUMAN && MAP[i - a - 1][j - 1] == DOT_HUMAN) {
                            moveMan++;
                        } else moveMan = 0;
                        a++;
                    }
                }
            }


            //Пoиск самого большого числа в масииве возможных ходов PC
            int bestLineHumanLength = 0;
            for (int i = 0; i < potentialMove; i++) {
                if (potentialMovePC[i][0] > bestLineHumanLength) {
                    bestLineHumanLength = potentialMovePC[i][0];
                }
            }

            //Считаем колличество самых больших чисел в массиве
            int numberBestLineHumanLength = 0;
            for (int i = 0; i < potentialMove; i++) {
                if (potentialMovePC[i][0] == bestLineHumanLength) {
                    numberBestLineHumanLength++;
                }
            }

            //Создаем матрицу для выборки лучших ходов
            int[][] bestMovePC = new int[numberBestLineHumanLength][3];
            int bestMovePCNumber = 0;
            for (int i = 0; i < potentialMove; i++) {
                if (potentialMovePC[i][0] == bestLineHumanLength) {
                    bestMovePC[bestMovePCNumber][0] = potentialMovePC[i][0];
                    bestMovePC[bestMovePCNumber][1] = potentialMovePC[i][1];
                    bestMovePC[bestMovePCNumber][2] = potentialMovePC[i][2];
                    bestMovePCNumber++;
                }
            }

            int stepPC = (int) (Math.random() * (numberBestLineHumanLength));
            int x = bestMovePC[stepPC][1];
            int y = bestMovePC[stepPC][2];
            MAP[x][y] = DOT_PC;
        }
    }

    public static boolean checkCanStep() {  //Проверка возможности сделать еще 1 ход. false - можно, true - хэппи энд
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean canStep() {
        if (checkCanStep()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    public static void printMap() {
        headerMap();
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(char dot) {  //Победы
        if (SIZE == 3) {
            //проверка победы по горизонталям
            for (int i = 0; i < SIZE; i++) {
                int win = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[i][j] == dot) {
                        win++;
                    }
                    if (win == SIZE) {
                        return true;
                    }
                    if (MAP[i][j] != dot) {
                        win = 0;
                    }
                }
            }

            //проверка победы по вертикалям
            for (int i = 0; i < SIZE; i++) {
                int win = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[j][i] == dot) {
                        win++;
                    }
                    if (win == SIZE) {
                        return true;
                    }
                    if (MAP[j][i] != dot) {
                        win = 0;
                    }
                }
            }

            //проверка победы по диагонали \
            int win = 0;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[j][j] == dot) {
                    win++;
                }
                if (win == SIZE) {
                    return true;
                }
                if (MAP[j][j] != dot) {
                    win = 0;
                }
            }

            //проверка победы по диагонали /
            win = 0;
            int a = SIZE - 1;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[a][j] == dot) {
                    win++;
                    a--;
                }
                if (win == SIZE) {
                    return true;
                }
                if (MAP[a][j] != dot) {
                    win = 0;
                }
            }
        } else if (SIZE > 4) {

            //проверка победы по горизонталям
            for (int i = 0; i < SIZE; i++) {
                int win = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[i][j] == dot) {
                        win++;
                    }
                    if (win == 4) {
                        return true;
                    }
                    if (MAP[i][j] != dot) {
                        win = 0;
                    }
                }
            }

            //проверка победы по вертикалям
            for (int i = 0; i < SIZE; i++) {
                int win = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[j][i] == dot) {
                        win++;
                    }
                    if (win == 4) {
                        return true;
                    }
                    if (MAP[j][i] != dot) {
                        win = 0;
                    }
                }
            }

            //проверка победы по диагонали \
            for (int i = 0; i < SIZE; i++) {
                if (i == 0) {
                    int win = 0;
                    int a = 0;
                    for (int iTemp = 0; iTemp < SIZE; iTemp++) {
                        for (int j = a; j < SIZE; j++) {
                            if (MAP[j - a][j] == dot) {
                                win++;
                            }
                            if (win == 4) {
                                return true;
                            }
                            if (MAP[j - a][j] != dot) {
                                win = 0;
                            }
                        }
                        a++;
                    }
                }
                if (i != 0) {
                    int win = 0;
                    for (int j = 0; j < SIZE; j++) {
                        if (j + i < SIZE && MAP[j + i][j] == dot) {
                            win++;
                        }
                        if (win == 4) {
                            return true;
                        }
                        if (j + i < SIZE && MAP[j + i][j] != dot) {
                            win = 0;
                        }
                    }
                }
            }

            //проверка победы по диагонали /
            for (int i = 0; i < SIZE; i++) {
                if (i == 0) {
                    int win = 0;
                    int sizeTemp = SIZE - 1;
                    for (int iTemp = 0; iTemp <= sizeTemp; sizeTemp--) {
                        int a = 0;
                        for (int j = sizeTemp; j >= 0; j--) {
                            if (j - 1 >= 0 && MAP[a][j] == dot) {
                                win++;
                            }
                            if (win == 4) {
                                return true;
                            }
                            if (j - 1 >= 0 && MAP[a][j] != dot) {
                                win = 0;
                            }
                            a++;
                        }
                    }
                }
                if (i > 0) {
                    int win = 0;
                    int b = 0;
                    for (int j = SIZE - 1; j > 0; j--) {
                        if (i + b < SIZE - 1 && MAP[i + b][j] == dot) {
                            win++;
                        }
                        if (win == 4) {
                            return true;
                        }
                        if (i + b < SIZE - 1 && MAP[i + b][j] != dot) {
                            win = 0;
                        }
                        b++;
                    }
                }
            }
        }
        return false;
    }

    public static boolean win(char dot) {
        return checkWin(dot);
    }
}

