package edu.lc.linkedlist;

import edu.lc.linkedlist.base.ListNode;

/**
 * #1290
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * @author Lalit Mehra
 * 
 */
public class ConvertBinaryNumberInALinkedListToInteger {

	static class Solution {
		public int getDecimalValue(ListNode head) {
			int size = 0;
			ListNode start = head;
			while (start != null) {
				size += 1;
				start = start.next;
			}

			start = head;
			int result = 0;

			while (start != null) {
				if (start.val == 1) {
					result += Math.pow(2, size - 1);
				}
				size = size - 1;
				start = start.next;
			}

			return result;

		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(0);
		head.next = node1;
		ListNode node2 = new ListNode(1);
		node1.next = node2;

		int result = obj.getDecimalValue(head);
		System.out.println(result);
	}

}
