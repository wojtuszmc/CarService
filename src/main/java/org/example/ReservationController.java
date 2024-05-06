package org.example;

import java.util.ArrayList;

public class ReservationController {
    private CarController carController = new CarController();
    private UserController userController = new UserController();
    private ArrayList<Reservation> reservationDataBase = new ArrayList<>();
    public ArrayList<Reservation> getReservationDataBase() {
        return reservationDataBase;
    }
    public void addReservation(User user, int dayOfWeek, Car car) {
        reservationDataBase.add(new Reservation(user, dayOfWeek, car));
    }
    public ArrayList<Reservation> getReservationByUser(User user) {
        ArrayList<Reservation> result = new ArrayList<>();
        for (Reservation reservation: reservationDataBase) {
            if (user.getEmail().equals(reservation.getUser().getEmail())) {
                result.add(reservation);
            }
        }
        return result;
    }
    public void removeReservationByUser(int choiceOfUser, int choiceToRemove, UserController userCon) {
        ArrayList<Reservation> reservationByUser = getReservationByUser(userCon.getUserDataBase().get(choiceOfUser));
        System.out.println(reservationByUser.size());
        int indexToRemove = getReservationDataBase().indexOf(reservationByUser.get(choiceToRemove));
        getReservationDataBase().remove(indexToRemove);
    }
}
