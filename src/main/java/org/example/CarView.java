package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class CarView {

    private CarController carController = new CarController();
    private UserController userController = new UserController();
    private ReservationController reservationController = new ReservationController();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Dodaj użytkownika.");
        addNewUser();
        System.out.println("Dodaj samochód.");
        addNewCar();
        printPanel();
        String choice = scanner.nextLine();
        while (true) {
            //Zamień na switcha
            if (choice.equals("6")) {
                break;
            } else if (choice.equals("1")) {
                addNewCar();
                printPanel();
                choice = scanner.nextLine();
            } else if (choice.equals("2")) {
                displayAll();
                editCar();
                printPanel();
                choice = scanner.nextLine();
            } else if (choice.equals("3")) {
                addNewReservation();
                displayReservations();
                printPanel();
                choice = scanner.nextLine();
            } else if (choice.equals("4")) {
                addNewUser();
                printPanel();
                choice = scanner.nextLine();
            } else if (choice.equals("5")) {
                displayReservationForUser();
                printPanel();
                choice = scanner.nextLine();
            }
        }
    }

    private void displayAll() {
        for (int i = 0; i < carController.getCarDatabase().size(); i++) {
            System.out.println((i + 1) + ". " + carController.getCarDatabase().get(i).getModel());
        }
    }
    private void displayReservations() {
        for (int i = 0; i < reservationController.getReservationDataBase().size(); i++) {
            System.out.println((i + 1) + ". " + reservationController.getReservationDataBase().get(i));
            System.out.println();
        }
    }
    private void displayUsers() {
        for (int i = 0; i < userController.getUserDataBase().size(); i++) {
            System.out.println((i + 1) + ". " + userController.getUserDataBase().get(i));
        }
    }
    private void displayReservationForUser() {
        System.out.println("Wybierz użytkownika.");
        displayUsers();
        int choiceOfUser = Integer.valueOf(scanner.nextLine()) - 1;
        System.out.println(userController.getUserDataBase().get(choiceOfUser));
        System.out.println(reservationController.getReservationByUser(userController.getUserDataBase().get(choiceOfUser)));
        System.out.println();
    }
    private void addNewUser() {
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String lastName = scanner.nextLine();
        System.out.print("Podaj email: ");
        String email = scanner.nextLine();
        userController.addUser(name, lastName, email);
    }
    private void addNewCar() {
        System.out.print("Podaj nazwę samochodu: ");
        String carName = scanner.nextLine();
        System.out.print("Podaj numer tablicy rej.: ");
        String plate = scanner.nextLine();
        System.out.print("Podaj współrzędne: ");
        String coord = scanner.nextLine();
        carController.addCar(carName, plate, coord);
    }

    private void printPanel() {
        System.out.println("1. Dodaj nowy samochód.");
        System.out.println("2. Edytuj dodane samochody.");
        System.out.println("3. Zarezerwuj.");
        System.out.println("4. Dodaj nowego użytkownika.");
        System.out.println("5. Wyświetl rezerwację danego użytkownika.");
        System.out.println("6. Zakończ");
    }

    private void editCar() {

        System.out.println("Wpisz numer rejestracyjny, żeby znaleźć samochód" +
                " do edycji");
        String findPlate = scanner.nextLine();
        Car findCar = carController.getCarByPlate(findPlate);
        if (findCar == null) {
            System.out.println("NIE MA KURWA: ");
            return;
        }
        System.out.println("Wybierz zmienną, którą chcesz edytować: ");
        System.out.println("1. Model");
        System.out.println("2. Numer tablicy rejetracyjnej");
        System.out.println("3. Współrzędne");
        int variableChoice = Integer.valueOf(scanner.nextLine());
        switch (variableChoice) {
            case 1:
                System.out.print("Nowy model: ");
                String newModel = scanner.nextLine();
                carController.updateModel(findCar.getLicensePlate(), newModel);
                break;
            case 2:
                System.out.print("Nowy numer tablicy: ");
                String newPlate = scanner.nextLine();
                carController.updateRegNumber(findCar.getLicensePlate(), newPlate);
                break;
            case 3:
                System.out.print("Nowe współrzędne: ");
                String newCoords = scanner.nextLine();
                carController.updateCoords(findPlate, newCoords);
                break;
            default:
                System.out.println("Zjebałeś");
                break;
        }
    }
    private void addNewReservation() {
        System.out.println("Wybierz dla którego użytkownika rezerwujesz.");
        displayUsers();
        int choiceOfUser = Integer.valueOf(scanner.nextLine());
        User user = userController.getUserDataBase().get(choiceOfUser - 1);
        System.out.println("Podaj dzień tygodnia jako numer.");
        System.out.println("1. Poniedziałek");
        System.out.println("2. Wtorek");
        System.out.println("3. Środa");
        System.out.println("4. Czwartek");
        System.out.println("5. Piątek");
        System.out.println("6. Sobota");
        System.out.println("7. Niedziela");
        int numberOfWeek = Integer.valueOf(scanner.nextLine());
        System.out.print("Wybierz samochód wpisując jego numer rejestracyjny: ");
        String findPlate = scanner.nextLine();
        Car findCar = carController.getCarByPlate(findPlate);
        if (findCar == null) {
            System.out.println("NIE MA KURWA: ");
            return;
        }
        reservationController.addReservation(user, numberOfWeek, findCar);
    }
}