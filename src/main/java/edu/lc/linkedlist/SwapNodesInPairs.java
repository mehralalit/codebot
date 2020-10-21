package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #24 https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author Lalit Mehra
 */
public class SwapNodesInPairs {

	static class Solution {
		public ListNode swapPairs(ListNode head) {

			if (head == null || head.next == null)
				return head;

			ListNode first = head;
			ListNode second = head.next;
			ListNode prev = null;
			ListNode result = second;

			while (first != null && second != null) {
				// swap the pointers
				first.next = second.next;
				second.next = first;
				
				// prev used to link to the previously swapped nodes
				prev = first;
				
				// move first forward
				first = first.next;

				// if there is at least one more node
				if (first != null) {
					second = first.next;
					// if there are even number of nodes
					if (second != null)
						prev.next = second;
				} 
			}

			return result;

		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(1, 2));
		cases.add(LinkedList.insert(1, 2, 3));
		cases.add(LinkedList.insert(1, 2, 3, 4));
		cases.add(LinkedList.insert(1, 2, 3, 4, 5));
		cases.add(LinkedList.insert(1, 2, 3, 4, 5, 6));
		cases.add(LinkedList.insert(1, 2, 3, 4, 5, 6, 7));
		cases.add(LinkedList.insert(1, 2, 3, 4, 5, 6, 7, 8));

		for (LinkedList ll : cases) {
			ListNode result = obj.swapPairs(ll.getHead());
			while (result != null) {
				System.out.print(result.val);
				System.out.print(" --> ");
				result = result.next;
			}

			System.out.println();
		}

	}

}
