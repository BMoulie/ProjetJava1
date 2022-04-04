package org.humanbooster.project1cgi.model.enumerations;

public enum MainCourse {

    CHICKEN(12.5f), BEEF(18), SALAD(14.5f);

    private float price;

    private MainCourse(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

}
