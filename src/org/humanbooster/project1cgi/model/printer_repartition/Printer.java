package org.humanbooster.project1cgi.model.printer_repartition;

public class Printer {

    private String model;

    public Printer(String model) {
        this.model = model;
    }

    public void print() {
        System.out.println("Impression lancée sur l'imprimante " + model + ".");
    }
}
