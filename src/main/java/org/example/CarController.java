package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarController {

    private List<Car> carDatabase = new ArrayList<>();

    public List<Car> getCarDatabase() {
        return carDatabase;
    }



    public void addCar(String carName, String plate, String coord) {
        carDatabase.add(new Car(carName, plate, coord));
    }

    public Car getCarByPlate(String findPlate){
        for (Car car: carDatabase) {
            if (findPlate.equals(car.getLicensePlate())) {
                return car;
            }
        }
        return null;
    }

    public void updateModel(String findPlate, String newModel){
        int index = -1;
        for (Car car: carDatabase) {
            if (findPlate.equals(car.getLicensePlate())) {
                index = carDatabase.indexOf(car);
                System.out.println(carDatabase.get(index));
                break;
            }
        }
        carDatabase.get(index).setModel(newModel);
    }


    public void updateRegNumber(String findPlate, String newPlate){
        int index = -1;
        for (Car car: carDatabase) {
            if (findPlate.equals(car.getLicensePlate())) {
                index = carDatabase.indexOf(car);
                System.out.println(carDatabase.get(index));
                break;
            }
        }
        carDatabase.get(index).setLicensePlate(newPlate);
    }


    public void updateCoords(String findPlate, String newCoords){
        int index = -1;
        for (Car car: carDatabase) {
            if (findPlate.equals(car.getLicensePlate())) {
                index = carDatabase.indexOf(car);
                System.out.println(carDatabase.get(index));
                break;
            }
        }
        carDatabase.get(index).setCoordinates(newCoords);
    }


}