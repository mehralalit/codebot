package edu.immune.codebot.graph.traversal;

import org.junit.Before;
import org.junit.Test;

import edu.immune.codebot.graph.UndirectedGraph;
import edu.immune.codebot.graph.undirected.traversal.UndirectedGraphBFS;
import edu.immune.codebot.graph.undirected.traversal.UndirectedGraphDFS;

/**
 * JUnit tests for {@link UndirectedGraphBFS} and {@link UndirectedGraphDFS}
 * 
 * @author Lalit Mehra
 *
 */
public class UGTraversalTester {
	
	private UndirectedGraph graph;
	
	@Before
	public void before() {
		this.graph = new UndirectedGraph(7);
		graph.addEdge(1, 4);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
	}
	
	@Test
	public void testDFS() {
		UndirectedGraphDFS dfs = new UndirectedGraphDFS(graph);
		dfs.traverse(1);
		System.out.println();
		System.out.println("DFS Printed");
	}
	
	@Test
	public void testBFS() {
		UndirectedGraphBFS bfs = new UndirectedGraphBFS(graph);
		bfs.traverse(1);
		System.out.println();
		System.out.println("BFS Printed");
	}

}
