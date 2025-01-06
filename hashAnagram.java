import java.util.*;
public class hashAnagram {

    public static boolean validAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1) {
                    map.remove(ch); // 1 h to hta do
                } else {
                    map.put(ch, map.get(ch) -1); // 1 se jyda h to minus kr do
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main (String args[]) {
        String s = "race";
        String t ="carfe";

        System.out.println(validAnagram(s, t));
    }
}
