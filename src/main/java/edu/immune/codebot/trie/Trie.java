package edu.immune.codebot.trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Trie is an ordered search tree which uses an associated list/array to support
 * ordering and management
 * 
 * @author Lalit Mehra
 *
 */
public class Trie<T extends Comparable<T>> {

	/**
	 * Basic building block for Trie data structure<br>
	 * It includes the data and and associated list that chains that node to all the
	 * other nodes in the path
	 * 
	 * @author Lalit Mehra
	 *
	 * @param <T>
	 */
	static class Node<T extends Comparable<T>> {
		private int occurrences;
		private T element;
		private List<Node<T>> connections;
		private boolean lastNode;

		public Node(T element) {
			this.element = element;
			this.occurrences = 1;
			this.connections = new ArrayList<>();
			this.lastNode = false;
		}

		/**
		 * Increments the number of occurrences for the same element by 1
		 */
		private void incrementOccurrence() {
			this.occurrences += 1;
		}

		public int getOccurences() {
			return this.occurrences;
		}

		/**
		 * Add a new element to the structure if does not already exist otherwise return
		 * the existing element
		 * 
		 * @param element
		 * @return the new node
		 */
		public Node<T> checkIfNotExistAdd(T element) {
			Node<T> existing = nextNodeInPath(element);
			if (null == existing) {
				Node<T> connection = new Node<>(element);
				this.connections.add(connection);
				return connection;
			} else {
				existing.incrementOccurrence();
				return existing;
			}

		}

		private Node<T> nextNodeInPath(T element) {
			return this.connections.stream().filter(connection -> element.equals(connection.element)).findFirst()
					.orElse(null);
		}

	}

	private Node<T> head;

	public Trie() {
		this.head = new Node<T>(null);
	}

	/**
	 * Add a group of related and ordered elements to the structure
	 * 
	 * @param elements
	 */
	public void add(Collection<T> elements) {
		Node<T> current = this.head;
		for (T element : elements) {
			current = current.checkIfNotExistAdd(element);
		}
		current.lastNode = true;
	}

}