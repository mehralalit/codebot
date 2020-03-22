package edu.immune.codebot.stack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic Implementation of Stack. Current Implementation uses an underlying {@link ArrayList} for data storage.<br>
 * 
 * @author Lalit Mehra
 *
 * @param <T>
 */
public class Stack<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -738562161226493330L;

	/**
	 * Size of the Stack as supplied in the constructor
	 */
	private int size;
	
	/**
	 * Stores elements of the Stack
	 */
	private List<T> data;
	
	/**
	 * @param size no of elements the stack can hold
	 */
	public Stack(int size) {
		if(size < 1) {
			throw new IllegalArgumentException("Size of the Stack cannot be 0 or less");
		}
		this.size = size;
		this.data = new ArrayList<T>(size);
	}
	
	/**
	 * Returns the size of the stack 
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Returns the position of the element on top of the stack
	 * @return
	 */
	public int getIndex() {
		return data.size();
	}
	
	/**
	 * Add an element to the stack
	 * @param e element to add to the stack
	 */
	public void push(T e) {
		if(data.size() < size) {
			data.add(e);
		} else {
			throw new IndexOutOfBoundsException("Stack is Full!");
		}
	}
	
	/**
	 * Removes the element on top of the stack 
	 */
	public T pop() {
		if(data.isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is Empty!");
		} else {
			return data.remove(data.size() - 1);
		}
	}
	
	/**
	 * Returns the element on top of the stack
	 * @return
	 */
	public T peek() {
		if(data.isEmpty()) {
			throw new IndexOutOfBoundsException("Stack is Empty!");
		} else {
			return data.get(data.size() - 1);
		}
	}
}
