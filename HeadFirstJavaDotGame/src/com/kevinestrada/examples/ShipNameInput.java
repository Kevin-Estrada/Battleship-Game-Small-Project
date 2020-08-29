package com.kevinestrada.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShipNameInput {

    public String getUserInputForNames() {
        String nameEntered = "null";
        System.out.println("Enter a name for the ship: ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            nameEntered = is.readLine();
            if (nameEntered.length() == 0) {
                return "null";
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return nameEntered;
    }
}
