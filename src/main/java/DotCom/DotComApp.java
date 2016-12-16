package DotCom;

public class DotComApp {

    public static void main(String[] args) {

        DotCom[] dotComs = new DotCom[3];

        for ( int x=0; x<3 ; x++){

            // create a new DotCom.
            DotCom d = new DotCom();
            d.setLocationCells();

            // If this is not the first, then check for overlap with previous
            // entries.
            boolean overlappingDotCom = false;
            for (DotCom dc : dotComs) {
                if (dc != null) {
                    //System.out.println("To check " + dc.getAllLocationCells());
                    for ( int i=0 ; i < 3 ; i++) {
                        for ( int j=0 ; j < 3 ; j++) {
                            //System.out.println(d.getLocationCell(i) + " vs " + dc.getLocationCell(j));
                            if ( d.getLocationCell(i).equals(dc.getLocationCell(j))) {
                                overlappingDotCom = true;
                            }
                        }
                    }
                }
            }

            if ( overlappingDotCom ) {
                System.out.println("overlapping DotCom found");
            }
            // Add this new DotCom to the list.
            dotComs[x] = d;
        }

        for (DotCom dc : dotComs) {
            System.out.println(dc.toString());
            //System.out.println(dc.getAllLocationCells());
        }

    }
}
