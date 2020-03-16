package edu.immune.codebot.linkedlist;

import edu.immune.codebot.linkedlist.util.LinkedListUtil;

public class LinkedListTester {
	
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.print();
		
		linkedList.addToHead(2);
		linkedList.addToHead(1);
		linkedList.addToTail(4);
		linkedList.add(3, 10);
		linkedList.addToHead(0);
		linkedList.addToTail(5);
		linkedList.add(7, 5);
		linkedList.print();
		
		linkedList.removeFromHead();
		linkedList.print();
		linkedList.addToHead(0);
		linkedList.print();
		
		linkedList.deleteFromTail();
		linkedList.print();
		linkedList.addToTail(5);
		linkedList.addToTail(8); 
		linkedList.print();
		
		linkedList.remove(7);
		linkedList.print();
		
		linkedList.addToTail(9);
		linkedList.print();
		
		LinkedListUtil.printInReverse(linkedList);
	}

}
