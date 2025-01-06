import java.util.*;
public class hashTicket {

    public static String GetStartingPoint(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);  // tickets.get(key) will give value of the key that will we store as the new key mtlb value ab key bn jayega and jo pehle key tha ab value 
        }

        for(String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key; // if the key is there in ticket hashmap but not in revmap then uss key ko return kr denge
            }
        }
        return null;
    }
    public static void main(String args[]) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = GetStartingPoint(tickets);
        System.out.print(start);

        for(@SuppressWarnings("unused") String key : tickets.keySet()) {
            System.out.print(" - > " + tickets.get(start)); // tickets.get(start) will give the ending point from the start ie the value of the key (start)
            start = tickets.get(start);  
        }
        System.out.println();
    }
}
