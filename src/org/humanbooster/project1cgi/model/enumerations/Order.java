package org.humanbooster.project1cgi.model.enumerations;

public class Order {

    private String ref;
    private Drink drink;
    private MainCourse mainCourse;
    private Dessert dessert;

    public Order(String ref, Drink drink, MainCourse mainCourse, Dessert dessert) {
        this.ref = ref;
        this.drink = drink;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
    }

    public float totalPrice() {
        return drink.getPrice() + mainCourse.getPrice() + dessert.getPrice();
    }

    @Override
    public String toString() {
        return "Commande n°" + ref + " : boisson : " + drink + " ; plat : " + mainCourse + " ; dessert : " + dessert + ".";
    }
}
