package lesson7;

public class Test {

    public static void main(String[] args) {

        CatEx[] cats = new CatEx[6];
        cats[0] = new CatEx("Кит0");
        cats[1] = new CatEx("Кит1");
        cats[2] = new CatEx("Кит2");
        cats[3] = new CatEx("Кит3");
        cats[4] = new CatEx("Кит4");
        cats[5] = new CatEx("Кит5");


        PlateEx plate = new PlateEx(50);
        plate.addFood(70);
        plate.printInfo();

        for (CatEx catEx : cats) {
            catEx.eat(plate);
        }

        for (CatEx catEx : cats) {
            catEx.printSatiety();
        }
    }
}