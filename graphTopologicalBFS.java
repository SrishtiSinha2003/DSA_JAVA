import java.util.*;
public class graphTopologicalBFS {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) { // true - cycle
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {

        for(int i=0; i<graph.length; i++) {
            int v = i;
            for(int j=0; j<graph[v].size();  j++) {    // edge nikal lo 
                Edge e = graph[v].get(j);
                indeg[e.dest]++;     // edge k in degree ko ++ kr do
            }
        }
     }

    public static void topSort(ArrayList<Edge>[] graph) {

        int indeg[] = new int[graph.length];

        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);   // indegree 0 hoga to queue m add kr do
            }
        }
        // bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);   // get the neighbours of curr
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V = 6; 
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
