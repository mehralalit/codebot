package edu.lc.linkedlist.base;

public class ListNode {

	public int val;
	public int pos;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, int pos) {
		this.val = val;
		this.pos = pos;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return String.format("[val: %d, pos: %d]", val, pos);
	}

}
