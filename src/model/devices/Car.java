package model.devices;

import java.util.Objects;

public class Car extends Device{
    private final Double value;

    public Car(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction);
        this.value = value;
    }

    @Override
    public void turnOn() {
        System.out.println("Car is turned on.");
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", value=" + value +
                '}';
    }
}
