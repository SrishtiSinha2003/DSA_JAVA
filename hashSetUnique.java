import java.util.*;
public class hashSetUnique {
    public static void main(String args[]) {
        int num[] = {4, 3, 2, 1, 7, 8, 9, 4, 5, 3, 2, 8, 6, 9};

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<num.length; i++) {
            set.add(num[i]);
        }

        System.out.println("ans = " + set.size());
    }
}
