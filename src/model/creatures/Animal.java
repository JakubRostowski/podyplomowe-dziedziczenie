package model.creatures;

import model.Human;
import model.Sellable;

import java.util.Objects;

public abstract class Animal implements Sellable, Feedable {
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

    @Override
    public void feed(Double foodWeight) {
        if (!isDead()) {
            this.weight = this.weight + foodWeight;
            System.out.println("Animal has been feed with " + foodWeight + "kg of food.");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(species, animal.species) && Objects.equals(weight, animal.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, species, weight);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void sell(Human seller, Human buyer, Double price, int i) {
        if (seller.getPet().hashCode() == this.hashCode()) {
            if (buyer.getCash() >= price) {
                buyer.setCash(buyer.getCash() - price);
                seller.setCash(seller.getCash() + price);
                buyer.setPet(seller.getPet());
                seller.setPet(null);
                System.out.println(seller.getName() + " sold " + this.name + " to " + buyer.getName() + " for " + price);
            } else {
                System.out.println("Buyer can't afford it.");
            }
        } else {
            System.out.println("Seller doesn't own it.");
        }
    }

}
