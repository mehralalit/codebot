package edu.immune.codebot.queue;

import java.io.Serializable;

import edu.immune.codebot.exception.IndexOutOfReachException;
import edu.immune.codebot.linkedlist.LinkedList;

/**
 * Generic implementation of Queue. Implementation uses an underlying {@link LinkedList} for data storage.
 * @author Lalit Mehra
 *
 * @param <T>
 */
public class Queue<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7220788117686859187L;
	
	/**
	 * Stores elements of the Queue
	 */
	private LinkedList<T> data;
	
	public Queue() {
		this.data = new LinkedList<T>();
	}
	
	/**
	 * Add an element to the head of the Queue. Throws {@link IndexOutOfReachException} if the Queue is empty
	 * @param e element to add to the queue
	 */
	public void enqueue(T e) {
		data.addToHead(e);
	}
	
	/**
	 * Remove an element from the tail of the Queue. Throws {@link IndexOutOfReachException} if the Queue is empty
	 * @return
	 */
	public T dequeue() {
		return data.removeFromTail();
	}
	
}
