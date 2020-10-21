package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #206 https://leetcode.com/problems/reverse-linked-list/
 * 
 * @author Lalit Mehra
 */
public class ReverseLinkedList {

	static class Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null)
				return null;

			ListNode previous = null;
			ListNode current = head;
			ListNode next = null;

			while (current != null) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			return previous;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(1, 2));
		cases.add(LinkedList.insert(1, 2, 3));

		for (LinkedList ll : cases) {
			ListNode result = obj.reverseList(ll.getHead());
			while (result != null) {
				System.out.print(result.val);
				System.out.print(" --> ");
				result = result.next;
			}

			System.out.println();
		}

	}

}
