package Lesson1;

public class Task1 {
    public static void main(String[] args) {

        //----------------------------------------------
        //---Второе задание-----------------------------
        byte b = 8;
        short sh = 16;
        int count = 0;
        long l = 64;
        float f = 32.32f;
        double res = 64.64;
        char ch = 32;
        boolean is = true;

        //---Третье задание-----------------------------------------------------------
        res = calc(1, 2, 3, 4);
        System.out.println("Результат - " + res);

        //---Четвертое задание--------------------------------------------------------
        is = check(10, 9);

        //---Пятое задание--------------------------------------------------------
        PositiveOrNegative(-100);

        //---Шестое задание------------------------------------------------------
        negative(-1);

        //---Седьмое задание------------------------------------------------------
        Hi("Уааасяяя");

        //---Бонусное задание-----------------------------------------------
        for (int i = 0; i < 100; i++) {
            LeapYear(i);
        }

        for (int i = 0; i < 2100; i++) {
            isLeapYear(i);
        }

    }

    public static double calc(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    public static boolean check(double a, double b) {
        double sum;
        boolean res = false;
        sum = a + b;
        if (sum >= 10 && sum <= 20) {
            res = true;
            System.out.println("Число " + sum + " находится в диапазоне от 10 до 20");
        } else {
            System.out.println("Число " + sum + " не находится в диапазоне от 10 до 20");
        }
        return res;
    }

    public static void PositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " является положительным");
        } else {
            System.out.println("Число " + a + " является отрицательным");
        }
    }

    public static boolean negative(int a) {
        boolean negative = false;
        if (a < 0) {
            System.out.println("Число " + a + " является отрицательным");
            negative = true;
        }
        return negative;
    }

    public static void Hi(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void LeapYear(int year) {
        boolean leap = false;
        if (year % 400 == 0) {
            leap = true;
        } else {
            if (year % 100 != 0) {
                if (year % 4 == 0) {
                    leap = true;
                }
            }
        }

        if (leap) {
            System.out.println(year + " год високосный");
        } else {
            System.out.println(year + " год невисокосный");
        }
    }

    public static void isLeapYear(int year) {
        if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
            System.out.println(year + " год не високосный");
            return;
        }
        System.out.println(year + " год високосный");
    }

}