package edu.lc.linkedlist.base;

public class Node {

	public int val;
	public int pos;
	public Node prev;
    public Node next;
    public Node child;

	public Node() {}

	public Node(int val) {
		this.val = val;
	}
	
	public Node(int val, int pos) {
		this.val = val;
		this.pos = pos;
	}

	public Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}

}
