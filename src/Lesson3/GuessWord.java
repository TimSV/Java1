package lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    static Scanner sc = new Scanner(System.in);
    static String word;
    static String wordTarget;
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape",  "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};


    public static void main (String[] args){

        Random rnd = new Random();

        wordTarget = words[rnd.nextInt(words.length)];
        System.out.println(wordTarget);
        System.out.println("Я загадал одно из этих слов: " + Arrays.toString(words));
        System.out.print("Введите загаданное слово - ");

        while (true) {
            word = getWord();
            checkWord(word);
        }

    }

    private static String getWord() {
        String word;
        do {
            word = sc.next();

        } while (!isContain(word));

        System.out.println("Вы ввели - " + word);
        return word;
    }

    private static boolean isContain(String word) {
        for (String str : words) {
            if (str.equals(word)) return true;
        }
        System.out.println("Такого слова нет всписке! Повторите попытку!");
        return false;
    }

    private static void checkWord(String word) {
        if (wordTarget.equals(word)) {
            System.out.println("Вы отгадали слово!");
            System.exit(0);
        }
        char [] promptWord = new char[15];
        int i = 0, lengthWord = 0;
        lengthWord =  word.length() < wordTarget.length() ? word.length() : wordTarget.length();

        for (; i < lengthWord; i++) {
            if (wordTarget.charAt(i) == word.charAt(i)){
                promptWord[i] = word.charAt(i);
            } else {
                promptWord[i] = '#';
            }
        }
        for (; i < promptWord.length; i++) {
            promptWord[i] = '#';
        }
        for (char ch : promptWord)
        System.out.print(ch);
        System.out.println();
    }
}
