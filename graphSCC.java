import java.util.*;
public class graphSCC {
    
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) { 
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));

    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) { // this will give all the neighbours of curr
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) { // if neigh is not visited
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {

        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++) { // this will give all the neighbours of curr
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) { // if neigh is not visited
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[], int V) {

        // step 1 : topological sort

        boolean vis[] = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        // step 2 : transpose graph

        @SuppressWarnings("unchecked")

        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<V; i++) {      // vertices
            for(int j=0; j<graph[i].size(); j++) {     // edge
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));    // reverse edge
            }
        }

        // step 3 : dfs

        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                System.out.print("SCC  --> ");
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        int V = 5; 
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosaraju(graph, V);
    }
}
