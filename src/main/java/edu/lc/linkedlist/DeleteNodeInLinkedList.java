package edu.lc.linkedlist;

import edu.lc.linkedlist.base.ListNode;

/**
 * #237 https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * @author Lalit Mehra
 */
public class DeleteNodeInLinkedList {

	static class Solution {

		public void deleteNode(ListNode node) {
			node.val = node.next.val;
	        node.next = node.next.next;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();

		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		ListNode node2 = new ListNode(3);
		node1.next = node2;

		obj.deleteNode(node1);

	}

}
