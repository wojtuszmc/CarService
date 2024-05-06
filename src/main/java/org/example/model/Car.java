package org.example.model;

public class Car {
    private String model;
    private String licensePlate;
    private String coordinates;
    public Car(String model, String licensePlate, String coordinates) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.coordinates = coordinates;
    }


    public Car() {
    }

    public String toString() {
        return model + ", " + licensePlate + ", " + coordinates;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getCoordinates() {
        return coordinates;
    }
}