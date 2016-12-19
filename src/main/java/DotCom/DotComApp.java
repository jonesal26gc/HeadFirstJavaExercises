package DotCom;

import Utilities.UserInput;

import java.util.ArrayList;

public class DotComApp {

    public static void main(String[] args) {

        // Variables.
        int numberOfDotComsRequired = 3;
        int numberOfGuesses = 0;
        int lengthOfDotCom = 3;
        int numberOfOverlaps = 0;
        int maximumOverlapAttempts = 3;

        ArrayList<DotCom> dotComs = new ArrayList<DotCom>();

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
                    for ( int i=0 ; i < lengthOfDotCom ; i++) {
                        for ( int j=0 ; j < lengthOfDotCom ; j++) {
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
                numberOfOverlaps = 0;
            } else {
                System.out.println("overlapping DotCom found");
                numberOfOverlaps++;
                if ( numberOfOverlaps >= maximumOverlapAttempts ) {
                    System.out.println("Curtailing the target generation at " + x + " target(s) due to overlap.");
                    numberOfDotComsRequired = x;
                    break;
                }
            }

        }

        // Display all the DotComs and their location.
        for (DotCom dc : dotComs) {
            System.out.println(dc.toString());
            //System.out.println(dc.getAllLocationCells());
        }

        // Run the game until there are no more targets to hit.
        guess:
        while ( true ) {

            // get a guess from the user, and increment the count.
            numberOfGuesses++;
            String guessInput = new UserInput().getUserInputString("Give me your best shot (e.g. 'A1'): ");

            // Check your shot against each of the DotComs.
            // If not a "miss", then it must be a hit - skip remaining DotComs.
            for (DotCom dc : dotComs) {
                if ( ! dc.checkYourself(guessInput).equals("Miss") ) {
                    break; }
            }

            // Loop while there are DotComs to be hit.
            for (DotCom dc : dotComs) {
                if ( ! dc.getLocationCells().isEmpty() ) { continue guess; }
            }

            // Since we're here, we must have hit them all.
            System.out.println("CONGRATULATIONS - you have hit all " + numberOfDotComsRequired + " target(s) in " + numberOfGuesses + " attempts.");
            break;

        }
    }

    private void create_targets() {




    }


}

