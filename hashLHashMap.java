import java.util.*;
public class hashLHashMap {
    public static void main(String args[]) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("a", 4);
        lhm.put("b", 2);
        lhm.put("n", 6);
        lhm.put("w", 9);

        System.out.println(lhm);

       // TreeMap<String, Integer> tm = new TreeMap<>();
       // tm.put("a", 4);
       // tm.put("z", 2);
       // tm.put("n", 6);
       // tm.put("w", 9);

        //System.out.println(tm); // alphabetical order

    }
}
