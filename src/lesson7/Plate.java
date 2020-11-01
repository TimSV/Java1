package lesson7;

public class Plate {

    private int capacity;
    private int food;

    public Plate(int capacity) {
        this.capacity = capacity;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public int getCapacity() {
        return capacity;
    }


    @Override
    public String toString() {
        return "Plate{" + "capacity=" + capacity + ", food=" + food + '}';
    }


    public void printInfo() {
        System.out.println(this);
    }

    public void decreaseFood(int appetite) {
        this.food -= appetite;
    }
}
