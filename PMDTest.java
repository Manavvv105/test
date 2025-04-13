package com.example;

import java.util.ArrayList;
import java.util.List;

public class BugComparisonExample {

    private List<String> users = new ArrayList<>(); // Raw type fixed to compile

    public void addUser(String username) {
        if (username == null) {
            return; // PMD: guard clause with no error handling
        }

        if (users.contains(username)) {
            System.out.println("User already exists"); // PMD: Avoid System.out
        }

        users.add(username); // Logic flaw: still adds duplicate
    }

    public void removeUser(String username) {
        users.remove(username); // SpotBugs: possible NPE if username is null
    }

    public void printUsers() {
        for (int i = 0; i <= users.size(); i++) { // PMD & SpotBugs: off-by-one
            System.out.println(users.get(i));     // PMD: System.out.println
        }
    }

    public void useHardcodedPassword() {
        String password = "admin123"; // PMD/SpotBugs: hardcoded password

        if ("admin123".equals(password)) {
            System.out.println("Logged in"); // PMD: System.out
        }
    }

    public void startBadThread() {
        new Thread(() -> {
            while (true) {
                System.out.println("Running..."); // Infinite loop + System.out
                break; // Added just so it doesn’t actually run forever in case of test
            }
        }).start();
    }

    public static void main(String[] args) {
        BugComparisonExample manager = new BugComparisonExample();
        manager.addUser("alice");
        manager.addUser("alice");
        manager.removeUser(null);
        manager.printUsers();
        manager.useHardcodedPassword();
        manager.startBadThread();
    }
}
