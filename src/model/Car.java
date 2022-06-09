package model;

public class Car {
    private final String model;
    private final String producer;

    private final Double value;

    public Car(String model, String producer, Double value) {
        this.model = model;
        this.producer = producer;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
