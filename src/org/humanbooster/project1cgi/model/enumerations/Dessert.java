package org.humanbooster.project1cgi.model.enumerations;

public enum Dessert {

    ICECREAM(5), CHOCOSNACK(3.5f);

    private float price;

    private Dessert(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

}
