package com.kevinestrada.examples;

import java.util.ArrayList;

public class Ship {
    private ArrayList<String> locationCells;
    private String name;
    private ShipNameInput helpName = new ShipNameInput();

    public void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    public void setName() {
        name = helpName.getUserInputForNames();
    }

    public String getName() {
        return name;
    }

    public String checkIfHit(String userInput) {
        String result = "MISS";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "KILL";
                System.out.println("You sunk " + name + " : ( ");
            } else {
                result = "HIT";
            }
        }
        return result;
    }

}
