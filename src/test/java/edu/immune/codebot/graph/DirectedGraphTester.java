package edu.immune.codebot.graph;

import edu.immune.codebot.graph.directed.problems.CycleDetector;
import edu.immune.codebot.graph.directed.traversal.DirectedGraphBFS;
import edu.immune.codebot.graph.directed.traversal.DirectedGraphDFS;

public class DirectedGraphTester {

	private DirectedGraph graph;

	public DirectedGraphTester() {
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

	public void isCyclic() {
		CycleDetector cd = new CycleDetector(graph);
		System.out.printf("Is Cyclic: %b", cd.detect(1));
	}
	
	public void traceDFS() {
		DirectedGraphDFS dfs = new DirectedGraphDFS(this.graph);
		dfs.traverse(1);
		System.out.println();
		System.out.println("Directed DFS Printed");
	}

	public void traceBFS() {
		DirectedGraphBFS bfs = new DirectedGraphBFS(graph);
		bfs.traverse(1);
		System.out.println();
		System.out.println("Directed BFS Printed");
	}

	public static void main(String[] args) {
		DirectedGraphTester dgt = new DirectedGraphTester();
		dgt.traceDFS();
		dgt.traceBFS();
		dgt.isCyclic();
	}

}
