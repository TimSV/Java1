package lesson7;

public class PlateEx extends Plate {

    public PlateEx(int capacity) {
        super(capacity);
    }

    @Override
    public void addFood(int food) {
        if (super.getCapacity() - getFood() < food) {
            super.setFood(super.getCapacity());
        } else {
            super.addFood(food);
        }
    }

    @Override
    public void decreaseFood(int appetite) {
        super.setFood(super.getFood() - appetite);
    }
}
