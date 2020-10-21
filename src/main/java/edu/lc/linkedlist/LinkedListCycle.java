package edu.lc.linkedlist;

import edu.lc.linkedlist.base.ListNode;

/**
 * #141 https://leetcode.com/problems/linked-list-cycle/
 * 
 * @author Lalit Mehra
 *
 */
public class LinkedListCycle {

	static class Solution {

		public boolean hasCycle(ListNode head) {
			if (head == null)
				return false;

			ListNode first = head;
			ListNode second = head;
			boolean flag = false;

			while (first != null && second != null && second.next != null) {
				first = first.next;
				second = second.next.next;

				if (first == second) {
					flag = true;
					break;
				}
			}

			return flag;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();

		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		node1.next = head;

		boolean result = obj.hasCycle(head);
		System.out.println(result);

	}

}
