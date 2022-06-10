package model;

import model.devices.Car;
import model.devices.Phone;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Human {
    private String name;

    private Double salary;
    private Double cash;
    private Animal pet;
    private Car car;
    private Phone phone;

    public Human(String name) {
        this.name = name;
    }
    public Human(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void buyACar(Car car) {
        if (this.salary > car.getValue()) {
            this.car = car;
            System.out.println(this.name + " has got a new car.");
        } else if (this.salary > car.getValue()/12 ) {
            this.car = car;
            System.out.println(this.name + " has got a new car, but he has also credit.");
        } else {
            System.out.println(this.name + " can't afford a new car.");
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

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
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
                ", car=" + car +
                '}';
    }
}
