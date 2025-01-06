import java.util.*;
public class arrayListBeautiful {
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        divideConque(1, 1, res, n);
        return res;
    }
    private static void divideConque(int start, int increment, ArrayList<Integer> res, int n) {
        if(start + increment > n) {
            res.add(start);
            return;
        }
        divideConque(start, 2*increment, res, n);
        divideConque(start + increment, 2*increment, res, n);
    }
    public static void main(String args[]) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(8);
        res.add(3);
        res.add(4);

        System.out.println(beautifulArray(4));
    }
}
