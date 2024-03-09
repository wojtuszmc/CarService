package org.example.model;

public abstract class Vehicle {
    private String model;
    private String licensePlate;
    private String coordinates;

    public Vehicle(String model, String licensePlate, String coordinates) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.coordinates = coordinates;
    }

    public Vehicle() {
    }
}
