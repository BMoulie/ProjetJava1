package org.humanbooster.project1cgi.model.enumerations;

public enum Drink {
    BEER(4.5f), WATER(0.5f), COKE(2);

    private float price;

    private Drink(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }
}
