package edu.immune.codebot.graph;

import java.util.LinkedList;

/**
 * Implementation of directed graph. A Graph has vertices and edges that connect two vertices.
 * In a directed graph the edges have directions and they only point from the start vertex to the end vertex 
 *  
 * Utilizes {@link edu.immune.codebot.linkedlist.LinkedList} as the underlying storage
 * 
 * @author Lalit Mehra
 *
 */
public class DirectedGraph {
	
	/**
	 * number of node/vertices in the graph
	 */
	private int vertices;
	
	/**
	 * stores graph vertices
	 */
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public DirectedGraph(int vertices) {
		this.vertices = vertices;
		
		adj = new LinkedList[this.vertices];
		for(int index=0; index<vertices; index++) {
			adj[index] = new LinkedList<Integer>();
		}
		
	}
	
	/**
	 * Add an edge between two vertices of the graph. <br>
	 * In a directed graph the edge has direction hence it is only added adjacent to the start index
	 * 
	 * @param v start vertex
	 * @param w end vertex
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	/**
	 * @return no of vertices in the graph
	 */
	public int getVertices() {
		return vertices;
	}

	/**
	 * An adjacency list contains connections between two vertex in the form of edges 
	 * @return adjacency list of the whole graph 
	 */
	public LinkedList<Integer>[] getAdj() {
		return adj;
	}
}
