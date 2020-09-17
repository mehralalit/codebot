package edu.lc.list;

public class AddTwoNumbers {

	static class ListNode {

		int val;
		ListNode next;

		public ListNode(int i) {
			val = i;
		}
	}

	static class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int sum = 0;
	        int cf = 0;
	        ListNode result = new ListNode(0);
	        ListNode current = result;
	        while(l1!=null || l2!=null) {
	            int x = (l1!=null)?l1.val:0;
	            int y = (l2!=null)?l2.val:0;
	            sum = (x + y + cf);
	            cf = sum/10;
	            current.next = new ListNode(sum%10);
	            current = current.next;
	            l1 = l1.next;
	            l2 = l2.next;
	        }
	        if (cf > 0) {
	        current.next = new ListNode(cf);
	    }
	        
	        result = result.next;
	        return result;
	    }
	}

	public static void main(String[] args) {
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		l11.next = l12;
		ListNode l13 = new ListNode(3);
		l12.next = l13;
		
		ListNode l21 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		l21.next = l22;
		ListNode l23 = new ListNode(4);
		l22.next = l23;
		
		Solution obj = new Solution();
		ListNode result = obj.addTwoNumbers(l11, l21);
		
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
	}

}