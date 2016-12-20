package RowBoat;
public class TestBoats {

    public static void main (String [] args) {

        Boat b1 = new Boat(5,"RowyTheBoat");
        SailBoat b2 = new SailBoat();
        RowBoat b3 = new RowBoat();

        b2.setLength(32);

        b1.move();
        b3.move();
        b2.move();

        //b3.rowTheBoat();

        //System.out.println("\n" + b1.toString());
        //System.out.println("\n" + b2.toString());
        //System.out.println("\n" + b3.toString());

    }

}
