import java.util.*;
public class greedyMaxLenPair {
    public static void main(String args[]) { //O(nlogn)
    int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

    Arrays.sort(pairs, Comparator.comparingDouble(o-> o[1]));
     int chainLen = 1; // 1st pair is always included in the answer
     int chainEnd = pairs[0][1]; // chain end (num)

     for(int i=1; i<pairs.length; i++) {
        if(pairs[i][0] > chainEnd) { // agr pair ka start chain k end se bada hoga to uss pair ko chain k end m add kr denge
            chainLen++;
            chainEnd = pairs [i][1]; // chain ka end ab added pair ka end ho jayega
        }
        }
        System.out.println("max length of chain = " + chainLen);
    }
}
