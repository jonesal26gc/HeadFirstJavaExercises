package DotCom;

import Utilities.UserInput;

import java.util.ArrayList;

public class DotComApp {

    // Variables.
    private static final int lengthOfEachDotCOm = 3;
    private static final int maximumOverlapAttemptsPermitted = 3;
    private static int numberOfDotComsRequired = 2;
    private static int numberOfGuesses = 0;
    private static int numberOfOverlapsEncountered = 0;
    private static ArrayList<DotCom> dotComs = new ArrayList<DotCom>();

    public static void main(String[] args) {
    /**********************************************************************
     * The DotCom game !
     **********************************************************************/

        create_targets_for_game();
        display_targets();
        play_the_game();

    }

    private static void create_targets_for_game() {
    /**********************************************************************
     * create the DotCom targets in an array.
     **********************************************************************/

        // Build the required number of DotComs.
        System.out.println("Creating " + numberOfDotComsRequired + " target(s).....");
        int x = 0;
        while ( x < numberOfDotComsRequired ){

            // create a new DotCom.
            DotCom d = new DotCom();
            d.setLocationCells();

            // If this is not the first, then check for overlap with previous
            // entries.
            boolean overlappingDotCom = false;
            for (DotCom dc : dotComs) {
                if (dc != null) {
                    //System.out.println("To check " + dc.getAllLocationCells());
                    for (int i = 0; i < lengthOfEachDotCOm; i++) {
                        for (int j = 0; j < lengthOfEachDotCOm; j++) {
                            //System.out.println(d.getLocationCell(i) + " vs " + dc.getLocationCell(j));
                            if ( d.getLocationCell(i).equals(dc.getLocationCell(j))) {
                                overlappingDotCom = true;
                            }
                        }
                    }
                }
            }

            // If non-overlapping, then add this DotCom.
            if (  ! overlappingDotCom ) {
                // Add this new DotCom to the list.
                dotComs.add(d);
                x++;
                numberOfOverlapsEncountered = 0;
            } else {
                System.out.println("overlapping DotCom found");
                numberOfOverlapsEncountered++;
                if ( numberOfOverlapsEncountered >= maximumOverlapAttemptsPermitted) {
                    System.out.println("Curtailing the target generation at " + x + " target(s) due to overlap.");
                    numberOfDotComsRequired = x;
                    break;
                }
            }
        }
    }

    private static void display_targets(){
    /**********************************************************************
     * display the DotCom targets in an array.
     **********************************************************************/

        // Display all the DotComs and their location.
        for (DotCom dc : dotComs) {
            System.out.println(dc.toString());
        }
    }

    private static void play_the_game() {
    /**********************************************************************
     * Play the game until the targets are destroyed.
     **********************************************************************/

        // Run the game until there are no more targets to hit.
        guess:
        while ( true ) {

            // get a guess from the user, and increment the count.
            numberOfGuesses++;
            String guessInput = new UserInput().getUserInputString("Give me your best shot (e.g. 'A1'): ");

            // Check your shot against each of the DotComs.
            // If not a "miss", then it must be a hit - skip remaining DotComs.
            for (DotCom dc : dotComs) {
                if ( ! dc.getLocationCells().isEmpty() ) {
                   if ( ! dc.checkYourself(guessInput).equals("Miss") ) { break; }
                }
            }

            // Loop while there are DotComs to be hit.
            for (DotCom dc : dotComs) {
                if ( ! dc.getLocationCells().isEmpty() ) { continue guess; }
            }

            // Since we're here, we must have hit them all.
            System.out.println("CONGRATULATIONS - you have hit all " +
                                numberOfDotComsRequired + " target(s) in " +
                                numberOfGuesses + " attempts.");
            break;
        }
    }
}

