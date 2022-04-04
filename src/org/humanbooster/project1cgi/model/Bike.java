package org.humanbooster.project1cgi.model;

public class Bike {

    public String model;
    public String color = "red";
    public int size = 26;
    public int price;

    public Bike(String model, int size) {
        this.model = model;
        this.size = size;
    }

    public Bike(String model, String color, int size) {
        this(model, size);
        this.color = color;
    }

    public void affiche() {
        System.out.println("Vélo : " + this.model  + " ; " + this.color + " ; " + this.size + " pouces.");
    }

    public void comparePrice(Bike bike) {
        if (this.price > bike.price) {
            System.out.println("Le vélo " + this.model + " est plus cher que le vélo " + bike.model + ".");
        } else if (this.price == bike.price) {
            System.out.println("Les deux vélos ont le même prix.");
        } else {
            System.out.println("Le vélo " + this.model + " est moins cher que le vélo " + bike.model + ".");
        }
    }

}
