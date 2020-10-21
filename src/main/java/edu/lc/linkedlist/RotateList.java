package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #61 https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author Lalit Mehra
 */
public class RotateList {

	static class Solution {
		public ListNode rotateRight(ListNode head, int k) {

			if (head == null || head.next == null)
				return head;

			ListNode currrent = head;
			int count = 0;
			while (currrent != null) {
				count += 1;
				currrent = currrent.next;
			}

			if (k % count == 0)
				return head;

			ListNode pivot = head;
			ListNode last = head;

			for (int i = 0; i < k % count; i++) {
				last = last.next;
			}

			while (last.next != null) {
				last = last.next;
				pivot = pivot.next;
			}

			last.next = head;
			head = pivot.next;
			pivot.next = null;
			return head;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

//		cases.add(LinkedList.insert(1));
//		cases.add(LinkedList.insert(1, 2, 3, 4, 5));
		cases.add(LinkedList.insert(0, 1, 2));

		for (LinkedList ll : cases) {
			ListNode result = obj.rotateRight(ll.getHead(), 4);
			while (result != null) {
				System.out.print(result.val);
				System.out.print(" --> ");
				result = result.next;
			}

			System.out.println();
		}

	}

}
