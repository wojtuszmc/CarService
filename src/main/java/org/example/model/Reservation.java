package org.example.model;

import org.example.model.Car;
import org.example.model.User;

public class Reservation {
    private User user;
    private int dayOfWeek;
    private Car car;

    public Reservation(User user, int dayOfWeek, Car car) {
        this.user = user;
        this.dayOfWeek = dayOfWeek;
        this.car = car;
    }
    public Reservation() {
    }

    @Override
    public String toString() {
        return "Rezerwacja {" +
                "Imię i nazwisko: " + user +
                ", Dzień tygodnia: " + dayOfWeek +
                ", Samochód: " + car +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
