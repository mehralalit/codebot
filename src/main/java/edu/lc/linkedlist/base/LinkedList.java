package edu.lc.linkedlist.base;

public class LinkedList {
	
	private ListNode head;
	private ListNode tail;
	
	private void insert(int val, int pos) {
		if(head == null) {
			head = new ListNode(val, pos);
			tail = head;
		} else {
			tail.next = new ListNode(val, pos);
			tail = tail.next;
		}
	}
	
	public ListNode getHead() {
		return head;
	}
	
	private LinkedList insertNode(int... values) {
		int pos = 0;
		for(int val: values) {
			insert(val, ++pos);
		}
		
		return this;
	}
	
	public static LinkedList insert(int...values) {
		return new LinkedList().insertNode(values);
	}

}
