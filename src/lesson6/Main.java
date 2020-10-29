package lesson6;

public class Main {
    public static void main(String[] args) {
        Dog rex = new Dog("Рекс");

        rex.run(100);
        rex.run(900);
        rex.jump(0.2f);
        rex.jump(1.5f);
        rex.swim(5);
        rex.swim(15);


        Animal kit = new Cat("Кит");
        kit.run(10);
        kit.run(300);
        kit.jump(1.5f);
        kit.jump(3f);
        kit.swim(10);


        rex.name = "Santa";
        System.out.println("Новая кличка собачки - " + rex.name);

    }
}
