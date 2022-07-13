package model.devices;

import model.Human;

import java.net.URL;
import java.util.*;

public class Phone extends Device {

    private static final String serverAddress = "192.168.0.1";
    private static final String protocol = "https";
    private static final Double version = 1.0;

    Set<Application> apps;


    public Phone(String model, String producer, int yearOfProduction, Double value) {
        super(model, producer, yearOfProduction, value);
        apps = new HashSet<>();
    }

    public void installAnApp(Application app, Human buyer) {
        if (buyer.getCash() >= app.getPrice()) {
            this.apps.add(app);
            buyer.setCash(buyer.getCash() - app.getPrice());
            System.out.println(app.getName() + " has been installed.");
        }
    }

    public boolean isAppInstalled(Application app) {
        return this.apps.contains(app);
    }

    public boolean isAppInstalled(String appName) {
        for (Application app : this.apps) {
            if (app.getName().equals(appName)) {
                return true;
            }
        }
        return false;
    }

    public void displayFreeApps() {
        for (Application app : this.apps) {
            if (app.getPrice() == 0) {
                System.out.println(app.getName());
            }
        }
    }

    public Double getValueOfApps() {
        Double value = 0.0;
        for (Application app : this.apps) {
            value += app.getPrice();
        }
        return value;
    }

    public void displayAppsAlphabetically() {
        List<Application> sortedList = new ArrayList<>(this.apps);
        sortedList.sort((o1, o2) -> 0);
        sortedList.sort(Comparator.comparing(Application::getName));

        for (Application app : sortedList) {
            System.out.println(app.getName());
        }
    }

    public void displayAppsOrderedByPrice() {
        List<Application> sortedList = new ArrayList<>(this.apps);
        sortedList.sort((o1, o2) -> 0);
        sortedList.sort(Comparator.comparing(Application::getPrice));

        for (Application app : sortedList) {
            System.out.println(app.getName() + " - " + app.getPrice());
        }
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
