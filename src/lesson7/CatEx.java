package lesson7;

import java.util.Random;

public class CatEx extends Cat {

    private static int MIN_APP = 5;
    private static int DELTA_APP = 15;
    private boolean satiety;
    private static Random rnd = new Random();


    public CatEx(String name) {
        super(name, iniApp());
    }

    private static int iniApp() {
        return MIN_APP + rnd.nextInt(DELTA_APP);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getAppetite() {
        return super.getAppetite();
    }

    @Override
    public String toString() {
        return "Котик " + getName() + " любит кушать " + getAppetite() + " еды!";
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void eat(Plate plate) {
        System.out.println("Котик " + getName() + " подошел к миске");
        if (plate.getFood() >= getAppetite()) {
            plate.decreaseFood(getAppetite());
            satiety = true;
            System.out.println("Котик " + getName() + " скушал " + getAppetite() + " еды");
            plate.printInfo();
        } else {
            System.out.println("Мне нужна еда!");
        }
    }

    public void printInfo() {
        System.out.println(toString());
    }

    private boolean getSatiety() {
        return satiety;
    }

    public void printSatiety() {
        String satiety = " голоден";
        if (getSatiety()) {
            satiety = " сыт";
        }
        System.out.println("Котик " + getName() + satiety);
    }

}
