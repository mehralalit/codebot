package edu.immune.codebot.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test cases for {@link UndirectedGraph}
 * 
 * @author Lalit Mehra
 *
 */
public class UndirectedGraphTester {

	private DirectedGraph graph;

	@Before
	public void before() {
		graph = new DirectedGraph(2);
	}

	@After
	public void after() {
		graph = null;
	}

	@Test
	public void testAddEdge() {
		graph.addEdge(1, 2);
	}

	@Test
	public void testGetVertices() {
		assertEquals(2, graph.getVertices());
	}

}
