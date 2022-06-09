import model.Animal;
import model.Car;
import model.Human;

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
        Car toyotka = new Car("Avensis", "Toyota");
        roman.getACar(toyotka);
    }
}