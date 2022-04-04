package org.humanbooster.project1cgi.model.cars_manager;

public class Car {

    private static int count = 0;

    private int id;
    private int speed;
    private int maxSpeed = 220;
    private CarInfo carInfo;
    private OwnerInfo ownerInfo;

    public Car(CarInfo carInfo) {
        this.id = ++count;
        this.carInfo = carInfo;
    }

    public Car(int speed, CarInfo carInfo) {
        this(carInfo);
        this.setSpeed(speed);
    }

    public Car(String serialNumber, String brand, int speed) {
        this(speed, new CarInfo(serialNumber, brand));
    }

    public String compare(Car v) {
        int speedDiff = this.speed - v.speed;
        if (speedDiff > 0) {
            return "The car " + this.carInfo + " is going " + Math.abs(speedDiff) + " km/h more than the car " + v.carInfo + ".";
        } else if (speedDiff < 0) {
            return "The car " + this.carInfo + " is going " + Math.abs(speedDiff) + " km/h less than the car " + v.carInfo + ".";
        } else {
            return "Both cars " + this.carInfo + " and " + v.carInfo + " are going at the same speed.";
        }
    }

    public static String compare(Car v1, Car v2) {
        return v1.compare(v2);
    }

    public void accelerate(int speed) {
        setSpeed(this.speed + speed);
    }

    public void decelerate(int speed) {
        setSpeed(Math.max(0, this.speed - speed));
    }

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = Math.min(speed, maxSpeed);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public OwnerInfo getOwnerInfo() {
        return ownerInfo;
    }

    public void setOwnerInfo(OwnerInfo ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", speed=" + speed +
                ", maxSpeed=" + maxSpeed +
                ", carInfo=" + carInfo +
                ", ownerInfo=" + ownerInfo +
                '}';
    }
}
