package model.devices;

public class Electric extends Car {

    public Electric(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
    }

    @Override
    public void refuel() {
        System.out.println("Electric car has been refueled.");
    }
}
