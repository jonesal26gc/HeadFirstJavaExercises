package DotCom;

import Utilities.UserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DotComApp {

    // Variables.
    private static final int lengthOfEachDotCOm = 3;
    private static final int maximumOverlapAttemptsPermitted = 3;
    private static int numberOfDotComsRequired = 3;
    private static int numberOfGuesses = 0;
    private static int numberOfOverlapsEncountered = 0;
    private static ArrayList<DotCom> dotComs = new ArrayList<DotCom>();

    public int compareTo(Object o) {
        return 0;
    }

    public static void main(String[] args) {
    /**********************************************************************
     * The DotCom game !
     **********************************************************************/

        create_targets_for_game();
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
                //System.out.println("overlapping DotCom found");
                numberOfOverlapsEncountered++;
                if ( numberOfOverlapsEncountered >= maximumOverlapAttemptsPermitted) {
                    System.out.println("Curtailing the target generation at " + x + " target(s) due to overlap.");
                    numberOfDotComsRequired = x;
                    break;
                }
            }
        }
    }

    // To sort an ArrayList by String field, you must use a comparator.
    // For strings, each character's UNICODE value is used.
    // If equal, zero is returned else negative (field1 < field2) or positive value.
    public static Comparator<DotCom> sortDotComByString = new Comparator<DotCom>() {
        public int compare(DotCom d1, DotCom d2) {
            String field1 = d1.getAllLocationCells().toUpperCase();
            String field2 = d2.getAllLocationCells().toUpperCase();

            // For ascending sequence, use the following:
            return field1.compareTo(field2);

            // For descending sequence, use the following:
            //return field2.compareTo(field1);
        }
    };

    // To sort an ArrayList by Integer field, you must use a comparator.
    // If equal, zero is returned else negative (field1 < field2) or positive value.
    public static Comparator<DotCom> sortDotComByInteger = new Comparator<DotCom>() {
        public int compare(DotCom d1, DotCom d2) {
            int field1 = d1.getNumOfHits();
            int field2 = d2.getNumOfHits();

            // For ascending sequence, use the following:
            //return ( field1 - field2 );

            // For descending sequence, use the following:
            return ( field2 - field1 );
        }
    };

    // To sort an ArrayList by Integer/String fields, you must use a comparator.
    // For strings, each character's UNICODE value is used.
    // If equal, zero is returned else negative (field1 < field2) or positive value.
    public static Comparator<DotCom> sortDotComByIntegerAndString = new Comparator<DotCom>() {
        public int compare(DotCom d1, DotCom d2) {
            int fieldInt1 = d1.getNumOfHits();
            int fieldInt2 = d2.getNumOfHits();
            String fieldString1 = d1.getAllLocationCells().toUpperCase();
            String fieldString2 = d2.getAllLocationCells().toUpperCase();

            // Use a combination of the two pairs of fields.
            if ( (fieldInt2 - fieldInt1) == 0 ) {
                return fieldString1.compareTo(fieldString2);
            } else {
                return ( fieldInt2 - fieldInt1 );
            }
        }
    };

    private static void display_targets(){
    /**********************************************************************
     * display the DotCom targets in an array.
     **********************************************************************/

        // sort the ArrayList containing DotCom objects !
        Collections.sort(dotComs,sortDotComByIntegerAndString);

        // Display all the DotComs and their location.
        for (DotCom dc : dotComs) {
            if ( ! dc.getLocationCells().isEmpty() ) {
                System.out.println(dc.toString());
            }
        }
    }

    private static void play_the_game() {
    /**********************************************************************
     * Play the game until the targets are destroyed.
     **********************************************************************/

        // Run the game until there are no more targets to hit.
        guess:
        while ( true ) {

            // display the list in descending Hit sequence every 10 guesses.
            if ( (Math.round( numberOfGuesses / 5)) == ( (double) numberOfGuesses / 5) ) {
                display_targets();
            }

            // get a guess from the user, and increment the count.
            numberOfGuesses++;
            String guessInput = new UserInput().getUserInputString("Give me your best shot (e.g. 'A1'): ");

            if ( guessInput.equals("exit") ) { break; } // to break out of the game !!!

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

