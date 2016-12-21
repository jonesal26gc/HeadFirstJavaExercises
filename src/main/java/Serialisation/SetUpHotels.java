package Serialisation;

import java.io.*;
import java.util.ArrayList;

import static Serialisation.Hotel.*;
import static java.lang.Math.random;

/**
 * Created by xm39 on 24/08/2016.
 */
public class SetUpHotels {

    private static final String NEW_LINE = "\n";

    public static void main (String[] args){

        // Create an array of hotels.
        ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

        // Decide how many hotels to have (between 1 and 5).
        Integer numberOfHotels = (int) ((random() * 4 ) + 1);

        // Create each of the hotels, adding them to the array.
        for (Integer i = 0 ; i < numberOfHotels ; i++) {
            hotelList.add(new Hotel(i, "Hotel #".concat(i.toString())));
        }

        // display the contents of the objects.
        listHotels(hotelList);

        // write the objects to a serialised file.
        serialiseHotel(hotelList);

        // write the data to an export file.
        exportHotels(hotelList);

    }

    public static void serialiseHotel(ArrayList<Hotel> hotelList) {

        try {
            System.out.println("Creating Hotel serialisation file 'Hotel.ser'.");
            OpenSerialise("data/Hotel.ser");
            for ( Hotel i : hotelList ) { WriteSerialise(i); }
            CloseSerialise();
        } catch (IOException ex) {
            System.out.println("Error writing to Hotel serialisation file.");
        } finally {}
    }

    public static void exportHotels(ArrayList<Hotel> hotelList) {

        try {
            System.out.println("Creating Hotel export file 'Hotel.dat'.");
            File hotelExport = new File("data/Hotel.dat");
            BufferedWriter bufWrite = new BufferedWriter(new FileWriter(hotelExport));

            // Loop through the hotels, displaying their characteristics.
            for ( Hotel i : hotelList ) {
                bufWrite.write(i.toString() + NEW_LINE);
                for ( Room r : i.r ) {
                    bufWrite.write(r.toString() + NEW_LINE);
                }
                System.out.println("");
            }
            bufWrite.close();
        } catch (IOException ex) {
            System.out.println("An IO exception occurred whilst writing serialised data.");
            ex.printStackTrace();
        }
    }

    public static void listHotels(ArrayList<Hotel> hotelList) {

        // Loop through the hotels, displaying their characteristics.
        for ( Hotel i : hotelList ) {
            System.out.println(i.toString());
            for ( Room r : i.r ) {
                System.out.println(r.toString());
            }
            System.out.println("");
        }

    }

}
