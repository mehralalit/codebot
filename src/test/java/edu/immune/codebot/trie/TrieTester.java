package edu.immune.codebot.trie;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test cases for {@link Trie}
 * 
 * @author Lalit Mehra
 *
 */
public class TrieTester {

	private Trie<Integer> trie = null;
	
	@Before
	public void before() {
		trie = new Trie<Integer>();
	}
	
	@After
	public void after() {
		trie = null;
	}
	
	@Test
	public void testAdd() {
		Integer[] elements = {1,2,3};
		trie.add(Arrays.asList(elements));
	}
	
}
