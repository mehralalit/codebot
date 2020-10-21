package edu.lc.linkedlist;

import edu.lc.linkedlist.base.ListNode;

/**
 * #83 https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * @author Lalit Mehra
 *
 */
public class RemoveDuplicatesFromSortedList {

	static class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return null;

			// first element is previous
			ListNode previous = head;

			// second element is start
			ListNode next = head.next;

			// traverse till the end
			while (next != null) {
				/*
				 * if previous element matches the next element move the next element one step
				 * further and point the previous element to that element
				 */
				if (next.val == previous.val) {
					next = next.next;
					previous.next = next;
				} else {
					/*
					 * when the both values do not match point the previous element to next element
					 * and move both one step further
					 */
					previous.next = next;
					previous = previous.next;

					if (next != null)
						next = next.next;
				}
			}

			return head;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(1);
		head.next = node1;
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(3);
		node3.next = node4;

		ListNode result = obj.deleteDuplicates(head);

		while (result != null) {
			System.out.print(result.val);
			System.out.print(" --> ");
			result = result.next;
		}
	}

}
