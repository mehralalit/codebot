package edu.immune.codebot.graph.undirected.traversal;

import java.util.Iterator;

import edu.immune.codebot.graph.UndirectedGraph;

public class UndirectedGraphDFS {
	
	private UndirectedGraph graph;
	
	public UndirectedGraphDFS(UndirectedGraph graph) {
		this.graph = graph;
	}
	
	private void dfs(int vertex, boolean[] visited) {
		
		visited[vertex] = true;
		System.out.printf("%d, ", vertex);
		
		Iterator<Integer> iterator = graph.getAdj()[vertex].listIterator();
		while(iterator.hasNext()) {
			int element = iterator.next();
			if(!visited[element]) {
				dfs(element, visited);
			}
		}
		
	}
	
	public void traverse(int head) {
		
		// to mark visited edges
		boolean[] visited = new boolean[graph.getVertices()];
		
		// traverse using depth first search
		this.dfs(head, visited);
	}
	
}
