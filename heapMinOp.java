import java.util.*;
public class heapMinOp{
static int minops(ArrayList<Integer> nums) {
	int sum = 0;
	for(int i = 0 ; i < nums.size() ; i++){
	sum += nums.get(i);
	}

	// Initializing max heap
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	for(int i = 0 ; i < nums.size() ; i++){
	pq.add(nums.get(i));
	}

	double temp = sum;
	int cnt = 0;
	while (temp > sum / 2) {
	int x = pq.peek();
	pq.remove();
	temp -= Math.ceil(x * 1.0 / 2);
	pq.add(x / 2);
	cnt++;
	}

	// Return count
	return cnt;
}

// Driver code
public static void main(String args[]){
	ArrayList<Integer> nums = new ArrayList<Integer>(List.of(4, 6, 3, 9, 10, 2));
	int count = minops(nums);
	System.out.println(count);
}
}
