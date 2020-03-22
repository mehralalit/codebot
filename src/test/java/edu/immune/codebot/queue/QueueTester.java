package edu.immune.codebot.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.immune.codebot.exception.IndexOutOfReachException;

public class QueueTester {
	
	private Queue<Integer> queue;
	
	@Before
	public void before() {
		queue = new Queue<Integer>();
	}

	@After
	public void after() {
		queue = null;
	}
	
	@Test
	public void testEnqueue() {
		queue.enqueue(1);
	}
	
	@Test
	public void testDequeue() {
		queue.enqueue(1);
		assertEquals(1, queue.dequeue());
		
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(1, queue.dequeue());
	}
	
	@Test(expected = IndexOutOfReachException.class)
	public void testDequeueException() {
		// this should throw exception. queue has no elements
		queue.dequeue();
	}
	
	@Test(expected = IndexOutOfReachException.class)
	public void testDequeueException2() {
		queue.enqueue(1);
		queue.dequeue();
		
		// this should throw exception. queue has no elements
		queue.dequeue();
	}
}
