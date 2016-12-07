package SimpleDotCom;

import SimpleDotCom.SimpleDotCom;
import Utilities.UserInput;

/**
 * Created by xm39 on 05/12/2016.
 */
public class SimpleDotComGame {

    public static void main(String[] args) {

        SimpleDotCom dot = new SimpleDotCom();

        int locationSeed = (int) (Math.random() * 5);
        System.out.println(locationSeed);

        int [] locations = {locationSeed,locationSeed+1,locationSeed+2};
        dot.setLocationCells(locations);
        System.out.println(dot.toString());

        boolean isAlive = true;
        int numberOfGuesses = 0;

        while ( isAlive ) {
            numberOfGuesses++;
            String result = dot.checkYourself(new UserInput().getUserInputString("Give me a number"));
            if (result.equals("Kill")) {
                isAlive = false;
                System.out.println("You had " + numberOfGuesses + " guesses to achieve a kill." );
            }
        }




    }
}
