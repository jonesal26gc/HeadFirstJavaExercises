package SortMountains;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by xm39 on 23/12/2016.
 */
public class SortMountains {

    LinkedList<Mountain> mtn = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain>{

        public int compare(Mountain o1, Mountain o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    class HeightCompare implements Comparator<Mountain>{

        public int compare(Mountain o1, Mountain o2) {
            return o1.getHeight() - o2.getHeight();
        }
    }

    public static void main(String[] args) {

        SortMountains sm = new SortMountains();
        sm.go();

        System.out.println("First: " + sm.mtn.getFirst().toString());
        System.out.println("Last: " + sm.mtn.getLast().toString());


        // Move the elements to a HashMap.
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        while (sm.mtn.size() > 0) {
            Mountain m = sm.mtn.removeFirst();
            System.out.println(m.toString());

            hm.put(m.getName(),m.getHeight());
        }

        for (int i =0 ; i < hm.size() ; i++) {
            System.out.println("HashMap entry #" + i + " is " + hm.get(i));
        }









    }

    private void go() {
        mtn.add(new Mountain("Longs",14255));
        mtn.add(new Mountain("Elbert",14433));
        mtn.add(new Mountain("Maroon",14156));
        mtn.add(new Mountain("Castle",14265));

        System.out.println("as entered:");
        for (Mountain i :mtn) { System.out.println("    " + i.toString());}

        NameCompare nc = new NameCompare();
        Collections.sort(mtn,nc);
        System.out.println("by name:");
        for (Mountain i :mtn) { System.out.println("    " + i.toString());}

        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn,hc);
        System.out.println("by height:");
        for (Mountain i :mtn) { System.out.println("    " + i.toString());}
    }
}
