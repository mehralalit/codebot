package edu.immune.codebot.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.immune.codebot.tree.binary.BinarySearchTree;

/**
 * JUnit test cases for {@link BinarySearchTree}
 * 
 * @author Lalit Mehra
 *
 */
public class BinarySearchTreeTester {

	BinarySearchTree<Integer> tree;
	
	@Before
	public void before() {
		tree = new BinarySearchTree<Integer>();
	}
	
	@After
	public void after() {
		tree = null;
	}
	
	@Test
	public void testAdd() {
		tree.add(1);
		assertEquals("1", tree.inorder().trim());
	}
	
	@Test
	public void testInOrderTraversal() {
		tree.add(2);
		tree.add(1);
		tree.add(3);
		
		String content = tree.inorder();
		assertEquals("1 2 3", content.trim());
	}
	
	@Test
	public void testPreOrderTraversal() {
		tree.add(2);
		tree.add(1);
		tree.add(3);
		
		String content = tree.preorder();
		assertEquals("2 1 3", content.trim());
	}
	
	@Test
	public void testPostOrderTraversal() {
		tree.add(2);
		tree.add(1);
		tree.add(3);
		
		String content = tree.postorder();
		assertEquals("1 3 2", content.trim());
	}
	
	@Test
	public void testRemoveLeafElement() {
		tree.add(2);
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(4);
		String content = tree.inorder();
		assertEquals("1 2 3 4 6", content.trim());
		
		tree.remove(1);
		content = tree.inorder();
		assertEquals("2 3 4 6", content.trim());
	}
	
	@Test
	public void testRemoveSingleParent() {
		tree.add(2);
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(4);
		String content = tree.inorder();
		assertEquals("1 2 3 4 6", content.trim());
		
		tree.remove(3);
		content = tree.inorder();
		assertEquals("1 2 4 6", content.trim());
	}
	
	@Test
	public void testRemoveParentOfTwo() {
		tree.add(2);
		tree.add(1);
		tree.add(3);
		tree.add(6);
		tree.add(4);
		String content = tree.inorder();
		assertEquals("1 2 3 4 6", content.trim());
		
		tree.remove(2);
		content = tree.inorder();
		assertEquals("1 3 4 6", content.trim());
	}
}
