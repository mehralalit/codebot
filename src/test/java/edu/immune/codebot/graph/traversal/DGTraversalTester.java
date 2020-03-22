package edu.immune.codebot.graph.traversal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.immune.codebot.graph.DirectedGraph;
import edu.immune.codebot.graph.directed.traversal.DirectedGraphBFS;
import edu.immune.codebot.graph.directed.traversal.DirectedGraphDFS;

/**
 * JUnit tests for {@link DirectedGraphBFS} and {@link DirectedGraphDFS}
 * 
 * @author Lalit Mehra
 *
 */
public class DGTraversalTester {

	private DirectedGraph graph;

	@Before
	public void before() {
		graph = new DirectedGraph(7);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(1, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
	}

	@After
	public void after() {
		graph = null;
	}

	@Test
	public void testDFS() {
		DirectedGraphDFS dfs = new DirectedGraphDFS(this.graph);
		dfs.traverse(1);
		System.out.println();
		System.out.println("Directed DFS Printed");
	}

	@Test
	public void testBFS() {
		DirectedGraphBFS bfs = new DirectedGraphBFS(graph);
		bfs.traverse(1);
		System.out.println();
		System.out.println("Directed BFS Printed");
	}

}
