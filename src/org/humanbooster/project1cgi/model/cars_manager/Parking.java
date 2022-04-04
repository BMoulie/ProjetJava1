package org.humanbooster.project1cgi.model.cars_manager;

import java.util.ArrayList;

public class Parking {

    private String name;
    private String city;
    private String address;
    private ArrayList<Car> cars = new ArrayList<>();

    public Parking(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public long countByBrand(String brand) {
        return cars.stream().filter(v -> v.getCarInfo().getBrand().equals(brand)).count();
    }

    public void add(Car c) {
        cars.add(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", cars=" + cars +
                '}';
    }

}
