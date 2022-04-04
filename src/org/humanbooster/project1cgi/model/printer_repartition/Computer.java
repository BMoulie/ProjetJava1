package org.humanbooster.project1cgi.model.printer_repartition;

public class Computer {

    private String name;

    public Computer(String name) {
        this.name = name;
    }

    public void print() {
        System.out.print("Le " + name + " a lancé une impression : ");
        Repartitor.getInstance().print();
    }

}
