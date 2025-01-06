import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	// Main function to check whether it's possible to
	// finish all tasks or not
	public boolean canFinish(int numTasks,
							int[][] prerequisites)
	{
		ArrayList<ArrayList<Integer> > graph
			= new ArrayList<>(numTasks);
		int[] inDegree = new int[numTasks];

		for (int i = 0; i < numTasks; i++) {
			graph.add(new ArrayList<>());
		}

		// Initialize the graph and in-degrees
		for (int[] edge : prerequisites) {
			graph.get(edge[0]).add(edge[1]);
			inDegree[edge[1]]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		// Push all the nodes with no dependencies
		// (in-degree = 0) into the queue
		for (int i = 0; i < numTasks; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();

			// Reduce the in-degree of all neighbors by 1
			for (int neighbor : graph.get(node)) {
				inDegree[neighbor]--;

				// Push the neighboring node if we have
				// covered all its dependencies (in-degree =
				// 0)
				if (inDegree[neighbor] == 0) {
					queue.add(neighbor);
				}
			}
		}

		// Check if there is a node whose in-degree is not
		// zero
		for (int i = 0; i < numTasks; i++) {
			if (inDegree[i] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		int numTasks = 4;
		int[][] prerequisites
			= { { 1, 0 }, { 2, 1 }, { 3, 2 } };

		Solution solution = new Solution();
		if (solution.canFinish(numTasks, prerequisites)) {
			System.out.println(
				"Possible to finish all tasks");
		}
		else {
			System.out.println(
				"Impossible to finish all tasks");
		}
	}
}
