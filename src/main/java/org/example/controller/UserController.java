package org.example.controller;

import org.example.model.User;

import java.util.ArrayList;

public class UserController {
    private ArrayList<User> userDataBase = new ArrayList<>();
    public ArrayList<User> getUserDataBase() {
        return userDataBase;
    }
    public void addUser(String name, String lastName, String email) {
        userDataBase.add(new User(name, lastName, email));
    }
}
