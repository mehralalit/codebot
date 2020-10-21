package edu.lc.linkedlist.base;

/**
 * @author Lalit Mehra
 *
 */
public class DoublyChildLinkedList {
	
	private Node head;
	private Node tail;
	
	private void insert(int val, int pos) {
		if(head == null) {
			head = new Node(val, pos);
			tail = head;
		} else {
			Node node = new Node(val, pos);
			tail.next = node;
			node.prev = tail;
			tail = tail.next;
		}
	}
	
	public Node getHead() {
		return head;
	}
	
	private DoublyChildLinkedList insertNode(int... values) {
		int pos = 0;
		for(int val: values) {
			insert(val, ++pos);
		}
		
		return this;
	}
	
	public static DoublyChildLinkedList insert(int...values) {
		return new DoublyChildLinkedList().insertNode(values);
	}

}
