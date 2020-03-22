package edu.immune.codebot.graph;

import java.util.LinkedList;

/**
 * Implementation of undirected graph. A Graph has vertices and edges that connect two vertices.<br>
 * In an undirected graph the edges do not have directions and they are treated as connections with no directions 
 *  
 * Utilizes {@link edu.immune.codebot.linkedlist.LinkedList} as the underlying storage
 * 
 * @author Lalit Mehra
 *
 */
public class UndirectedGraph {
	
	/**
	 * number of node/vertices in the graph
	 */
	private int vertices;
	
	/**
	 * stores graph vertices
	 */
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public UndirectedGraph(int vertices) {
		this.vertices = vertices;
		
		adj = new LinkedList[vertices];
		for(int index=0; index<vertices; index++) {
			adj[index] = new LinkedList<Integer>();
		}
		
	}
	
	/**
	 * Add an edge between two vertices of the graph<br>
	 * In an unordered graph the edges have no directions and hence the vertex are added as neighbours to each other with edges as connectors
	 * 
	 * @param v start vertex
	 * @param w end vertex
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
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
