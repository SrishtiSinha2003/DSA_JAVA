import java.util.*;
public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(1);
        hs.add(3);
        hs.add(0);
        hs.add(3);
        hs.add(7);
        hs.add(6);
        hs.add(4);
        hs.add(4);
        hs.add(null);

        System.out.println(hs); // duplicate value will not get printed

        if(hs.contains(2)) {
            System.out.println("contains");
        } else {
            System.out.println("doesnt");
        }
        hs.remove(0);
        System.out.println(hs);

        System.out.println(hs.size()); // hs.clear() hs.isEmpty()

        @SuppressWarnings("rawtypes")
        Iterator it = hs.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        for(Integer i : hs) { // for integer(data type defined in the hashset) i (apne se variable lena hai) : hs (hashset ka naam)
            System.out.println(i);
        }

        LinkedHashSet<String> HS = new LinkedHashSet<>();
        HS.add("S");
        HS.add("N");
        HS.add("V");
        HS.add("null");

        System.out.println(HS); // order of insertion is maintained

        TreeSet<String> ts = new TreeSet<>();
        ts.add("h");
        ts.add("U");
        ts.add("q");
        ts.add("A");

        System.out.println(ts); // ascending order
    }
}
