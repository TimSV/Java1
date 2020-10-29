package lesson6;

public class Cat extends Animal {
    public Cat(String name) {
        this.name = name;
        limitRun = 180 + (int) (Math.random() * 40);
        limitJump = 2f;

        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Котик " + name + " может пробежать "
                + limitRun + " м., перепрыгнуть " + limitJump + " м. и котик" +
                " не умеет плавать";
    }

    @Override
    public void run(int length) {
        if (length <= limitRun) {
            System.out.println("Котик пробежал " + length + " метров");
        } else {
            System.out.println("Котик не сможет пробежать " + length + " метров");
        }
    }

    @Override
    public void jump(float length) {
        if (length < limitRun) {
            System.out.println("Котик перепрыгнул " + length + " метров!");
        } else {
            System.out.println("Котик не сможет перепрыгнуть " + length + " метров");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Котик боится воды и поэтому никуда не поплывет!");
    }

}
