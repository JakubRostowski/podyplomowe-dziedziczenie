package model.devices;

import model.Human;

import java.util.Objects;

public abstract class Car extends Device{
    private final Double value;

    public Car(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction);
        this.value = value;
    }

    public void refuel() {
        System.out.println("Car has been refueled.");
    }

    @Override
    public void turnOn() {
        System.out.println("Car is turned on.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getCar().hashCode() == this.hashCode()) {
            if (buyer.getCash() >= price) {
                buyer.setCash(buyer.getCash() - price);
                seller.setCash(seller.getCash() + price);
                buyer.setCar(seller.getCar());
                seller.setCar(null);
                System.out.println(seller.getName() + " sold " + this.model + " to " + buyer.getName() + " for " + price);
            }
        }
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
