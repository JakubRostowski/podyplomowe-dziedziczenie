package model.creatures;

public class FarmAnimal extends Animal implements Edible{

    public FarmAnimal(String name, String species) {
        super(name, species);
    }

    @Override
    public void beEaten() {
        System.out.println("This animal has been eaten.");
    }


}
