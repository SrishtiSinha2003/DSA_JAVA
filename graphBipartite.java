import java.util.*;
public class graphBipartite {
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

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }
       
    public static boolean isBiPartite(ArrayList<Edge>[] graph) {

        int col[] = new int[graph.length]; // here in col we are storing numbers like -1, 1 and 0 so its data type is int
        for(int i=0; i<col.length; i++) {
            col[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while(!q.isEmpty()) {
                   int curr = q.remove();
                   for(int j=0; j<graph[curr].size(); j++) { // for the neighbours of curr
                        Edge e = graph[curr].get(j); // edge milega
                        if(col[e.dest] == -1) { //agr curr ka color -1 hai
                            int nextCol = col[curr] == 0 ? 1 : 0; //curr ka col 0 hai to nextCol 1 ane to 0
                            col[e.dest] = nextCol; // curr ka neigh ka col hoga nextCol
                            q.add(e.dest); // add in q
                        } else if(col[e.dest] == col[curr]) {
                            return false;
                        }
                    } 
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int V = 5; 
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBiPartite(graph));
    }
}
