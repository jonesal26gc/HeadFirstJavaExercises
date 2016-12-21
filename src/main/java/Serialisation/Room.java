package Serialisation;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.random;

/**
 * Created by xm39 on 24/08/2016.
 */
public class Room implements Serializable {
    public static enum roomColour {Red, Blue, Green, Yellow, White, Pink, Orange, Black, Grey, Purple, Cream, Turquoise};

    int number;
    int maxOccupants;
    roomColour colour;
    public static Integer[] listNums = {0,1,2,3};

    public Room(int number) {
        this.number = number;

        maxOccupants = (int) ((random() * 2) + 2);

        //if ( listNums.(maxOccupants) ) {
        //    System.out.println("Yes, it's in the list !");
        //} else {
        //    System.out.println("No, it's not in the list !");
        //}

        switch ((int) ((random() * 12 ) + 1)) {
            case 0:
                colour = roomColour.Red; break;
            case 1:
                colour = roomColour.Blue; break;
            case 2:
                colour = roomColour.Green; break;
            case 3:
                colour = roomColour.Yellow; break;
            case 4:
                colour = roomColour.White; break;
            case 5:
                colour = roomColour.Pink; break;
            case 6:
                colour = roomColour.Orange; break;
            case 7:
                colour = roomColour.Black; break;
            case 8:
                colour = roomColour.Grey; break;
            case 9:
                colour = roomColour.Purple; break;
            case 10:
                colour = roomColour.Cream; break;
            case 11:
                colour = roomColour.Turquoise; break;
            default:
                colour = roomColour.Red; break;
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", maxOccupants=" + maxOccupants +
                ", colour=" + colour +
                '}';
    }
}



