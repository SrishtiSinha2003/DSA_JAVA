import java.util.*;

public class Q2_Connect_N_Ropes {

    public static int minCost(int[] rope) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min Priority Queue

        // store array elements in Queue
        for (int i = 0; i < rope.length; i++) {
            pq.add(rope[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int lowest = pq.remove();
            int secondLowest = pq.remove();

            cost += (lowest + secondLowest);

            int newRope = lowest + secondLowest;
            pq.add(newRope);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] rope = { 4, 3, 2, 6 };
        System.out.println(minCost(rope));
    }
}