package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #234 https://leetcode.com/problems/palindrome-linked-list/
 * 
 * @author Lalit Mehra
 */
public class PalindromeLinkedList {

	static class Solution {
		private ListNode reverseList(ListNode head, int skip) {

			for (int index = 0; index < skip; index++)
				head = head.next;

			ListNode previous = head;
			ListNode current = head.next;
			ListNode next = null;

			while (current != null) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			return previous;
		}

		private int size(ListNode head) {
			int count = 0;
			ListNode current = head;

			while (current != null) {
				count++;
				current = current.next;
			}

			return count;
		}

		private boolean isPalindrome(ListNode head, ListNode tail, int steps) {

			boolean result = true;

			for (int index = 0; index < steps; index++) {
				if (head.val != tail.val) {
					result = false;
					break;
				}

				head = head.next;
				tail = tail.next;
			}

			return result;
		}

		public boolean isPalindrome(ListNode head) {
			if (head == null)
				return true;

			int size = size(head);

			if (size == 1)
				return true;

			ListNode tail = reverseList(head, size / 2);

			return isPalindrome(head, tail, size / 2);
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(1, 1));
		cases.add(LinkedList.insert(1, 2));
		cases.add(LinkedList.insert(1, 2, 1));
		cases.add(LinkedList.insert(1, 2, 3));
		cases.add(LinkedList.insert(1, 2, 2, 1));
		cases.add(LinkedList.insert(1, 1, 2, 2));

		for (LinkedList ll : cases) {
			boolean result = obj.isPalindrome(ll.getHead());
			System.out.println(result);
		}

	}

}
