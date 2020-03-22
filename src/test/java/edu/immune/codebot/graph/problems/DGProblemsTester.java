package edu.immune.codebot.graph.problems;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.immune.codebot.graph.DirectedGraph;
import edu.immune.codebot.graph.directed.problems.CycleDetector;

public class DGProblemsTester {

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
	public void isCyclic() {
		CycleDetector cd = new CycleDetector(this.graph);
		assertFalse(cd.detect(1));
	}

}
