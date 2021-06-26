package SOLID.OpenClose;

public abstract class Vehicle {
    abstract public double calculateValue();
}
 class Car extends Vehicle {
    private final int value = 1;
    public int getValue() {
        return value;
    }

    @Override
    public double calculateValue() {
        return this.getValue() * 0.8;
    }
}

 class Truck extends Vehicle {
    private int value = 2;
    public int getValue() {
        return value;
    }

        public double calculateValue() {
            return this.getValue() * 0.9;
        }
}