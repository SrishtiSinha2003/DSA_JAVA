import java.util.*;
public class arrayList {
    public static void main (String args[]) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1); // tc- O(1)
        list.add(2);
        list.add(3);

        list.add(1, 9);   // O(n)

        System.out.println(list);
        System.out.println(list.size());

        // print the arraylist

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        } System.out.println();

        //get operation   // tc - O(1)
        int element = list.get(2);
        System.out.println(element);

        //delete  // tc- O(n)
        list.remove(1);
        System.out.println(list);

        // set element  // tc - O(n)
        list.set(0, 10);
        System.out.println(list);

        //contains  // tc- O(n)
        System.out.println(list.contains(10));
        System.out.println(list.contains(1));
    }
}
