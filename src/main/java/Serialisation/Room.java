package Serialisation;

import java.io.Serializable;

import static java.lang.Math.random;

/**
 * Created by xm39 on 24/08/2016.
 */
public class Room implements Serializable {

    private enum colourOption {Red, Blue, Green, Yellow, White, Pink, Orange, Black, Grey, Purple, Cream, Turquoise};

    private int number;
    private int maxOccupants;
    private boolean occupied;
    private int numberOfOccupants;
    private colourOption colourScheme;

    public Room(int number) {
        this.number = number;

        // Set not occupied.
        occupied = false;
        numberOfOccupants=0;

        // randomise the occupancy.
        maxOccupants = (int) ((random() * 3) + 2);

        // randomise the colourScheme scheme.
        switch ((int) ((random() * 12 ) + 1)) {
            case 0:
                colourScheme = colourOption.Red; break;
            case 1:
                colourScheme = colourOption.Blue; break;
            case 2:
                colourScheme = colourOption.Green; break;
            case 3:
                colourScheme = colourOption.Yellow; break;
            case 4:
                colourScheme = colourOption.White; break;
            case 5:
                colourScheme = colourOption.Pink; break;
            case 6:
                colourScheme = colourOption.Orange; break;
            case 7:
                colourScheme = colourOption.Black; break;
            case 8:
                colourScheme = colourOption.Grey; break;
            case 9:
                colourScheme = colourOption.Purple; break;
            case 10:
                colourScheme = colourOption.Cream; break;
            case 11:
                colourScheme = colourOption.Turquoise; break;
            default:
                colourScheme = colourOption.Red; break;
        }
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setNumberOfOccupants(int numberOfOccupants) {
        this.occupied = true;
        this.numberOfOccupants = numberOfOccupants;
    }

    public int getMaxOccupants() {
        return maxOccupants;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", maxOccupants=" + maxOccupants +
                ", occupied=" + occupied +
                ", numberOfOccupants=" + numberOfOccupants +
                ", colourScheme=" + colourScheme +
                '}';
    }
}

