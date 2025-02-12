public class graphDJScycle {
	int V, E;              // V-> no. of vertices & E->no.of edges
	Edge edge[];           // /collection of all edges

	class Edge {
		int src, dest;
	}

	// Creates a graph with V vertices and E edges

	graphDJScycle(int v, int e) {
		
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	// A utility function to find the subset of an element i

	int find(int parent[], int i) {

		if (parent[i] == i)
			return i;
		return find(parent, parent[i]);
	}

	// A utility function to do union of two subsets

	void Union(int parent[], int x, int y) {
		parent[x] = y;
	}

	// The main function to check whether a given graph contains cycle or not

	int isCycle(graphDJScycle graph) {

		// Allocate memory for creating V subsets

		int parent[] = new int[graph.V];

		// Initialize all subsets as single element sets

		for (int i = 0; i < graph.V; ++i)
			parent[i] = i;

		// Iterate through all edges of graph, find subset of both vertices of every edge, if both subsets are same, then there is cycle in graph.

	for (int i = 0; i < graph.E; ++i) {

	int x = graph.find(parent, graph.edge[i].src);
	int y = graph.find(parent, graph.edge[i].dest);

	    if (x == y)
			return 1;

		graph.Union(parent, x, y);

	}
	return 0;
}

public static void main(String[] args) {

		/* Let us create the following graph
		0
		| \
		| \
		1---2 */

		int V = 3, E = 3;
		graphDJScycle graph = new graphDJScycle(V, E);

		// add edge 0-1

		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2

		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2

		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (graph.isCycle(graph) == 1)
			System.out.println("Graph contains cycle");
		else
		System.out.println("Graph doesn't contain cycle");
	}
}
