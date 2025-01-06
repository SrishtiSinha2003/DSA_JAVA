import java.util.*;
public class hashBuild {
    public static void main (String args[]) {

        // create 
        HashMap<String, Integer> hm = new HashMap<>();

        // insert O(1)
        hm.put("India", 100);
        hm.put("Nepal", 40);
        hm.put("Bhutan", 30);
        hm.put("Australia", 150);

        System.out.println(hm); // random order

        // get - O(1)
        int population = hm.get("Nepal"); // key value passed
        System.out.println(population);
        System.out.println(hm.get("Bhutan"));

        System.out.println(hm.get("Indonesia")); // null

        //Contains Key - O(1)
        System.out.println(hm.containsKey("Australia")); // true
        System.out.println(hm.containsKey("Srilanka")); // false

        // remove - O(1)
        System.out.println(hm.remove("India")); // give the value of india

        //System.out.println(hm);

        System.out.println(hm.remove("Bhutan", 30)); // true
        System.out.println(hm.remove("India", 150)); // false coz india value is 100

        // size
        System.out.println(hm.size());

        // is Empty
        System.out.println(hm.isEmpty());

        // clear
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}
