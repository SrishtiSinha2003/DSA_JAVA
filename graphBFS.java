import java.util.*;
public class graphBFS {
    
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) { //O(N)
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();

       // boolean vis[] = new boolean[graph.length];

        q.add(0); // source

        while(!q.isEmpty()) {
            int curr = q.remove(); // curr ko remove kr do queue se

            if(!vis[curr]) { // if curr is not visited then print curr
                System.out.print(curr + " ");
                vis[curr] = true; // make vis for curr true

                for(int i=0; i<graph[curr].size(); i++) { // curr ka sara neighbours
                    Edge e = graph[curr].get(i); // sbka edge
                    q.add(e.dest); // sara edge ka destination
                } 
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {

        // visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) { // curr ka sara edges
            Edge e = graph[curr].get(i); // curr ka edge e m store hoga
            if(!vis [e.dest]) {
            dfsUtil(graph, e.dest, vis);
            } //next curr e ka dest hoga
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {  // O(V + E)
        if(src == dest) {
            return true;
        }

        vis[src] = true;

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        int V = 7;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        bfs(graph);

        System.out.println();

        dfs(graph);

        System.out.println();

        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }
}
