package edu.immune.codebot.linkedlist.util;

import java.util.Iterator;

import edu.immune.codebot.linkedlist.LinkedList;

/**
 * Utility class for {@link LinkedList} implementation<br>
 * Provides common utility functions for the {@link LinkedList}
 * 
 * @author Lalit Mehra
 *
 */
public class LinkedListUtil<T> {

	/**
	 * Recursively prints the list in reverse order. Makes no changes to the list.<br>
	 * 
	 * @param <T>
	 * @param iterator
	 */
	private static <T> void printReverse(Iterator<T> iterator) {
		if (iterator.hasNext()) {
			T value = iterator.next();
			printReverse(iterator);
			System.out.printf("%d ", value);
		}
	}
	
	/**
	 * Recursively adds the element to another list from the original one
	 * 
	 * @param <T>
	 * @param iterator iterator to the original list
	 * @param reversedList list to fill in reverse order
	 */
	private static <T> void reverse(Iterator<T> iterator, LinkedList<T> reversedList) {
		if(iterator.hasNext()) {
			T value = iterator.next();
			reverse(iterator, reversedList);
			reversedList.addToTail(value);
		}
	}
	
	/**
	 * Adds the element to another list from the original one
	 * 
	 * @param <T>
	 * @param iterator iterator to the original list
	 * @param reversedList list to fill in reverse order
	 */
	private static <T> void reverseInPlace(Iterator<T> iterator, LinkedList<T> reversedList) {
		while(iterator.hasNext()) {
			T value = iterator.next();
			reversedList.addToHead(value);
		}
	}

	/**
	 * Prints the linked list in reverse order. No changes are made to the list.
	 * 
	 * @param list actual {@linkplain LinkedList}
	 */
	public static <T> void printInReverse(LinkedList<T> list) {
		Iterator<T> iterator = list.iterator();
		printReverse(iterator);
		System.out.println();
	}

	/**
	 * Returns a new linked list containing elements in reverse order to the original one provided as input
	 * 
	 * @param <T>
	 * @param list original list
	 * @param recursive choice of method to reverse the list<br>
	 *			1. true for recursive<br>
	 *			2. false otherwise
	 * @return
	 */
	public static <T> LinkedList<T> reverse(LinkedList<T> list, boolean recursive) {
		
		LinkedList<T> reversedList = new LinkedList<T>();
		Iterator<T> iterator = list.iterator();
		
		if(recursive) { 
			reverse(iterator, reversedList);
		} else {
			reverseInPlace(iterator, reversedList);
		}
		
		return reversedList;
	}
	
}
