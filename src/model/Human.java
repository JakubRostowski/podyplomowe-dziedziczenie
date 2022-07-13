package model;

import model.creatures.Animal;
import model.devices.Car;
import model.devices.Device;
import model.devices.Phone;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

public class Human {
    private String name;

    private Double salary;
    private Double cash;
    private Animal pet;
    private Car[] garage;
    private Phone phone;

    public Human(String name) {
        this.name = name;
        this.garage = new Car[3];
    }
    public Human(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
        this.garage = new Car[3];
    }

    public void buyACar(Car car, int garageSlot) {
        if (this.garage[garageSlot] == null) {
            if (this.salary > car.getValue()) {
                this.garage[garageSlot] = car;
                System.out.println(this.name + " has got a new car.");
                car.getOwners().add(this);
            } else if (this.salary > car.getValue()/12 ) {
                this.garage[garageSlot] = car;
                System.out.println(this.name + " has got a new car, but he has also credit.");
                car.getOwners().add(this);
            } else {
                System.out.println(this.name + " can't afford a new car.");
            }
        } else {
            System.out.println(this.name + " has a full garage already.");
        }

    }

    public Double getSalary() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar. getInstance());
        System.out.println(timeStamp + " - " + this.salary);
        return this.salary;
    }

    public void setSalary(Double salary) {
        if (salary >= 0) {
            this.salary = salary;
            System.out.println("Data has been sent to accounting system.");
            System.out.println("Remember to get annex to the contract from Mrs. Hania from HR.");
            System.out.println("ZUS and US already know about your income.");
        } else {
            System.out.println("Salary can't be negative!");
        }
    }

    public String getName() {
        return name;
    }

    public Car[] getGarage() {
        return garage;
    }

    public void setGarage(Car[] garage) {
        this.garage = garage;
    }

    public void displayGarageContent() {
        int slot = 0;
        for (Car car : this.garage) {
            System.out.println(slot++ + ". " + car);
        }
    }

    public Double getGarageValue() {
        Double value = 0.0;
        for (Car car : this.garage) {
            if (car != null) {
                value += car.getValue();
            }
        }
        return value;
    }

    public void sortGarage() {
        Arrays.sort(this.garage, Comparator.comparing(Device::getYearOfProduction));
    }

    public boolean hasFreeGarageSlot() {
        for (Car car : this.garage) {
            if (car == null) {
                return true;
            }
        }
        return false;
    }

    public int getFirstFreeGarageSlot() {
        for (int i = 0; i < this.garage.length-1; i++) {
            if (this.garage[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public Car getCar(int slot) {
        return this.garage[slot];
    }

    public void setCar(Car car, int slot) {
        this.garage[slot] = car;
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", pet=" + pet +
                ", garage=" + garage +
                '}';
    }
}
