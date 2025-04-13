package com.example;

import java.util.ArrayList;
import java.util.List;

public class PMDTest {

    private List users = new ArrayList(); // SpotBugs: unchecked generic use

    public void addUser(String username) {
        if (username == null) {
            return; // PMD: guard clause without handling
        }

        if (users.contains(username)) {
            System.out.println("User already exists"); // PMD: System.out.println
        }

        users.add(username); // PMD: logical error (duplicate allowed)
    }

    public void removeUser(String username) {
        users.remove(username); // SpotBugs: possible NPE if username is null
    }

    public void printUsers() {
        for (int i = 0; i <= users.size(); i++) { // PMD & SpotBugs: off-by-one (ArrayIndexOutOfBounds)
            System.out.println(users.get(i));     // PMD: System.out.println
        }
    }

    public void useHardcodedPassword() {
        String password = "admin123"; // PMD & SpotBugs: hardcoded credential

        if (password.equals("admin123")) {
            System.out.println("Logged in"); // PMD: System.out
        }
    }

    public void startBadThread() {
        new Thread(() -> {
            while (true) { // PMD: infinite loop
                System.out.println("Running..."); // PMD: inside thread
            }
        }).start(); // SpotBugs: Thread started but never managed
    }

    public static void main(String[] args) {
        PMDTest manager = new PMDTest();
        manager.addUser("alice");
        manager.addUser("alice");
        manager.removeUser(null);
        manager.printUsers();
        manager.useHardcodedPassword();
        manager.startBadThread();
    }
}
