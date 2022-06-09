package model.devices;

public class Phone extends Device {

    public Phone(String model, String producer, int yearOfProduction) {
        super(model, producer, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("Phone is turned on.");
    }

    @Override
    public String toString() {
        return "Phone{} " + super.toString();
    }
}
