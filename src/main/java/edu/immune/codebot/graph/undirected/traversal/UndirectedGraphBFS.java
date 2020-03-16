package edu.immune.codebot.graph.undirected.traversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import edu.immune.codebot.graph.UndirectedGraph;

public class UndirectedGraphBFS {
	
	private UndirectedGraph graph;
	
	public UndirectedGraphBFS(UndirectedGraph graph) {
		this.graph = graph;
	}
	
	public void traverse(int vertex) {
		
		boolean[] visited = new boolean[graph.getVertices()];
		visited[vertex] = true;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(vertex);
		
		while(queue.size() != 0) {
			
			vertex = queue.poll();
			System.out.printf("%d, ", vertex);
			
			Iterator<Integer> iterator = graph.getAdj()[vertex].listIterator();
			while(iterator.hasNext()) {
				
				int v = iterator.next();
				
				if(!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
			
		}
	}

}
