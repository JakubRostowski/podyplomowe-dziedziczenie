package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Human {
    private String name;

    private Double salary;
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
}
