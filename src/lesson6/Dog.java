package lesson6;

public class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
        limitRun = 450 + (int) (Math.random() * 100);
        limitJump = 0.5f;
        limitSwim = 8 + (int) (Math.random() * 5);
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Собкачка " + name + " может пробежать "
                + limitRun + " м., проплыть " + limitSwim
                + " м. и перепрыгнуть " + limitJump + " м.";
    }

    @Override
    public void run(int length) {
        if (length <= limitRun) {
            System.out.println("Собачка пробежала " + length + " метров");
        } else {
            System.out.println("Собачка не сможет пробежать " + length + " метров");
        }
    }

    @Override
    public void jump(float length) {
        if (length <= limitJump) {
            System.out.println("Собачка перепрыгнула " + length + " метров");
        } else {
            System.out.println("Собачка не сможет перепрыгнуть " + length + " метров");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= limitSwim) {
            System.out.println("Собачка проплыла " + length + " метров");
        } else {
            System.out.println("Собачка не сможет проплыть " + length + " метров");
        }
    }
}
