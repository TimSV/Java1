package lesson6;

public class Animal {
    int limitRun;
    int limitSwim;
    double limitJump;
    String name;

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
