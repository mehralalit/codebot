package edu.lc.linkedlist;

import edu.lc.linkedlist.base.ListNode;

/**
 * #160 https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * @author Lalit Mehra
 */
public class IntersectionOfTwoLinkedLists {

	static class Solution {
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			if (headA == null || headB == null) {
				return null;
			}

			int lengthA = 0, lengthB = 0;

			ListNode startA = headA;
			while (startA != null) {
				startA = startA.next;
				lengthA++;
			}

			ListNode startB = headB;
			while (startB != null) {
				startB = startB.next;
				lengthB++;
			}

			startA = headA;
			startB = headB;
			if (lengthA > lengthB) {
				int diff = lengthA - lengthB;
				while(diff-->0) {
					startA = startA.next;
				}
			} else if(lengthB > lengthA) {
				int diff = lengthB - lengthA;
				while(diff-->0) {
					startB = startB.next;
				}
			}
			
			while(startA != startB) {
				startA = startA.next;
				startB = startB.next;
			}

			if(startA == startB) {
				return startA;
			} else {
				return null;
			}
		}
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		ListNode headA = new ListNode(4);
		ListNode nodeA1 = new ListNode(1);
		headA.next = nodeA1;

		ListNode headB = new ListNode(5);
		ListNode nodeB1 = new ListNode(6);
		headB.next = nodeB1;
		ListNode nodeB2 = new ListNode(1);
		nodeB1.next = nodeB2;

		ListNode nodeC1 = new ListNode(8);
		ListNode nodeC2 = new ListNode(4);
		nodeC1.next = nodeC2;
		ListNode nodeC3 = new ListNode(5);
		nodeC2.next = nodeC3;

		nodeA1.next = nodeC1;
		nodeB2.next = nodeC1;

		ListNode result = obj.getIntersectionNode(headA, headB);
		System.out.println(result.val);
	}

}
