package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #328 https://leetcode.com/problems/odd-even-linked-list/
 * 
 * @author Lalit Mehra
 */
public class OddEvenLinkedList {

	static class Solution {

		public ListNode oddEvenList(ListNode head) {

			if (head == null)
				return null;

			if (head.next == null)
				return head;

			ListNode odd = head;
			ListNode even = head.next;

			ListNode odd_curr = odd;
			ListNode even_curr = even;

			// odd list contains nodes to the next of even nodes
			// even list contains nodes to the next of odd nodes
			while (odd_curr.next != null && even_curr.next != null) {
				odd_curr.next = even_curr.next;
				odd_curr = odd_curr.next;
				even_curr.next = odd_curr.next;
				even_curr = even_curr.next;
			}

			odd_curr.next = even;

			return head;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(1, 2, 3));
		cases.add(LinkedList.insert(1, 2, 3, 4));
		cases.add(LinkedList.insert(1, 2, 3, 4, 5));

		for (LinkedList ll : cases) {
			ListNode result = obj.oddEvenList(ll.getHead());
			while (result != null) {
				System.out.print(result.val);
				System.out.print(" --> ");
				result = result.next;
			}

			System.out.println();
		}

	}

}
