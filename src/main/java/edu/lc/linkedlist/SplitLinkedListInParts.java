package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #725 https://leetcode.com/problems/split-linked-list-in-parts/
 * 
 * @author Lalit Mehra
 */
public class SplitLinkedListInParts {

	static class Solution {

		public ListNode[] splitListToParts(ListNode root, int k) {

			// size of the actual linked list
			int size = 0;
			ListNode current = root;
			while (current != null) {
				size++;
				current = current.next;
			}

			// average length per split
			int length = size / k;

			// extra nodes in splits
			int ext = size % k;

			// compute length of each split
			int[] lengths = new int[k];
			for (int index = 0; index < k; index++) {
				if (ext <= 0)
					lengths[index] = length;
				else {
					lengths[index] = length + 1;
					ext--;
				}
			}

			ListNode[] lists = new ListNode[k];
			current = root;
			int whichSplit = 0;
			int count = 0;

			// traverse holds the first node for each split
			ListNode traverse = null;
			while (current != null) {
				// count stores the filled number of elements in the current split
				// if that number is reached move to the next split
				if (count == lengths[whichSplit]) {
					count = 0;
					lists[whichSplit].next = null;

					// reset the starting position
					lists[whichSplit] = traverse;
					whichSplit++;
				}

				if (lists[whichSplit] == null) {
					traverse = current;
					lists[whichSplit] = current;
				} else {
					lists[whichSplit] = lists[whichSplit].next;
				}

				current = current.next;
				count++;
			}

			// resetting the starting position for the last split
			lists[whichSplit] = traverse;

			return lists;

		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert());
		cases.add(LinkedList.insert(1));
		cases.add(LinkedList.insert(1, 2));
		cases.add(LinkedList.insert(1, 2, 3));
		cases.add(LinkedList.insert(1, 2, 3, 4));
		cases.add(LinkedList.insert(1, 2, 3, 4, 5));

		int count = 1;
		for (LinkedList ll : cases) {
			ListNode[] result = obj.splitListToParts(ll.getHead(), 2);
			System.out.println("case " + count++);
			for (int index = 0; index < result.length; index++) {
				ListNode node = result[index];
				while (node != null) {
					System.out.print("[" + node.val + "]");
					node = node.next;
				}
				System.out.println();
			}
		}

	}

}
