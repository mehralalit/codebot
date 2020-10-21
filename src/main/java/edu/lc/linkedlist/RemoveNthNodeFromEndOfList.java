package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #19 https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author Lalit Mehra
 */
public class RemoveNthNodeFromEndOfList {

	static class Solution {

		public ListNode removeNthFromEnd(ListNode head, int n) {

			if (head == null)
				return null;

			if (head.next == null && n == 1)
				return null;

			ListNode skip = head;
			ListNode current = head;

			// move skip node to the node position which is to be removed
			for (int index = 0; index < n; index++) {
				skip = skip.next;
			}

			// if skip node has reached past the last node
			// the node which should be deleted must be the first node
			if(skip == null) {
				head = head.next;
				return head;
			}

			// otherwise move both the nodes until skip reaches the last node
			while (skip.next != null) {
				skip = skip.next;
				current = current.next;
			}

			// now current points to the node previous to the one which should be removed
			current.next = current.next.next;

			return head;

		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(1, 2));
		cases.add(LinkedList.insert(1, 2));
		cases.add(LinkedList.insert(1, 2, 3, 4, 5));

		List<Integer> vars = new ArrayList<>();
		vars.add(1);
		vars.add(2);
		vars.add(1);
		vars.add(5);

		int count = 0;
		for (LinkedList ll : cases) {
			ListNode result = obj.removeNthFromEnd(ll.getHead(), vars.get(count++));
			while (result != null) {
				System.out.print("[" + result.val + "]");
				result = result.next;
			}
			System.out.println();
		}
	}

}
