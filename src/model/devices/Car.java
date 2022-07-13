package model.devices;

import model.Human;

import java.util.ArrayList;

public abstract class Car extends Device{

    ArrayList<Human> owners;

    public Car(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
        owners = new ArrayList<>();
    }

    public void refuel() {
        System.out.println("Car has been refueled.");
    }

    @Override
    public void turnOn() {
        System.out.println("Car is turned on.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price, int garageSlot) throws Exception {
        if (this.owners.get(this.owners.size()-1).equals(seller)) {
            super.sell(seller, buyer, price, garageSlot);
            this.owners.add(buyer);
        } else {
            throw new Exception("Seller is not a last owner of the car.");
        }
    }

    public boolean wasOwner(Human human) {
        return this.owners.contains(human);
    }

    public boolean didTransactionHadPlace (Human seller, Human buyer) {
        if (this.owners.size() < 2) {
            return false;
        }
        for (Human human : this.owners) {
            if (human.equals(buyer)) {
                if (this.owners.get(this.owners.indexOf(human)-1).equals(seller)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getTransactionsCount() {
        return this.owners.size()-1;
    }

    public ArrayList<Human> getOwners() {
        return owners;
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
