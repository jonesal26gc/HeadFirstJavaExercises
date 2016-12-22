package Serialisation;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RestoreHotels {

    public static void main (String[] args){

        // read the objects from a serialised file.
        ArrayList<Hotel> hotelList = deserialiseHotels();

        // add a new hotel.
        //hotelList.add(new Hotel(4,"An extra Hotel"));

        // display the contents of the objects.
        System.out.println("there are " + hotelList.size() + " hotels in the array");
        listHotels(hotelList);

    }

    public static ArrayList<Hotel> deserialiseHotels() {

        Object obj;
        ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

        try {
            System.out.println("Opening serialisation file from which to restore Hotels.");
            FileInputStream fileStream = new FileInputStream("data/Hotel.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);

            try {
                while (true) {
                    obj = os.readObject();
                    hotelList.add((Hotel) obj);
                }
            } catch (EOFException ex) {
                os.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (IOException ex) {
            System.out.println("An IO exception occurred whilst opening serialisation file.");
            ex.printStackTrace();
        }

        return hotelList;
    }

    private static void listHotels(ArrayList<Hotel> h) {

        // Loop through the hotels and list them.
        for (Hotel i : h) {
            System.out.println(i.toString());
        }
    }
}
