import java.util.*;
public class heapInsert {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data) {
            //add at last index
            arr.add(data);
            // child index
            int x = arr.size()-1; // last index
            // parent index - child index minus one divided by two
            int par = (x-1)/2;

            while(arr.get(x) < arr.get(par)) { // O(log n)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par)); // x k jagah m par set kr diye
                arr.set(par, arr.get(temp));

                x = par;
                par = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }

        public void heapify(int i) {
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left; // left agr last element se chota h or minIdx se v chota h to wo minIdx bn jayega
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right; // similarily wahi right k sth v hoga
            }

            if(minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx)); // i k jagah pe minIdx
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        public int remove() {
            int data = arr.get(0); // data ka index

            // step 1 - swap 1st and last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1)); // index 0 pe last element
            arr.set(arr.size()-1, temp);

            // step 2 - delete last element
            arr.remove(arr.size()-1);

            // heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }
    public static void main (String args[]) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(9);
        h.add(5);

        while(!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
