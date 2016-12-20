package RowBoat;
public class Boat {

    private int length;
    private String name;

    public Boat() {
        this.name = "Boat name";
        this.length = 50;
    }

    public Boat(int length,String name) {
        this.length = length;
        this.name = name;
    }

    public void setLength (int len) {

        this.length = len;
    }

    public int getLength() {
        return this.length;
    }

    public void move() {
        System.out.print("drift" + " ");
    }

    public String toString() {
        return "Boat{" +
                "length=" + length +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
