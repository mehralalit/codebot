package edu.immune.codebot.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.immune.codebot.exception.IndexOutOfReachException;

/**
 * Test class for {@link Stack} implementation
 * 
 * @author Lalit Mehra
 *
 */
public class StackTester {

	private Stack<Integer> stack;
	private int size = 2;

	@Before
	public void before() {
		stack = new Stack<Integer>(size);
	}
	
	@After
	public void after() {
		stack = null;
	}

	@Test
	public void testSize() {
		assertEquals(size, stack.getSize());
	}

	@Test
	public void testCurrentIndex() {
		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.getIndex());

		stack.peek();
		assertEquals(2, stack.getIndex());

		stack.pop();
		assertEquals(1, stack.getIndex());
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testPushException() {
		stack.push(1);
		stack.push(2);

		// this should throw exception. size of stack is 2
		stack.push(3);
	}

	@Test
	public void testPeek() {
		stack.push(1);
		assertEquals(1, stack.peek());

		assertNotEquals(2, stack.peek());
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testPeekException() {
		// this should throw exception. stack has no elements
		stack.peek();
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testPeekException2() {
		stack.push(1);
		stack.pop();

		// this should throw exception. stack has no elements
		stack.peek();
	}

	@Test
	public void testPop() {
		stack.push(1);
		assertEquals(1, stack.pop());

		stack.push(1);
		assertNotEquals(2, stack.pop());
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testPopException() {
		// this should throw exception. stack has no elements
		stack.pop();
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testPopException2() {
		stack.push(1);
		stack.pop();

		// this should throw exception. stack has no elements
		stack.pop();
	}

}
