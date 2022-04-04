package org.humanbooster.project1cgi.model.cars_manager;

public class CarInfo {

    private String serialNumber;
    private String brand;

    public CarInfo(String serialNumber, String brand) {
        this.serialNumber = serialNumber;
        this.brand = brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "serialNumber='" + serialNumber + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
