package model.devices;

import model.Human;

public abstract class Car extends Device{

    public Car(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
    }

    public void refuel() {
        System.out.println("Car has been refueled.");
    }

    @Override
    public void turnOn() {
        System.out.println("Car is turned on.");
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
