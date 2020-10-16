package Lesson2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        //---Первое задание-------------------------------
        int[] arr1 = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1};

        System.out.print("Массив из Первого задания - ");
        printArray(arr1);

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (arr1[i] == 0 ? 1 : 0);
        }
        System.out.print("Обработанный массив - ");
        printArray(arr1);

        //---Второе задание-------------------------------
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.print("Массив из второго задания - ");
        printArray(arr2);

        //---Третье задание-------------------------------
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Массив из третьего задания - ");
        printArray(arr3);
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
            }
        }
        System.out.print("Обработанный массив - ");
        printArray(arr3);

        //---Четвертое задание-------------------------------
        int[][] arr4 = {{1, 2, 3, 4,}, {5, 6, 7, 8}, {8, 7, 6, 5}, {4, 3, 5, 1}};
        System.out.println("Массив из четвертого задания - ");
        printQArray(arr4);
        int i = 0, j = 0, k = 0, n = 0;
        while (i < arr4.length) {
            arr4[i][j] = 1;
            arr4[k][arr4.length - n - 1] = 1;
            i++;
            j++;
            k++;
            n++;
        }
        System.out.println("Обработанный массив - ");
        printQArray(arr4);
        System.out.println(Arrays.deepToString(arr4));

        //---Пятое задание-------------------------------
        int min, max, length = 15;
        int[] arr5 = new int[length];
        for (i = 0; i < arr5.length; i++) {
            arr5[i] = (int) (Math.random() * 100);
        }
        min = arr5[0];
        max = arr5[0];
        for (int a : arr5) {
            if (a < min) {
                min = a;
            }
            if (a > max) {
                max = a;
            }
        }
        System.out.print("Массив из пятого задания - ");
        System.out.println(Arrays.toString(arr5));
        System.out.println("Минимальное значение  в нем - " + min);
        System.out.println("Максимальное значение  в нем - " + max);

        //---Шестое задание-------------------------------
        int[] arr6 = {10, 1, 2, 3, 4};
        if (checkBalance(arr6)) {
            System.out.println("Бинго!");
        } else {
            System.out.println("Nope!");
        }
        checkBalance2(arr6);

        checkBalance2(arr1);
        //---Седьмое задание----------------------------------------
        n = -1;
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.toString(arr7));
        rotate(arr7, n);

    }

    private static void rotate(int[] arr, int n) {
        int k;
        k = Math.abs(n) < arr.length ? n : n % arr.length;
        System.out.println("Массив сместился на: " + k);
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                int temp = arr[arr.length - 1];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[arr.length - 1 - j] = arr[arr.length - 2 - j];
                }
                arr[0] = temp;
            }
        } else {
            for (int i = 0; i > k; i--) {
                int temp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static boolean checkBalance(int[] arr) {
        int index, lSum, rSum;
        for (int i = 0; i < arr.length; i++) {
            index = 0;
            lSum = 0;
            rSum = 0;
            while (index <= i) {
                lSum = lSum + arr[index];
                index++;
            }
            while (index < arr.length) {
                rSum = rSum + arr[index];
                index++;
            }
            if (lSum == rSum) {
                return true;
            }
        }
        return false;
    }


    private static void checkBalance2(int[] arr) {
        int iStart = 0, iEnd = arr.length - 1;
        int sumStart = arr[iStart], sumEnd = arr[iEnd];
        while (iStart != iEnd - 1) {
            if (sumStart > sumEnd)
                sumEnd += arr[--iEnd];
            else
                sumStart += arr[++iStart];
        }
        System.out.print("Result of task 6: ");
        if (sumStart == sumEnd)
            System.out.printf("balance on %d-%d", iStart, iEnd);
        else
            System.out.print("no balance");
        System.out.println(" in " + Arrays.toString(arr));
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printQArray(int[][] arr) {
        for (int[] qArr : arr) {
            for (int i : qArr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}