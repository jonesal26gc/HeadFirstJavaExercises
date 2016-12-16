package SimpleDotCom;

import SimpleDotCom.SimpleDotCom;
import Utilities.UserInput;

/**
 * Created by xm39 on 05/12/2016.
 */
public class SimpleDotComGame {

    public static void main(String[] args) {

        // instantiate the primary class.
        SimpleDotCom dot = new SimpleDotCom();

        // get a value for the first cell of the array.
        int locationSeed = (int) (Math.random() * 5);

        // identify the locations as the first cell, plus offsets.
        // Set the locations in the primary class.
        int [] locations = {locationSeed,locationSeed+1,locationSeed+2};
        dot.setLocationCells(locations);

        // Mark the game active, and reset the guess counter.
        boolean isAlive = true;
        int numberOfGuesses = 0;

        // While the game is alive, permit guesses until a "kill" occurs.
        while ( isAlive ) {

            // display the instance variables.
            System.out.println(dot.toString());

            // increment guesses.
            numberOfGuesses++;

            // Grab a guess from the console, and use this against the checker.
            String result = dot.checkYourself(new UserInput().getUserInputString("Give me a number"));

            // Finally, when we have a "kill"m we can end the game.
            // Display the number of guesses.
            if (result.equals("Kill")) {
                isAlive = false;
                System.out.println("You had " + numberOfGuesses + " guesses to achieve a kill." );
            }
        }
    }
}
