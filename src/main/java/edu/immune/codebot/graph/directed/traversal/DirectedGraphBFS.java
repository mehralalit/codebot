package edu.immune.codebot.graph.directed.traversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import edu.immune.codebot.graph.DirectedGraph;

public class DirectedGraphBFS {
	
	private DirectedGraph graph;
	
	public DirectedGraphBFS(DirectedGraph graph) {
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
