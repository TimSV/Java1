package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ImprovedTicTacToe {

    static final int SIZE = 3;
    static final int CHIPS = 3;

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final String HEADER_FIRST_EMPTY = "♥";
    static final String EMPTY = " ";


    static char[][] map = new char[SIZE][SIZE];
    static char[] win = new char[CHIPS];

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        turnGame();

    }

    private static void turnGame() {
        initMap();
        printMap();
        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapRow();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_FIRST_EMPTY + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printMapRow() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void playGame() {

        while (true) {
            humanTurn();
            printMap();
            checkEnd(DOT_HUMAN);


            aiTurn();
            printMap();
            checkEnd(DOT_AI);
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод человека! Введите номер строки и столбца!");
        do {
            System.out.print("Строка = ");
            rowNumber = scanner.nextInt();
            System.out.print("Столбец = ");
            colNumber = scanner.nextInt();
        } while (!isCellValid(rowNumber, colNumber));

        map[rowNumber - 1][colNumber - 1] = DOT_HUMAN;
    }

    private static boolean isCellValid(int rowNumber, int colNumber, boolean isAI) {

        if (!isAI && ((rowNumber < 1) || (rowNumber > SIZE) || (colNumber < 1) || (colNumber > SIZE))) {
            System.out.println("\nПроверьте значения строки и столбца");
            return false;
        }

        if (map[rowNumber - 1][colNumber - 1] != DOT_EMPTY) {
            if (!isAI) {
                System.out.println("\nВы выбрали занятую ячейку");
            }
            return false;
        }

        return true;
    }

    private static boolean isCellValid(int rowNumber, int colNumber) {
        return isCellValid(rowNumber, colNumber, false);
    }

    private static void checkEnd(char symbol) {

        boolean isEnd = false;

        if (checkWin(symbol)) {
            String winMessage;

            if (symbol == DOT_HUMAN) {
                winMessage = "УРА! Вы победили!";
            } else {
                winMessage = "Восстание близко! AI победил";
            }

            isEnd = true;
            System.out.println(winMessage);
        }

        if (!isEnd && isMapFull()) {
            System.out.println("Ничья!");
            isEnd = true;
        }

        if (isEnd) {
            System.exit(0);
        }
    }

    private static boolean checkWin(char symbol) {
        char[] row = new char[SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                row[j] = map[i][j];
            }
            if (checkRow(row, symbol)) return true;
        }
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                row[i] = map[i][j];
            }
            if (checkRow(row, symbol)) return true;
        }
        for (int i = 0, j = 0; i < SIZE; i++, j++) {
            row[i] = map[i][j];
        }
        if (checkRow(row, symbol)) return true;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            row[i] = map[i][j];
        }
        return checkRow(row, symbol);
    }

    private static boolean isMapFull() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void aiTurn() {
        int rowNumber ;
        int colNumber;
        char[] row = new char[SIZE];

        System.out.println("\nХод компьютера!\n");

        for (int i = 0; i < SIZE; i++) {
            rowNumber = i;
            colNumber = checkRowAi(map[i]);
            if (colNumber > -1) {
                map[rowNumber][colNumber] = DOT_AI;
                return;
            }
        }

        for (int j = 0; j < SIZE; j++) {
            colNumber = j;
            for (int i = 0; i < SIZE; i++) {
                row[i] = map[i][j];
            }
            rowNumber = checkRowAi(row);
            if (rowNumber > -1) {
                map[rowNumber][colNumber] = DOT_AI;
                return;
            }
        }

        for (int i = 0, j = 0; i < SIZE; i++, j++) {
            row[i] = map[i][j];
        }
        colNumber = checkRowAi(row);
        if (colNumber > -1) {
            map[colNumber][colNumber] = DOT_AI;
            return;
        }

        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            row[i] = map[i][j];
        }
        colNumber = checkRowAi(row);
        if (colNumber > -1) {
            map[colNumber][SIZE - colNumber - 1] = DOT_AI;
            return;
        }

        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber, true));
        map[rowNumber - 1][colNumber - 1] = DOT_AI;

    }

    private static int checkRowAi(char[] row) {
        int index = -1, cnt = 0;

        for (int k = 0; k <= SIZE - CHIPS; k++) {
            int count = 0;
            for (int i = k; i < CHIPS + k; i++) {
                if (row[i] == DOT_HUMAN)
                    count++;
                if (row[i] == DOT_EMPTY)
                    index = i;
            }
            if (count >= CHIPS - 1) {
                cnt = count;
                break;
            }
        }
        return (cnt >= CHIPS - 1) ? index : -1;
    }

    private static boolean checkRow(char[] row, char symbol) {
        boolean res = false;
        char[] buf = new char[CHIPS];
        Arrays.fill(win, symbol);
        for (int k = 0; k <= SIZE - CHIPS; k++) {
            for (int i = 0; i < buf.length; i++) {
                buf[i] = row[i + k];
            }
            if (Arrays.equals(buf, win)) res = true;
        }
        return res;
    }
}
