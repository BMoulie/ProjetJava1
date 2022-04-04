package org.humanbooster.project1cgi.model.printer_repartition;

import java.util.ArrayList;

public class Repartitor {

    private static Repartitor repartitor;

    private int currentPrinter = 0;
    private ArrayList<Printer> printers = new ArrayList<>();

    private Repartitor() {

    }

    public static Repartitor getInstance() {
        if (repartitor == null) {
            repartitor = new Repartitor();
        }
        return repartitor;
    }

    public void addPrinter(Printer printer) {
        printers.add(printer);
    }

    public void print() {
        printers.get(currentPrinter).print();
        currentPrinter++;
        currentPrinter %= printers.size();
    }

}
