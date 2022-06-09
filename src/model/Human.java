package model;

public class Human {
    private String name;
    private Animal pet;

    private Car car;

    public Human(String name) {
        this.name = name;
    }
    public Human(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void getACar(Car car) {
        this.car = car;
    }
}
