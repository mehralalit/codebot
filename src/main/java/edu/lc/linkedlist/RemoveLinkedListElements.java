package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #203 https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * @author Lalit Mehra
 */
public class RemoveLinkedListElements {

	static class Solution {

		public ListNode removeElements(ListNode head, int val) {

			while (head != null && head.val == val)
				head = head.next;

			ListNode current = head;
			if (current != null) {
				ListNode next = current.next;
				while (next != null) {
					if (next.val == val) {
						current.next = next.next;
						next = current.next;
					} else {
						next = next.next;
						current = current.next;
					}
				}
			}

			return head;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(6));
		cases.add(LinkedList.insert(1, 6));
		cases.add(LinkedList.insert(1, 2));
		cases.add(LinkedList.insert(1, 6, 3));
		cases.add(LinkedList.insert(6, 2, 6, 4));
		cases.add(LinkedList.insert(6, 2, 3, 6, 6));

		for (LinkedList ll : cases) {
			ListNode result = obj.removeElements(ll.getHead(), 6);
			while (result != null) {
				System.out.print(result.val);
				System.out.print(" --> ");
				result = result.next;
			}

			System.out.println();
		}

	}

}
