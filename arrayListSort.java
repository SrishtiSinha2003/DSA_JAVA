import java.util.*;
public class arrayListSort {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        list.add(6);
        list.add(4);
        list.add(5);

        System.out.println(list);
        Collections.sort(list); //ascending 
        System.out.println(list);

        //descending
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}