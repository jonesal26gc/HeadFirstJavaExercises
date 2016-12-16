package SimpleDotCom;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by xm39 on 05/12/2016.
 */
public class SimpleDotCom {

    private int[] locationCells;
    private int numOfHits;
    private ArrayList<Integer> newLocationCells = new ArrayList<Integer>();

    public void setLocationCells(int[] locationCells) {
    /**************************************************************
    Set the provided locations in the ArrayList.
    **************************************************************/

        // Set the instance variables.
        this.locationCells = locationCells;
        this.numOfHits = 0;

        // for each integer in the array, add to the ArrayList.
        for (int cell : locationCells) {
            newLocationCells.add(cell);
        }

    }

    @Override
    public String toString() {
    /**************************************************************
    Display the contents of the instance variables.
    **************************************************************/
        String textReply = "SimpleDotCom{" +
                "locationCells=" + Arrays.toString(locationCells) +
                ", numOfHits=" + numOfHits +
                '}';

        String textArrayList = " ArrayList Contents=";
        for ( int x = 0 ; x < newLocationCells.size() ; x++) {
            textArrayList = textArrayList.concat(Integer.toString(newLocationCells.get(x))).concat(" ");
        }

        return ( textReply + textArrayList ) ;
    }

    public String checkYourself(String userGuess){
    /**************************************************************
    Check for a hit amongst the ArrayList contents.
    **************************************************************/

        // convert the string into an integer for checking.
        int guess = parseInt(userGuess);
        String result = "Failed";

        // Check fot a hit and kill.
        if (newLocationCells.contains(guess)) {
            numOfHits++;
            newLocationCells.remove(newLocationCells.indexOf(guess));
            if (newLocationCells.isEmpty()) {
                result = "Kill";
            } else {
                result = "Hit";
            }
        }

        // display the results and return the same to the caller.
        System.out.println(result);
        return result;
    }

}
