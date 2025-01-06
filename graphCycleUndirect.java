import java.util.*;

public class graphCycleUndirect {
    
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) { //O(N)
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean bfs(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i] && bfsCycle(graph, vis, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean bfsCycle(ArrayList<Edge>[] graph, boolean vis[], int s) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();

       // boolean vis[] = new boolean[graph.length];

        q.add(s); // source

        while(!q.isEmpty()) {
            int curr = q.remove(); // curr ko remove kr do queue se

            if(!vis[curr]) { // if curr is not visited then print curr
                return true;
            }
                vis[curr] = true; // make vis for curr true

                for(int i=0; i<graph[curr].size(); i++) { // curr ka sara neighbours
                    Edge e = graph[curr].get(i); 
                        q.add(e.dest);
                }
                
            }
            return false;
    }

    public static void main(String args[]) {

        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(bfs(graph));
    }
}

