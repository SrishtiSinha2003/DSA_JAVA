import java.util.*;
public class heapNslotsTime {

	// Function to return the minimum
	// time to fill all the slots
	public static void minTime(int arr[], 
							int N, int K)
	{
		
		// Stores visited slots
		Queue<Integer> q = new LinkedList<>();

		// Checks if a slot is visited or not
		boolean vis[] = new boolean[N + 1];
		int time = 0;

		// Insert all filled slots
		for (int i = 0; i < K; i++) {

			q.add(arr[i]);
			vis[arr[i]] = true;
		}

		// Iterate until queue is
		// not empty
		while (q.size() > 0) {

			// Iterate through all slots
			// in the queue
			for (int i = 0; i < q.size(); i++) {

				// Front index
				int curr = q.poll();

				// If previous slot is
				// present and not visited
				if (curr - 1 >= 1 && 
					!vis[curr - 1]) {
					vis[curr - 1] = true;
					q.add(curr - 1);
				}

				// If next slot is present
				// and not visited
				if (curr + 1 <= N && 
					!vis[curr + 1]) {

					vis[curr + 1] = true;
					q.add(curr + 1);
				}
			}

			// Increment the time
			// at each level
			time++;
		}

		// Print the answer
		System.out.println(time - 1);
	}

	// Driver Code
	public static void main(String[] args)
	{
		int N = 6;
		int arr[] = { 2, 6 };
		int K = arr.length;

		// Function Call
		minTime(arr, N, K);
	}
}
