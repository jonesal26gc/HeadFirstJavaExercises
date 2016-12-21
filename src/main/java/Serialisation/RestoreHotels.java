package Serialisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RestoreHotels {

    public static void main (String[] args){
        // this procedure re-establishes previously saved objects onto the heap.

        // read the objects from a serialised file.
        ArrayList<Hotel> h = deserialiseHotels();

        // display the contents of the objects.
        System.out.println("there are " + h.size() + " hotels in the array");
        listHotels(h);
    }

    public static ArrayList<Hotel> deserialiseHotels() {

        Object obj;
        ArrayList<Hotel> h = new ArrayList<Hotel>();

        try {
            System.out.println("opening serialisation file.");
            FileInputStream fileStream = new FileInputStream("Hotel1.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);

            System.out.println("reading from serialisation file.");
            try {
                while (true) {
                    obj = os.readObject();
                    h.add((Hotel) obj);
                }
            } catch(ClassNotFoundException ex){
                System.out.println("Class not found.");
                ex.printStackTrace();
            } finally {
                os.close();
                return h;
            }

        } catch (IOException ex) {
            System.out.println("An IO exception occurred whilst reading serialised data.");
            ex.printStackTrace();
        } finally {
        }

        return h;
    }


    public static void listHotels(ArrayList<Hotel> h) {

        int index = 0;
        Hotel h1;
        while (h.size() > index) {
            h1 = h.get(index);
            System.out.println(h1.toString());
            h1.listRooms();
            index++;
        }

    }

}
