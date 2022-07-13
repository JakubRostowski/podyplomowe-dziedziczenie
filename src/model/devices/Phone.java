package model.devices;

import model.Human;

import java.net.URL;

public class Phone extends Device {

    private static final String serverAddress = "192.168.0.1";
    private static final String protocol = "https";
    private static final Double version = 1.0;


    public Phone(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
    }

    public void installAnApp(String appName) {
        System.out.println(appName + " installed.");
    }

    public void installAnApp(String appName, Double version) {
        System.out.println(appName + " " + version + " installed.");
    }

    public void installAnApp(String appName, Double version, String serverAddress) {
        System.out.println(appName + " " + version + " from " + serverAddress + " installed.");
    }

    public void installAnApp(String... appNames) {
        for (String appName : appNames) {
            installAnApp(appName);
        }
    }

    public void installAnApp(URL url) {
        System.out.println("App from " + url + " installed.");
    }

    @Override
    public void turnOn() {
        System.out.println("Phone is turned on.");
    }

    @Override
    public String toString() {
        return "Phone{} " + super.toString();
    }

    @Override
    public void sell(Human seller, Human buyer, Double price, int garageSlot) {
        this.sell(seller, buyer, price);
    }


    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPhone().hashCode() == this.hashCode()) {
            if (buyer.getCash() >= price) {
                buyer.setCash(buyer.getCash() - price);
                seller.setCash(seller.getCash() + price);
                buyer.setPet(seller.getPet());
                seller.setPet(null);
                System.out.println(seller.getName() + " sold " + this.model + " to " + buyer.getName() + " for " + price);
            } else {
                System.out.println("Buyer can't afford it.");
            }
        } else {
            System.out.println("Seller doesn't own it.");
        }
    }
}
