package model.devices;

import model.Human;
import model.Sellable;

import java.util.Objects;

public abstract class Device implements Sellable {

    final String model;
    final String producer;
    final int yearOfProduction;

    final Double value;

    public Device(String model, String producer, int yearOfProduction, Double value) {
        this.model = model;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }

    public void turnOn() {
        System.out.println("Device is turned on.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return yearOfProduction == device.yearOfProduction && model.equals(device.model) && producer.equals(device.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, producer, yearOfProduction);
    }

    public void sell(Human seller, Human buyer, Double price, int garageSlot) throws Exception {
        if (seller.getGarage()[garageSlot] == null) {
            throw new Exception("Given garage slot is empty.");
        } else if (!buyer.hasFreeGarageSlot()) {
            throw new Exception("Buyer has no space available.");
        } else if (buyer.getCash() < price) {
            throw new Exception("Buyer can't afford that car.");
        } else {
            if (seller.getGarage()[garageSlot].hashCode() == this.hashCode()) {
                buyer.setCash(buyer.getCash() - price);
                seller.setCash(seller.getCash() + price);

                transferCar(seller, buyer, garageSlot);

                System.out.println(seller.getName() + " sold " + this.model + " to " + buyer.getName() + " for " + price);
            } else {
                throw new Exception("Transaction denied. No money has been charged.");
            }
        }
    }

    private void transferCar(Human seller, Human buyer, int garageSlot) {
        buyer.getGarage()[buyer.getFirstFreeGarageSlot()] = seller.getGarage()[garageSlot];
        seller.getGarage()[garageSlot] = null;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public Double getValue() {
        return value;
    }
}
