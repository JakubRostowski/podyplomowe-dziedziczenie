package model.devices;

public class Diesel extends Car {

    public Diesel(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
    }

    @Override
    public void refuel() {
        System.out.println("Diesel car has been refueled.");
    }
}
