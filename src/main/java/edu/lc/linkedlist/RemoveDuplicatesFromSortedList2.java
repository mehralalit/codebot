package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #82 https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Can be Improved
 * 
 * @author Lalit Mehra
 *
 */
public class RemoveDuplicatesFromSortedList2 {

	static class Solution {

		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return null;

			Map<Integer, Integer> unique = new HashMap<>();

			ListNode next = head;
			while (next != null) {
				unique.put(next.val, unique.getOrDefault(next.val, 0) + 1);
				next = next.next;
			}

			// first element is previous
			ListNode previous = head;

			// second element is next
			next = head.next;

			// traverse till the end
			while (next != null) {
				/*
				 * 1. if both the previous and next element have only one occurrence, move both
				 * one step forward; 2. if only next element has multiple occurrence, remove
				 * that element by moving next one step forward and pointing previous to the new
				 * next; 3. if the previous element has multiple occurrence move both elements
				 * one step further and point head to its next
				 */
				if (unique.get(previous.val) == 1 && unique.get(next.val) == 1) {
					next = next.next;
					previous = previous.next;
				} else if (unique.get(next.val) > 1) {
					previous.next = next.next;
					next = previous.next;
				} else if (unique.get(previous.val) > 1) {
					next = next.next;
					previous = previous.next;
					head = head.next;
				}
			}

			// check if the formed list has only one element and if it is a duplicate
			if (head.next == null) {
				if (unique.get(head.val) > 1) {
					head = head.next;
				}
			}

			return head;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(1, 1));
		cases.add(LinkedList.insert(1, 1, 2));
		cases.add(LinkedList.insert(1, 1, 2, 3, 3));
		cases.add(LinkedList.insert(1, 1, 2, 2, 3, 3)); 
		cases.add(LinkedList.insert(1, 2, 3, 3, 4, 4, 5));
		cases.add(LinkedList.insert(1, 2, 3, 3, 4));
		cases.add(LinkedList.insert(1, 1, 2, 3, 4));
		cases.add(LinkedList.insert(1, 2, 3, 3));
		cases.add(LinkedList.insert(1, 2, 3, 4));

		for (LinkedList ll : cases) {
			ListNode result = obj.deleteDuplicates(ll.getHead());
			while (result != null) {
				System.out.print(result.val);
				System.out.print(" --> ");
				result = result.next;
			}

			System.out.println();
		}

	}

}
