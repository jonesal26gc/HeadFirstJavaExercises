package Serialisation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by xm39 on 23/12/2016.
 */
public class HotelSort {

    public ArrayList<Hotel> hotelList;
    private static final String NEW_LINE = "\n";

    public HotelSort() {
        hotelList = new ArrayList<Hotel>();

        // create the list of Hotels.
        for (int i=1 ; i<21 ; i++ ) {
            hotelList.add(new Hotel(i,"Hotel " + i));
        }
    }

    public ArrayList<Hotel> sortHotels(){

        // sort the list of hotels.
        ArrayList<Hotel> sortedList = hotelList;
        Collections.sort(sortedList,new sortOnSizeOfHotel());
        return sortedList;
    }

    public void displayHotels() {

        for (Hotel i:hotelList) {
            System.out.println(i.toString());
        }
        System.out.println("");
    }

    // define the Comparator for sorting into descending size sequence.
    class sortOnSizeOfHotel implements Comparator<Hotel> {
        public int compare(Hotel o1, Hotel o2) {
            return o2.getNumberOfRooms() - o1.getNumberOfRooms();
        }
    }
}
