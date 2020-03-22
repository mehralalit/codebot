package edu.immune.codebot.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.immune.codebot.exception.IndexOutOfReachException;

/**
 * LinkedList Implementation. Follows insertion order.
 * 
 * @author Lalit Mehra
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {

	/**
	 * 
	 * @author Lalit Mehra
	 *
	 */
	private static class Node<T> {

		private T value;
		private Node<T> next;

		public Node(T value) {
			this.value = value;
		}

	}

	private class LinkedListIterator implements Iterator<T> {

		private Node<T> next;
		private T lastReturnedValue;

		public LinkedListIterator() {
			this.next = isEmpty() ? null : head;
		}

		@Override
		public boolean hasNext() {
			return this.next != null ? true : false;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			lastReturnedValue = next.value;
			next = next.next;

			return lastReturnedValue;
		}

	}

	/**
	 * First or head node of the linked list
	 */
	private Node<T> head;

	/**
	 * Stores number of nodes present in the linked list<br>
	 * Used to determine if the list is empty and is updated with each insert or
	 * delete operation done on the list<br>
	 * Default length of the list is set to 0 depicting empty list
	 */
	private int length = 0;

	/**
	 * Last or tail node of the linked list
	 */
	private Node<T> tail;

	/**
	 * Check if the LinkedList is empty.<br>
	 * It also displays a message if the list is empty.
	 * 
	 * @return <b>true:</b> if the list is empty<br>
	 *         <b>false:</b> if the list is not empty
	 */
	public boolean isEmpty() {
		boolean empty = false;

		if (length == 0) {
			empty = true;
		}

		return empty;
	}

	/**
	 * Print the elements in the list in insertion order
	 */
	public String print() {

		if (isEmpty())
			return "";

		StringBuilder values = new StringBuilder();
		Node<T> step = head;
		while (step != null) {
			values.append(step.value);
			step = step.next;
			if (step != null) {
				values.append(" --> ");
			} 
		}
		
		return values.toString();
	}

	/**
	 * Add an element at the head position
	 * 
	 * @param value
	 */
	public void addToHead(T value) {
		Node<T> first = new Node<T>(value);
		first.next = head;

		if (head != null) {
			head = first;
		} else {
			head = first;
			tail = head;
		}

		length++;
	}

	/**
	 * Add an element at the tail position
	 * 
	 * @param value
	 */
	public void addToTail(T value) {
		Node<T> last = new Node<T>(value);

		if (head != null) {
			tail.next = last;
			tail = tail.next;
		} else {
			head = last;
			tail = head;
		}

		length++;
	}

	/**
	 * Add an element at the provided position. Position index starts with 1<br>
	 * 
	 * @param value
	 * @param position position of the element <br>
	 *                 if position &lt= 1 the new element is added at the head
	 *                 position<br>
	 *                 if position &gt= 1 the new element is added at the tail
	 *                 position
	 */
	public void add(T value, int position) {
		if (position <= 1) {
			addToHead(value);
			return;
		}

		if (position > length) {
			addToTail(value);
			return;
		}

		Node<T> step = head;
		for (int index = 2; index < position; index++) {
			step = step.next;
		}

		Node<T> node = new Node<T>(value);
		node.next = step.next;
		step.next = node;

		length++;
	}

	/**
	 * Remove the element at the head position.<br>
	 * If the list is empty no changes are made
	 * 
	 * @return value at the removed position
	 */
	public T removeFromHead() {
		if (isEmpty())
			throw new IndexOutOfReachException();

		Node<T> node = head;
		T val = node.value;

		head = head.next;
		node = null;

		length--;
		return val;
	}

	/**
	 * Remove the element at the tail position.<br>
	 * If the list is empty no changes are made
	 * 
	 * @return value at the removed position
	 */
	public T removeFromTail() {
		if (isEmpty())
			throw new IndexOutOfReachException();

		Node<T> step = head;
		while (step.next != null && step.next.next != null) {
			step = step.next;
		}

		T val;
		if (length == 1) {
			val = step.value;
		} else {
			Node<T> node = step.next;
			val = node.value;
			node = null;
		}

		step.next = null;
		tail = step;

		length--;

		return val;
	}

	/**
	 * Remove the element at the provided position. Position index starts with 1<br>
	 * 
	 * @param position position of the element <br>
	 *                 if position &lt= 1 the new element is added at the head
	 *                 position<br>
	 *                 if position &gt= 1 the new element is added at the tail
	 *                 position
	 */
	public T remove(int position) {
		if (isEmpty())
			throw new IndexOutOfReachException();

		if (position <= 1) {
			return removeFromHead();
		}

		if (position >= length) {
			return removeFromTail();
		}

		Node<T> step = head;
		for (int index = 2; index < position; index++) {
			step = step.next;
		}

		Node<T> node = step.next;
		T val = node.value;
		step.next = node.next;
		node = null;

		length--;
		return val;
	}

	/**
	 * @param position position of the element <br>
	 * @return value of the element stored at the provided position <br>
	 *         if position &lt= 1 value of the first element is returned <br>
	 *         if position &gt= 1 value of the last element is returned
	 */
	public T getValue(int position) {

		if (position <= 1) {
			return head.value;
		}

		if (position >= length) {
			return tail.value;
		}

		Node<T> step = head;
		for (int index = 1; index <= length; index++) {
			step = step.next;
		}

		return step.value;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

}