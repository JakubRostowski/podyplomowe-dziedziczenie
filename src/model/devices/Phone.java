package model.devices;

import model.Human;

public class Phone extends Device {

    public Phone(String model, String producer, int yearOfProduction) {
        super(model, producer, yearOfProduction);
    }

    @Override
    public void turnOn() {
        System.out.println("Phone is turned on.");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPhone().hashCode() == this.hashCode()) {
            if (buyer.getCash() >= price) {
                buyer.setCash(buyer.getCash() - price);
                seller.setCash(seller.getCash() + price);
                buyer.setPhone(seller.getPhone());
                seller.setPhone(null);
                System.out.println(seller.getName() + " sold " + this.model + " to " + buyer.getName() + " for " + price);
            }
        }
    }

    @Override
    public String toString() {
        return "Phone{} " + super.toString();
    }
}
