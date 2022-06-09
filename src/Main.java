import model.Animal;
import model.devices.Car;
import model.Human;
import model.devices.Phone;

public class Main {

    public static void main(String[] args) {

        Animal kicia = new Animal("Kicia", "cat");
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
        Car toyotka = new Car("Avensis", "Toyota", 10000.00);

        roman.setSalary(3000.00);
        roman.buyACar(toyotka);

        Car drugaToyotka = new Car("Avensis", "Toyota", 10000.00);
        System.out.println(toyotka.equals(drugaToyotka));

        Phone s20 = new Phone("Samsung Galaxy S20");

        System.out.println(toyotka);
        System.out.println(roman);
        System.out.println(kicia);
        System.out.println(s20);
    }
}