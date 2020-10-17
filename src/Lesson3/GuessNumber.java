package Lesson3;

import java.util.Scanner;

import static java.lang.Math.random;

/**
 * @author TimSV
 * @version 1.0
 */
public class GuessNumber {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numOfGuess;
        int targetNum;
        int live;

        System.out.println("Я хочу сыграть с тобой в одну игру...");
        System.out.println("Тебе предстоит угадать число от 0 до 9. На это у тебя есть три попытки");
        while (true) {
            numOfGuess = 3;
            boolean rightNum = false;
            targetNum = (int) (random() * 10);
            //System.out.println("Загаданное число - " + targetNum);

            while (numOfGuess > 0 && !rightNum) {
                rightNum = checkNum(targetNum, getNum());
                if (rightNum) {
                    System.out.println("Вы угадали число!");
                    break;
                } else {
                    System.out.println("Это фиаско!");
                }
                numOfGuess--;
            }
            System.out.println("Я загадывал число:" + targetNum);
            do {
                System.out.println("Повторить игру еще раз?\n1 – да\n0 – нет");
                while (!sc.hasNextInt()) {
                    System.out.println("Введенное значение не является числом!");
                    sc.next();
                }
                live = sc.nextInt();
            } while (live != 0 & live != 1);
            if (live == 0) break;
        }
    }

    private static boolean checkNum(int targetNum, int num) {
        boolean result = true;
        if (targetNum != num) {
            if (targetNum < num) System.out.println("Указанное число больше загаданного");
            else System.out.println("Указанное число меньше загаданного");
            result = false;
        }
        return result;
    }


    private static int getNum() {
        int userNum;
        do {
            System.out.println("Введите число от 0 до 9");
            while (!sc.hasNextInt()) {
                System.out.println("Введенное значение не является числом!");
                sc.next();
            }
            userNum = sc.nextInt();
        } while (userNum >= 0 ^ userNum <= 9);
        return userNum;
    }
}
