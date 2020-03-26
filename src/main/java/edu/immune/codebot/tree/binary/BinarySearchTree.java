package edu.immune.codebot.tree.binary;

import edu.immune.codebot.tree.Node;

/**
 * Binary Search Tree are data structures that store elements in memory and
 * follow the principle of binary search<br>
 * When the elements are added to the tree they are inserted at a particular
 * location based on the value of the element<br>
 * When an element is removed from the tree the tree is restructured following
 * the same binary principle<br>
 * <br>
 * Implementation accepts only those classes that are of type {@link Comparable}
 * 
 * @author Lalit Mehra
 *
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private Node<T> head;
	private int size;

	public BinarySearchTree() {
		this.size = 0;
	}

	/**
	 * Support method to add an element to the tree using the binary search approach. It compares the
	 * data part of the element with the existing nodes to decide that place for the
	 * new node in the tree<br>
	 * 
	 * @param element new element that should be added to the tree
	 * @param parent possible parent element to the new element. First parent is the head node.
	 */
	private void add(T element, Node<T> parent) {
		if (element.compareTo(parent.getData()) <= 0) {
			if (null == parent.getLeft()) {
				Node<T> newnode = new Node<>(element);
				parent.setLeft(newnode);
				return;
			} else {
				add(element, parent.getLeft());
			}
		} else {
			if (null == parent.getRight()) {
				Node<T> newnode = new Node<>(element);
				parent.setRight(newnode);
				return;
			} else {
				add(element, parent.getRight());
			}

		}
	}
	
	/**
	 * Helper method to support the in-order traversal
	 *  
	 * @param current current node in the sequence, first node is the head node
	 * @param builder stores data of all nodes reached during traversal
	 */
	private void inorder(Node<T> current, StringBuilder builder) {
		if(null != current) {
			inorder(current.getLeft(), builder);
			builder.append(current.getData()).append(" ");
			inorder(current.getRight(), builder);
		}
	}
	
	/**
	 * Helper method to support the pre-order traversal
	 *  
	 * @param current current node in the sequence, first node is the head node
	 * @param builder stores data of all nodes reached during traversal
	 */
	private void preorder(Node<T> current, StringBuilder builder) {
		if(null != current) {
			builder.append(current.getData()).append(" ");
			preorder(current.getLeft(), builder);
			preorder(current.getRight(), builder);
		}
	}
	
	/**
	 * Helper method to support the post-order traversal
	 *  
	 * @param current current node in the sequence, first node is the head node
	 * @param builder stores data of all nodes reached during traversal
	 */
	private void postorder(Node<T> current, StringBuilder builder) {
		if(null != current) {
			postorder(current.getLeft(), builder);
			postorder(current.getRight(), builder);
			builder.append(current.getData()).append(" ");
		}
	}

	/**
	 * Add an element to the Binary Search Tree
	 * 
	 * @param element new element that should be added to the tree
	 */
	public void add(T element) {
		if (head == null) {
			head = new Node<>(element);
		} else {
			add(element, head);
		}

		// increment size of the tree
		size++;
	}
	
	/**
	 * Remove an element from the Binary Search Tree<br>
	 * Removes the first instance of the element if multiple such instances are present in the tree
	 * 
	 * @param element
	 */
	public void remove(T element) {
		// TODO
	}
	
	/**
	 * Produces in-order traversal of the tree 
	 * @return
	 */
	public String inorder() {
		StringBuilder content = new StringBuilder();
		inorder(head, content);
		
		return content.toString();
	}

	/**
	 * Produces pre-order traversal of the tree
	 * @return
	 */
	public String preorder() {
		StringBuilder content = new StringBuilder();
		preorder(head, content);
		
		return content.toString();
	}
	
	/**
	 * Produces post-order traversal of the tree
	 * @return
	 */
	public String postorder() {
		StringBuilder content = new StringBuilder();
		postorder(head, content);
		
		return content.toString();
	}
}
