import java.util.*;

public class arrayListBeaut {

    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1); // initialize

        while (ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            int ans_size = ans.size();

            for (int i = 0; i < ans_size; i++) {
                // add odd value in temp array
                if ((ans.get(i) * 2 - 1) <= n) {
                    temp.add(ans.get(i) * 2 - 1);
                }
                // add even value in temp array
                if ((ans.get(i) * 2) <= n) {
                    temp.add(ans.get(i) * 2);
                }
            }
            // transfer all value in original array from temp array
            ans = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(beautifulArray(n));
    }
}