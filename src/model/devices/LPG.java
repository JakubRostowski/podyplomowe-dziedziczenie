package model.devices;

public class LPG extends Car {

    public LPG(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
    }

    @Override
    public void refuel() {
        System.out.println("LPG car has been refueled.");
    }
}
