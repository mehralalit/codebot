/**
 * 
 */
package edu.immune.codebot.tree;

import java.io.Serializable;

/**
 * Node is the basic building block for a Tree data structure<br>
 * <br>
 * Implementation accepts only those classes that are of type {@link Comparable}
 * 
 * @author Lalit Mehra
 *
 */
public class Node<T extends Comparable<T>> implements Serializable, Comparable<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6638784445921925053L;

	private T data;
	private Node<T> left;
	private Node<T> right;

	public Node(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public int compareTo(T o) {
		return this.data.compareTo(o);
	}

}
