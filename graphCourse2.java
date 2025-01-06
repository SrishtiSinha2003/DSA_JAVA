import java.util.*;

public class graphCourse2 {

    public static List<Integer>
    findOrder(int N, List<int[]> prerequisites)
    {
        // Initialize graph and in-degree array
        List<List<Integer> > graph = new ArrayList<>();
        int[] in_degree = new int[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            graph.get(src).add(dest);
            in_degree[dest]++;
        }

        // Initialize the queue with courses having
        // in-degree 0
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        // Process nodes with BFS
        while (!q.isEmpty()) {
            int current = q.poll();
            order.add(current);

            // Reduce in-degree for neighbors
            for (int neighbor : graph.get(current)) {
                in_degree[neighbor]--;
                if (in_degree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Check if the topological sort is possible (i.e.,
        // no cycle)
        if (order.size() == N) {
            return order;
        }
        else {
            return new ArrayList<>(); // Return an empty
                                      // list if a cycle is
                                      // detected
        }
    }

    // Example usage
    public static void main(String[] args)
    {
        int N = 4;
        List<int[]> prerequisites = Arrays.asList(
            new int[] { 1, 0 }, new int[] { 2, 0 },
            new int[] { 3, 1 }, new int[] { 3, 2 });

        List<Integer> order = findOrder(N, prerequisites);

        System.out.print("Course order: ");
        for (int course : order) {
            System.out.print(course + " ");
        }
        System.out.println();
    }
}