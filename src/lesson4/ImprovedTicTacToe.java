package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ImprovedTicTacToe {

    static final int SIZE = 5;
    static final int CHIPS = 3;

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final String HEADER_FIRST_EMPTY = "♥";
    static final String EMPTY = " ";


    static char[][] map = new char[SIZE][SIZE];
    static char[] win = new char[CHIPS];
    static char[] check = new char[SIZE];

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

        if(checkWin(symbol)) {
            String winMessage;

            if(symbol == DOT_HUMAN) {
                winMessage = "УРА! Вы победили!";
            }
            else {
                winMessage = "Восстание близко! AI победил";
            }

            isEnd = true;
            System.out.println(winMessage);
        }

        if(!isEnd && isMapFull()) {
            System.out.println("Ничья!");
            isEnd = true;
        }

        if(isEnd) {
            System.exit(0);
        }
    }

    private static boolean checkWin(char symbol) {
        Arrays.fill(win,symbol);
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(map[i], 0, check, 0, SIZE);
            if(Arrays.equals(check,win)) return true;
        }
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                check[i] = map[i][j];
            }
            if(Arrays.equals(check,win)) return true;
        }
        for (int i = 0, j = 0; i < SIZE; i++, j++) {
            check[i] = map[i][j];
        }
        if(Arrays.equals(check,win)) return true;
        for (int i = 0, j = SIZE - 1; i < SIZE; i++, j--) {
            check[i] = map[i][j];
        }
        if(Arrays.equals(check,win)) return true;
        return false;
    }

    private static boolean isMapFull() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                if(aChar == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void aiTurn() {
        int rowNumber;
        int colNumber;
        System.out.println("\nХод компьютера!\n");
        do {
            rowNumber = random.nextInt(SIZE) + 1;
            colNumber = random.nextInt(SIZE) + 1;
        } while (!isCellValid(rowNumber, colNumber, true));

        map[rowNumber - 1][colNumber - 1] = DOT_AI;
    }

    private static boolean checkRow (char[] row) {
        char[] buf = new char[CHIPS];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = row[i];
        }

        return false;
    }
}
