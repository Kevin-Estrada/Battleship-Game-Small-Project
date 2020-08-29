package com.kevinestrada.examples;

import java.util.*;

public class ShipMapCreation {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> ShipsList = new ArrayList<Ship>();
    private int numOfGuesses = 0;

    public void setUpGame() {
        Ship one = new Ship();
        one.setName();
        Ship two = new Ship();
        two.setName();
        Ship three = new Ship();
        three.setName();
        ShipsList.add(one);
        ShipsList.add(two);
        ShipsList.add(three);

        System.out.println("The goal of this program is to sink 3 named ships.");
        System.out.println(one.getName() + ", " + two.getName() + ", " + three.getName());
        System.out.println("Try to sink them all in fewest amount of guesses!");
        System.out.println("Make sure to enter guess in letter number format such as A3");
        System.out.println("Range for letters is A-G and range for numbers is 0-6");

        for (Ship ShipToSet : ShipsList) {
            ArrayList<String> newLocation = helper.placeShip(3);
            ShipToSet.setLocationCells(newLocation);
        }
    }

    public void startPlaying() {
        while (!ShipsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess:");
            checkUserGuess(userGuess);
        }

        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;

        String result = "MISS";

        for (int x = 0; x < ShipsList.size(); x++) {
            result = ShipsList.get(x).checkIfHit(userGuess);
            if (result.equals("HIT")) {
                break;
            }
            if (result.equals("KILL")) {
                ShipsList.remove(x);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All ships are dead!");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("Great job!");
        } else {
            System.out.println("You took long with " + numOfGuesses + " guesses.");
            System.out.println("Try better next time!");
        }
    }
}
