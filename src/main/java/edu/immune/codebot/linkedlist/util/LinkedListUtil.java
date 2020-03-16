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

	private static <T> void printReverse(Iterator<T> iterator) {
		if (iterator.hasNext()) {
			T value = iterator.next();
			printReverse(iterator);
			System.out.printf("%d ", value);
		}
	}

	/**
	 * Prints the linked list in reverse order
	 * 
	 * @param list actual {@linkplain LinkedList}
	 */
	public static <T> void printInReverse(LinkedList<T> list) {
		Iterator<T> iterator = list.iterator();
		printReverse(iterator);
	}

}
