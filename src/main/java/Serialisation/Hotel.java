package Serialisation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Math.random;

/**
 * Created by xm39 on 24/08/2016.
 */
public class Hotel implements Serializable{

    private int number;
    private String name;
    private Integer numberOfRooms;
    public ArrayList<Room> roomList = new ArrayList<Room>();

    private static FileOutputStream fileStream;
    private static ObjectOutputStream os;

    public Hotel(int number, String name) {
        this.number = number;
        this.name = name;

        // Set the number of rooms and create them.
        numberOfRooms = (int) ((random() * 11 ) + 1);

        for ( int i = 1 ; i <= numberOfRooms ; i++) {
            roomList.add(new Room(i));
        }
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                '}';
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }
    public String getName() {
        return name;
    }

    public void listRooms() {

        for ( int i = 0 ; i < numberOfRooms ; i++) {
            System.out.println(roomList.get(i).toString());
        }
    }

    public static void OpenSerialise(String fileName) throws IOException {
        // this method opens the serialisation file.
        //System.out.println("Opening serialisation file.");

        try {
            fileStream = new FileOutputStream(fileName);
            os = new ObjectOutputStream(fileStream);
        } catch (IOException ex) {
            System.out.println("An IO exception occurred whilst opening serialised data.");
            ex.printStackTrace();
            throw ex;
        } finally {}

    }

    public static void WriteSerialise(Hotel h){
        // This method write a single Hotel object to the serialised file.
        try {
            os.writeObject(h);
        } catch (IOException ex) {
            System.out.println("An IO exception occurred whilst writing serialised data.");
            ex.printStackTrace();
        } finally {}

    }

    public static void CloseSerialise(){
        // this method closes the serialised file.

        //System.out.println("Closing serialisation file.");

        try {
            os.close();
        } catch (IOException ex) {
            System.out.println("An IO exception occurred whilst closing serialised data.");
            ex.printStackTrace();
        } finally {}

    }

    public class roomSortByOccupiedStatus implements Comparator<Room> {
        public int compare (Room room1, Room room2) {

            if ( ( room1.isOccupied() ) & ( ! room2.isOccupied() ) ) {
                return +1;
            } else {
                if ( (! room1.isOccupied() ) & ( room2.isOccupied() ) ) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public int bookARoom(int numberOfOccupantsRequested) {

        // Sort by occupancy status.
        ArrayList<Room> sortedRoom_list2 = new ArrayList<Room>(roomList);
        Collections.sort(sortedRoom_list2,new roomSortByOccupiedStatus());

        // sort the list of rooms into descending occupancy sequence.
        ArrayList<Room> sortedRoom_list = new ArrayList<Room>(roomList);
        Collections.sort(sortedRoom_list);

        for (Room r:sortedRoom_list) {
            System.out.println("Hotel " + this.number +
                    "room occupancy: " + r.getMaxOccupants());
        }

        // Having sorted the list, find the first available room in the sequence.
        for (Room i : sortedRoom_list) {
            if ( (! i.isOccupied()) & i.getMaxOccupants() >= numberOfOccupantsRequested ) {
                int j = roomList.indexOf(i);
                roomList.get(j).setNumberOfOccupants(numberOfOccupantsRequested);
                return roomList.get(j).getNumber();
            }
        }

        // no such room available.
        return 0;
    }

}
