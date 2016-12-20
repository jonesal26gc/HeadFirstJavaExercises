package ArrayListMagnet;

import java.util.ArrayList;

/**
 * Created by xm39 on 20/12/2016.
 */

public class ArrayListMagnet {

    private static ArrayList<String> a  = new ArrayList<String>();

    public static void main(String[] args) {

        a.add(0,"Zero");
        a.add(1,"One");
        a.add(2,"Two");
        a.add(3,"Three");
        printAL(a);

        if (a.contains("Three") ) {
            a.add(4,"Four");
        }

        a.remove(2);

        printAL(a);

        if (a.indexOf("Four") != 4) {
            a.add(4, "4.2");
        }
        printAL(a);

        if ( a.contains("Two")) {
            a.add("2.2");
        }
        printAL(a);

    }

    public static void printAL(ArrayList<String> al) {

        for (String aValue : al) {
            System.out.print(aValue + " ");
        }

        System.out.println("");

    }



}
