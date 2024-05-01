package org.example;

import java.util.ArrayList;

public class UserController {
    private User user = new User();
    private ArrayList<User> userDataBase = new ArrayList<>();
    public ArrayList<User> getUserDataBase() {
        return userDataBase;
    }
    public void addUser(String name, String lastName, String email) {
        userDataBase.add(new User(name, lastName, email));
    }
}
