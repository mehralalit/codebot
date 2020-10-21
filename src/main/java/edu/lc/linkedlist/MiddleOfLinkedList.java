package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #876 https://leetcode.com/problems/middle-of-the-linked-list/
 * 
 * @author Lalit Mehra
 */
public class MiddleOfLinkedList {

	static class Solution {

		public ListNode middleNode(ListNode head) {

			if (head == null)
				return null;

			if (head.next == null)
				return head;

			ListNode slow = head;
			ListNode fast = head;

			while (slow != null && fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}

			return slow;

		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(1, 1));
		cases.add(LinkedList.insert(1, 2));
		cases.add(LinkedList.insert(1, 2, 3));
		cases.add(LinkedList.insert(1, 2, 3, 4));
		cases.add(LinkedList.insert(1, 2, 3, 4, 5));

		for (LinkedList ll : cases) {
			ListNode result = obj.middleNode(ll.getHead());
			System.out.println(result.val);
		}

	}

}
