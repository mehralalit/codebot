package edu.lc.linkedlist.todo;

import java.util.HashMap;
import java.util.Map;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #445 https://leetcode.com/problems/add-two-numbers-ii/
 * 
 * @author Lalit Mehra
 */
public class AddTwoNumbersII {

	static class Solution {

		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

			if (l1 == null && l2 == null)
				return null;
			else if (l1 == null)
				return l2;
			else if (l2 == null)
				return l1;

			ListNode l1_head = l1;
			ListNode l2_head = l2;

			int l1_size = 0;
			int l2_size = 0;

			while (l1_head != null) {
				l1_size++;
				l1_head = l1_head.next;
			}

			while (l2_head != null) {
				l2_size++;
				l2_head = l2_head.next;
			}

			l1_head = l1;
			l2_head = l2;

			ListNode result = null;
			if (l1_size > l2_size) {
				result = copy(l1_head);
				return add(result, l2, l1_size - l2_size);
			} else {
				result = copy(l2_head);
				return add(result, l1, l2_size - l1_size);
			}

		}

		// skip the nodes of the resultant list by the difference of number of elements
		// of both the list
		private ListNode add(ListNode result, ListNode ll, int skip) {
			ListNode current = result;

			int index = 0;

			while (index < skip - 1) {
				current = current.next;
				index++;
			}

			ListNode head = null;

			if (skip == 0) {
				head = new ListNode(0);
				head.next = current;
				current = head;
			}

			current.val += add(current.next, ll);
			
			if(current.val > 9) {
				int carry = current.val/10;
				current.val = current.val%10;
				head = new ListNode(carry);
				head.next = current;
				current = head;
			}

			if (current == head && current.val > 0)
				return current;
			else
				return result;
		}

		// recursively process sum
		private int add(ListNode current, ListNode ll) {
			if (current.next != null)
				current.val += add(current.next, ll.next);

			current.val += ll.val;
			int carry = current.val / 10;

			if (carry != 0)
				current.val -= 10;

			return carry;
		}

		// copy the larger list to the resultant list
		private ListNode copy(ListNode ll) {
			ListNode result = null;
			ListNode current = null;
			while (ll != null) {
				if (result == null) {
					result = new ListNode(ll.val);
					current = result;
				} else {
					current.next = new ListNode(ll.val);
					current = current.next;
				}
				ll = ll.next;
			}

			return result;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		Map<LinkedList, LinkedList> cases = new HashMap<>();

//		cases.put(LinkedList.insert(7,4,3), LinkedList.insert(5,6,4));
		cases.put(LinkedList.insert(8,9,9), LinkedList.insert(2));

		for (Map.Entry<LinkedList, LinkedList> ll : cases.entrySet()) {
			ListNode result = obj.addTwoNumbers(ll.getKey().getHead(), ll.getValue().getHead());
			while (result != null) {
				System.out.print("[" + result.val + "]");
				result = result.next;
			}
			System.out.println();
		}
	}

}
