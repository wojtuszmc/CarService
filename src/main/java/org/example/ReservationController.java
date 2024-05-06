package org.example;

import java.util.ArrayList;

public class ReservationController {
    private CarController carController;
    private UserController userController;
    private ArrayList<Reservation> reservationDataBase = new ArrayList<>();

    public ReservationController(CarController carController, UserController userController) {
        this.carController = carController;
        this.userController = userController;
    }

    public ArrayList<Reservation> getReservationDataBase() {
        return reservationDataBase;
    }
    public void addReservation(User user, int dayOfWeek, Car car) {
        reservationDataBase.add(new Reservation(user, dayOfWeek, car));
    }
    public ArrayList<Reservation> getReservationByUser(int choiceOfUser) {
        User user = userController.getUserDataBase().get(choiceOfUser);
        ArrayList<Reservation> result = new ArrayList<>();
        for (Reservation reservation: reservationDataBase) {
            if (user.getEmail().equals(reservation.getUser().getEmail())) {
                result.add(reservation);
            }
        }
        return result;
    }

    public void removeReservationByUser(int choiceOfUser, int choiceToRemove) {
        ArrayList<Reservation> reservationByUser = getReservationByUser(choiceOfUser);
        System.out.println(reservationByUser.size());
        int indexToRemove = getReservationDataBase().indexOf(reservationByUser.get(choiceToRemove));
        getReservationDataBase().remove(indexToRemove);
    }
}
