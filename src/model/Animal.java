package model;

public class Animal {
    private String name;
    private final String species;
    private Double weight;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
        switch (species) {
            case "dog" -> this.weight = 10.00;
            case "cat" -> this.weight = 5.00;
            default -> this.weight = 8.00;
        }
    }

    public void feed() {
        if (!isDead()) {
            this.weight++;
            System.out.println("Animal feeded.");
        }
    }

    public void takeForAWalk() {
        if (!isDead()) {
            this.weight--;
            System.out.println("Animal took for a walk.");
            if (this.weight <= 0) {
                System.out.println("Ooops! " + this.name + " just died!");
            }
        }

    }

    private boolean isDead() {
        if (this.weight <= 0) {
            System.out.println(this.name + " doesn't move :(");
            return true;
        }
        return false;
    }
}
