package edu.immune.codebot.graph.directed;

import java.util.LinkedList;

public class DirectedGraph {
	
	private int vertices;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public DirectedGraph(int vertices) {
		this.vertices = vertices;
		
		adj = new LinkedList[vertices];
		for(int index=0; index<vertices; index++) {
			adj[index] = new LinkedList<Integer>();
		}
		
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public int getVertices() {
		return vertices;
	}

	public LinkedList<Integer>[] getAdj() {
		return adj;
	}
}
