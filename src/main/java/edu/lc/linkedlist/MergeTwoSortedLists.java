package edu.lc.linkedlist;

import edu.lc.linkedlist.base.ListNode;

/**
 * #21 https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author Lalit Mehra
 */
public class MergeTwoSortedLists {

	static class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if(l1 == null && l2 == null)
				return null;
			
			if(l1 == null)
				return l2;
			
			if(l2 == null)
				return l1;
			
			ListNode start1 = l1;
			ListNode start2 = l2;
			ListNode merged = null;
			ListNode current = null;
			
			if(start1.val<start2.val) {
				merged = start1;
				start1 = start1.next;
			} else {
				merged = start2;
				start2 = start2.next;
			}
			current = merged;
			current.next = null;
			
			while(start1!=null && start2!=null) {
				if(start1.val < start2.val) {
					current.next = start1;
					current = current.next;
					start1 = start1.next;
					current.next = null;
				} else {
					current.next = start2;
					current = current.next;
					start2 = start2.next;
					current.next = null;
				}
			}
			
			if(start1 == null)
				current.next = start2;
			
			if(start2 == null)
				current.next = start1;
			
			return merged;
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		ListNode headA = new ListNode(1);
		ListNode nodeA1 = new ListNode(2);
		headA.next = nodeA1;
		ListNode nodeA2 = new ListNode(4);
		nodeA1.next = nodeA2;

		ListNode headB = new ListNode(1);
		ListNode nodeB1 = new ListNode(3);
		headB.next = nodeB1;
		ListNode nodeB2 = new ListNode(4);
		nodeB1.next = nodeB2;

		ListNode result = obj.mergeTwoLists(headA, headB);
		
		while(result!=null) {
			System.out.print(result.val);
			System.out.print(" --> ");
			result = result.next;
		}
	}

}
