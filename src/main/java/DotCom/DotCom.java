package DotCom;

import java.util.ArrayList;

public class DotCom {
    /******************************************************************************
    A DotCom is a target of three consecutive cells, either vertical or horizontal.
    It lives on an 8*8 cell matrix, reference by "A1", etc. annotation.
    ******************************************************************************/

    // Variables.
    private static final char [] xAxisLetter = {'A','B','C','D','E','F','G','H'};
    private boolean isHorizontal;
    private ArrayList<String> locationCells = new ArrayList<String>();
    private String allLocationCells;
    private int numOfHits = 0;

    public DotCom() {}

    // Getters.
    public ArrayList<String> getLocationCells() {
        return locationCells;
    }
    public String getAllLocationCells() {
        return allLocationCells;
    }
    public int getNumOfHits() { return numOfHits; }
    public String getLocationCell(int cell) { return locationCells.get(cell); }

    // Setters.
    public void setLocationCells() {
    /**************************************************************
    Set the provided locations in the ArrayList.
    **************************************************************/

        // Decide whether it's vertical or horizontal.
        isHorizontal = ( (int) Math.round(Math.random()) > 0);

        // Create the primary horizontal cell.
        if (isHorizontal) {
            int xAxisStartCell = (int) Math.round((Math.random() * 5));
            int yAxisStartCell = (int) Math.round((Math.random() * 7));
            for ( int i=0 ; i<3 ; i++ ) {
                locationCells.add( xAxisLetter[(xAxisStartCell + i)] + Integer.toString(yAxisStartCell) );
            }
        } else {
            int xAxisStartCell = (int) Math.round((Math.random() * 7));
            int yAxisStartCell = (int) Math.round((Math.random() * 5));
            for ( int i=0 ; i<3 ; i++ ) {
                locationCells.add( xAxisLetter[xAxisStartCell] + Integer.toString(yAxisStartCell + i));
            }
        }

        allLocationCells=locationCells.get(0) + ", " +
                locationCells.get(1)+ ", " +
                locationCells.get(2);
    }

    @Override
    public String toString() {
    /**************************************************************
     Display the contents of the instance variables.
     **************************************************************/

        String textArrayList = "ArrayList Contents=";
        for ( String x : locationCells) {
            textArrayList = textArrayList.concat(x).concat(" ");
        }

        String textReply = "DotCom{" +
                " (Horizontal=" + Boolean.toString(isHorizontal) + ") " +
                textArrayList +
                "}, numOfHits=" + numOfHits +
                '}';

        return textReply;
    }

    public String checkYourself(String userGuess){
    /**********************************************************
    Check for hit against this DotCom.
    **********************************************************/

        // convert the string into an integer for checking.
        String guess = userGuess.toUpperCase();
        String result = "Miss";

        // Check fot a hit and kill.
        if (locationCells.contains(guess)) {
            numOfHits++;
            locationCells.remove(locationCells.indexOf(guess));
            if (locationCells.isEmpty()) {
                result = "Killed DotCom at location " + getAllLocationCells();
            } else {
                result = "Hit";
            }
        }

        // Return the result to the caller.
        System.out.println(" " + result);
        return result;
    }
}
