package edu.lc.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.ListNode;

/**
 * #817 https://leetcode.com/problems/linked-list-components/
 * 
 * @author Lalit Mehra
 */
public class LinkedListComponents {

	static class Solution {

		public int numComponents(ListNode head, int[] G) {
			Set<Integer> set = new HashSet<Integer>();
			for (int g : G)
				set.add(g);

			int components = 0;

			while (head != null) {
				if (set.contains(head.val)) {
					components++;
					while (set.contains(head.val)) {
						head = head.next;
						if (head == null)
							break;
					}

					if (head != null)
						head = head.next;
				}

			}

			return components;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();

		cases.add(LinkedList.insert(0, 1, 2, 3));

		int[] G = { 0, 1, 3 };

		for (LinkedList ll : cases) {
			int result = obj.numComponents(ll.getHead(), G);
			System.out.print(result);
		}
	}

}
