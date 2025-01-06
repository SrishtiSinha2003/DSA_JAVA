import java.util.*;
public class heapNropes {
    public static void main(String args[]) {
        int ropes[] = {2, 3, 3, 4, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while(pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove(); // since priority queue ascending order m elements ko nikalta h isly sbse pehle min niklega then usse bada
            cost += min + min2;
            pq.add(min+min2);
        }
        System.out.println("cost : " +cost);
    }
}
