package model.devices;

import model.Human;
import model.Sellable;

import java.util.Objects;

public abstract class Device implements Sellable {

    final String model;
    final String producer;
    final int yearOfProduction;

    public Device(String model, String producer, int yearOfProduction) {
        this.model = model;
        this.producer = producer;
        this.yearOfProduction = yearOfProduction;
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
}
