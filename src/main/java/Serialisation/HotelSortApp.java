package Serialisation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by xm39 on 23/12/2016.
 */
public class HotelSortApp {

    public static void main(String[] args) {


        /**************************************************************************
         * generate a list of hotels, and sort them into descending size sequence.
         * Finally, display them.
         */

        HotelSort hs = new HotelSort();
        hs.displayHotels();
        hs.hotelList = hs.sortHotels();
        hs.displayHotels();

    }
}
