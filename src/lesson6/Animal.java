package lesson6;

public class Animal {
    protected int limitRun;
    protected int limitSwim;
    protected double limitJump;
    protected String name;

    public void run(int length) {
        System.out.println("Смотри как бежит зверушка!");
    }

    public void swim(int length) {
        System.out.println("Зверушка плывёт!");
    }

    public void jump(int length) {
        System.out.println("Зверушка перепрыгивает!");
    }
}
