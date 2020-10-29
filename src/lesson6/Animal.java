package lesson6;

public class Animal {
    int limitRun;
    int limitSwim;
    float limitJump;
    String name;

    public void run(int length) {
        System.out.println("Смотри как бежит зверушка!");
    }

    public void jump(float length) {
        System.out.println("Зверушка перепрыгивает!");
    }

    public void swim(int length) {
        System.out.println("Зверушка плывёт!");
    }
}
