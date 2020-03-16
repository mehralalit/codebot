package edu.immune.codebot.graph.directed.problems;

import edu.immune.codebot.graph.DirectedGraph;

public class CycleDetector {

	private DirectedGraph graph;

	public CycleDetector(DirectedGraph graph) {
		this.graph = graph;
	}

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

	public boolean detect(int vertex) {

		boolean[] visited = new boolean[graph.getVertices()];
		boolean[] rec = new boolean[graph.getVertices()];

		return detectCycle(vertex, visited, rec);
	}

}
