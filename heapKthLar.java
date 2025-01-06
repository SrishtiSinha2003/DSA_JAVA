import java.util.*;
public class heapKthLar {

    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static int k;
    static ArrayList<Integer> getAllKth(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int val=0; val<arr.length; val++) { // for(int val : arr)
            if(min.size() < k) {
                min.add(val);
            } else {
                if(val > min.peek()) {
                    min.poll(); // remove
                    min.add(val);
                }
            }
            if(min.size() >= k) {
                list.add(min.peek());
            } else {
                list.add(-1);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        k=4;
        int arr[] = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> res = getAllKth(arr);
        for(int x=0; x<res.size(); x++) {
            System.out.print(x + " ");
        }
    }
}
