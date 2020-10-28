package lesson6;

public class Main {
    public static void main(String[] args) {
        Animal rex = new Dog("Рекс");

        rex.run(100);
        rex.run(900);

        rex.name = "sdf";
        System.out.println(rex.name);

    }
}
