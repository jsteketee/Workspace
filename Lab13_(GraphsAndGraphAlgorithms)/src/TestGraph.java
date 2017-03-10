
public class TestGraph {

	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addVertex("Zero");
		g.addVertex("One");
		g.addVertex("Two");
		g.addVertex("Three");
		g.addVertex("Four");
		g.addVertex("Five");
		g.addVertex("Six");
		g.addVertex("Seven");
		g.addVertex("Eight");
		g.addVertex("Nine");

		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(0,6);
		g.addEdge(0,7);
		g.addEdge(1,6);
		g.addEdge(1,5);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(2,8);
		g.addEdge(2,4);
		g.addEdge(4,9);
		g.addEdge(8,9);
		
		String output = g.BFS(3);
		System.out.println("BFS starting at 3");
		System.out.println(output);

		output = g.DFS(3);
		System.out.println("DFS starting at 3");
		System.out.println(output);

		output = g.shortestPath(3);
		System.out.println("Shortest paths starting at 3");
		System.out.println(output);

		Graph g2 = new Graph(10);
		g2.addVertex("Zero");
		g2.addVertex("One");
		g2.addVertex("Two");
		g2.addVertex("Three");
		g2.addVertex("Four");
		g2.addVertex("Five");
		g2.addVertex("Six");
		g2.addVertex("Seven");
		g2.addVertex("Eight");
		g2.addVertex("Nine");

		g2.addDirectedEdgeWithWeight(0,1,5);
		g2.addDirectedEdgeWithWeight(0,3,7);
		g2.addDirectedEdgeWithWeight(0,6,9);
		g2.addDirectedEdgeWithWeight(0,7,6);
		g2.addDirectedEdgeWithWeight(1,6,3);
		g2.addDirectedEdgeWithWeight(1,5,9);
		g2.addDirectedEdgeWithWeight(1,2,2);
		g2.addDirectedEdgeWithWeight(2,5,6);
		g2.addDirectedEdgeWithWeight(2,8,7);
		g2.addDirectedEdgeWithWeight(2,4,9);
		g2.addDirectedEdgeWithWeight(3,5,6);
		g2.addDirectedEdgeWithWeight(4,9,3);
		g2.addDirectedEdgeWithWeight(8,9,3);

		output = g2.Dijkstras(0);
		System.out.println("Dijkstra's algorithm starting at 0");
		System.out.println(output);
		
	}

}
