package com.example;

import java.util.ArrayList;
import java.util.List;

public class PMDTest {

    private List users = new ArrayList(); // PMD: raw use of collection (no generics)

    public void addUser(String username) {
        if (username == null) {
            return; // PMD: return without handling
        }

        if (users.contains(username)) {
            System.out.println("User already exists"); // PMD: System.out.println
        }

        users.add(username); // Logical flaw: adds even if exists
    }

    public void printUsers() {
        for (int i = 0; i <= users.size(); i++) { // PMD: off-by-one (ArrayIndexOutOfBounds)
            System.out.println(users.get(i));     // PMD: System.out.println again
        }
    }

    public void insecureExample() {
        String password = "admin123"; // PMD: hardcoded password
        if ("admin123".equals(password)) {
            System.out.println("Access granted"); // PMD: hardcoded string usage
        }
    }

    public static void main(String[] args) {
        PMDTest test = new PMDTest();
        test.addUser("bob");
        test.addUser("bob");
        test.printUsers();
        test.insecureExample();
    }
}
