package edu.immune.codebot.graph.directed.problems;

import edu.immune.codebot.graph.DirectedGraph;

/**
 * Takes a {@link DirectedGraph} as input and checks if it contains a cycle
 * 
 * @author Lalit Mehra
 *
 */
public class CycleDetector {

	private DirectedGraph graph;

	public CycleDetector(DirectedGraph graph) {
		this.graph = graph;
	}

	/**
	 * Detects if the graph contains a cycle
	 * 
	 * @param vertex starting vertex for the cycle test
	 * @param visited a boolean[] that stores true/false based on visits made to a vertex 
	 * @param rec a boolean[] that helps with cycle deduction
	 * @return
	 * 	true if the graph has a cycle<br>
	 * 	false otherwise 
	 */
	private boolean detectCycle(int vertex, boolean[] visited, boolean[] rec) {

		if (rec[vertex])
			return true;

		if (visited[vertex])
			return false;

		visited[vertex] = true;
		rec[vertex] = true;

		for (int vtx : graph.getAdj()[vertex]) {
			if (detectCycle(vtx, visited, rec))
				return true;
		}

		rec[vertex] = false;

		return false;

	}

	/**
	 * Detects if the graph contains a cycle
	 * 
	 * @param vertex starting vertex for the cycle test
	 * @return
	 */
	public boolean detect(int vertex) {

		boolean[] visited = new boolean[graph.getVertices()];
		boolean[] rec = new boolean[graph.getVertices()];

		return detectCycle(vertex, visited, rec);
	}

}
