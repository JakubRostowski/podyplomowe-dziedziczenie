package model;

public interface Sellable {
    void sell(Human seller, Human buyer, Double price, int garageSlot) throws Exception;
}
