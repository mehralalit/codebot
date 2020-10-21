package edu.lc.linkedlist.todo;

import java.util.ArrayList;
import java.util.List;

import edu.lc.linkedlist.base.LinkedList;
import edu.lc.linkedlist.base.Node;

/**
 * #430 https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * 
 * @author Lalit Mehra
 * 
 */
public class FlattenAMultilevelDoublyLinkedList {

	static class Solution {

		public Node flatten(Node head) {
			Node current = head;
			head = flattenList(current)[0];
			return head;
		}

		private Node[] flattenList(Node current) {
			Node head = current;
			while (current.next != null) {
				if (current.child != null) {
					Node[] res = flattenList(current.child);
					current.next = res[0];
					current = res[1];
				} else {
					current = current.next;
				}
			}
			Node[] res = new Node[2];
			res[0] = head;
			res[1] = current;
			return res;
		}

	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		List<LinkedList> cases = new ArrayList<>();
	}

}
