package edu.immune.codebot.linkedlist;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.immune.codebot.exception.IndexOutOfReachException;

public class LinkedListTester {

	private LinkedList<Integer> list;

	@Before
	public void before() {
		list = new LinkedList<Integer>();
	}

	@After
	public void after() {
		list = null;
	}

	@Test
	public void testIsEmpty() {
		// list has no elements
		assertTrue(list.isEmpty());
	}

	@Test
	public void testIsEmpty2() {
		list.addToHead(1);
		list.removeFromHead();

		// list has no elements now
		assertTrue(list.isEmpty());
	}

	@Test
	public void testPrint() {
		list.addToHead(1);
		list.addToTail(2);

		assertEquals("1 --> 2", list.print());
	}

	@Test
	public void testAddToHead() {
		list.addToHead(3);
		list.addToHead(2);
		list.addToHead(1);

		assertEquals("1 --> 2 --> 3", list.print());
		assertNotEquals("1 --> 3 --> 3", list.print());
	}

	@Test
	public void testAddToTail() {
		list.addToTail(1);
		list.addToTail(2);
		list.addToTail(3);

		assertEquals("1 --> 2 --> 3", list.print());
		assertNotEquals("1 --> 3 --> 3", list.print());
	}

	@Test
	public void testAdd() {
		list.add(1, 1);
		list.addToTail(3);
		list.add(2, 2);

		assertEquals("1 --> 2 --> 3", list.print());
		assertNotEquals("1 --> 3 --> 2", list.print());
	}

	@Test
	public void testRemoveFromHead() {
		list.addToTail(3);
		list.addToHead(2);
		list.addToHead(1);

		list.removeFromHead();

		assertEquals("2 --> 3", list.print());
		assertNotEquals("1 --> 3 --> 3", list.print());

		list.removeFromHead();

		assertEquals("3", list.print());
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testRemoveFromHeadException() {
		// this should throw exception. list has no elements
		list.removeFromHead();
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testRemoveFromHeadException2() {
		list.addToTail(1);
		list.removeFromHead();

		// this should throw exception. list has no elements
		list.removeFromHead();
	}

	@Test
	public void testRemoveFromTail() {
		list.addToTail(1);
		list.addToTail(2);
		list.addToTail(3);

		list.removeFromTail();

		assertEquals("1 --> 2", list.print());
		assertNotEquals("1 --> 3 --> 3", list.print());

		list.removeFromTail();
		assertEquals("1", list.print());
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testRemoveFromTailException() {
		// this should throw exception. list has no elements
		list.removeFromTail();
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testRemoveFromTailException2() {
		list.addToTail(1);
		list.removeFromTail();

		// this should throw exception. list has no elements
		list.removeFromTail();
	}

	@Test
	public void testRemove() {
		list.addToHead(1);
		list.addToTail(3);
		list.add(2, 2);

		list.remove(2);

		assertEquals("1 --> 3", list.print());
		assertNotEquals("1 --> 3 --> 2", list.print());

		list.remove(1);
		assertEquals("3", list.print());

	}

	@Test(expected = IndexOutOfReachException.class)
	public void testRemoveException() {
		// this should throw exception. list has no elements
		list.remove(1);
	}

	@Test(expected = IndexOutOfReachException.class)
	public void testRemoveException2() {
		list.addToTail(1);
		list.removeFromTail();

		// this should throw exception. list has no elements
		list.remove(1);
	}

	@Test
	public void testGetValue() {
		list.addToHead(1);
		list.addToTail(2);

		assertEquals(1, list.getValue(1));
		assertEquals(2, list.getValue(2));
	}

}
