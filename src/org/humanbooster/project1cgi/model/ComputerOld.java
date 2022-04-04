package org.humanbooster.project1cgi.model;

public class ComputerOld {

    private int frequency;
    private String model;

    public ComputerOld(int frequency, String model) {
        this.frequency = frequency;
        this.model = model;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "frequency=" + frequency +
                ", model='" + model + '\'' +
                '}';
    }

}
