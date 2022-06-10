import model.creatures.Animal;
import model.Human;
import model.creatures.Pet;
import model.devices.Car;
import model.devices.Phone;

public class Main {

    public static void main(String[] args) {

        Animal kicia = new Pet("Kicia", "cat");
        kicia.feed();
        kicia.takeForAWalk();
        kicia.takeForAWalk();
        kicia.takeForAWalk();
        kicia.takeForAWalk();
        kicia.takeForAWalk();
        kicia.takeForAWalk();
        kicia.feed();
        kicia.takeForAWalk();

        Human roman = new Human("Roman");
        Car toyotka = new Car("Avensis", "Toyota", 2001, 10000.00);

        roman.setSalary(3000.00);
        roman.buyACar(toyotka);

        Car drugaToyotka = new Car("Avensis", "Toyota", 2001, 10000.00);
        System.out.println(toyotka.equals(drugaToyotka));

        Phone s20 = new Phone("Galaxy S20", "Samsung", 2020);

        System.out.println(toyotka);
        System.out.println(roman);
        System.out.println(kicia);
        System.out.println(s20);

        toyotka.turnOn();
        s20.turnOn();

        Human zbyszek = new Human("Zbyszek");

        zbyszek.setCash(2000.00);
        roman.setCash(0.00);

        toyotka.sell(roman, zbyszek, 1000.00);
        toyotka.sell(zbyszek, roman, 3000.00);

        Animal azor = new Pet("Azor", "dog");

        azor.feed();
        azor.feed(0.5);
    }
}