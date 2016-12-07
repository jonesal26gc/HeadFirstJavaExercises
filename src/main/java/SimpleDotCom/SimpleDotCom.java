package SimpleDotCom;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Created by xm39 on 05/12/2016.
 */
public class SimpleDotCom {

    int[] locationCells;
    int numOfHits;
    ArrayList<Integer> newLocationCells = new ArrayList<Integer>();

    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
        this.numOfHits = 0;

        for (int cell : locationCells) {
            newLocationCells.add(cell);
        }

        System.out.println("number of arraylist elements = " + newLocationCells.size());
        for ( int x = 0 ; x < newLocationCells.size() ; x++) {
            System.out.println("Arraylist element " + x + " is " + newLocationCells.get(x));
        }
    }

    @Override
    public String toString() {
        String textReply = "SimpleDotCom{" +
                "locationCells=" + Arrays.toString(locationCells) +
                ", numOfHits=" + numOfHits +
                '}';

        String textArrayList = " ArrayList Contents = ";
        for ( int x = 0 ; x < newLocationCells.size() ; x++) {
            textArrayList = textArrayList.concat(Integer.toString(newLocationCells.get(x))).concat(" ");
        }


        return ( textReply + textArrayList ) ;
    }

    public String checkYourself(String userGuess){

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
            System.out.println(toString());
        }

        System.out.println(result);

        return result;
    }

}
