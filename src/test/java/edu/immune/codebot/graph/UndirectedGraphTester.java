package edu.immune.codebot.graph;

import edu.immune.codebot.graph.undirected.traversal.UndirectedGraphBFS;
import edu.immune.codebot.graph.undirected.traversal.UndirectedGraphDFS;

public class UndirectedGraphTester {

	private static UndirectedGraph prepare() {
		UndirectedGraph graph = new UndirectedGraph(7);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		
		return graph;
	}
	
	private static void testDFS() {
		
		UndirectedGraph graph = prepare();
		UndirectedGraphDFS dfs = new UndirectedGraphDFS(graph);
		dfs.traverse(1);
		System.out.println();
		System.out.println("***** DFS Printed");
	}
	
	private static void testBFS() {
		UndirectedGraph graph = prepare();
		UndirectedGraphBFS bfs = new UndirectedGraphBFS(graph);
		bfs.traverse(1);
		System.out.println();
		System.out.println("***** BFS Printed");
	}
	
	public static void main(String[] args) {
		testDFS();
		testBFS();
	}
	
}
