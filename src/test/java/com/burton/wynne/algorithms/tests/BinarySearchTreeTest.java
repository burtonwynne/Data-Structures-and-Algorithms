package com.burton.wynne.algorithms.tests;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import com.codejock.algorithms.tree.binarysearch.BinarySearchTree;
import com.codejock.algorithms.tree.binarysearch.Node;

public class BinarySearchTreeTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@Test
	public void testCreate() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		int[] data = new int[]{11, 6, 19, 4, 8, 17, 43, 5, 10, 31, 41};
		for(int value:data){
			assertTrue(String.format("Was unable to add value(%d) to the tree.", value),tree.add(value));
		}
		Node<Integer> node;
		for(int value:data){
			node = tree.find(value);
			assertNotNull(String.format("Could not find Node(%d) in tree", value), node);
			logger.info("Node: " + node.getValue());
			assertEquals(String.format("The Node(%d) did not have the value of %d.", node.getValue(), value), value, node.getValue().intValue());
		}
	}
	
	@Test
	public void testDelete1() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		int[] data = new int[]{11, 6, 19, 4, 8, 17, 43, 5, 10, 31, 41};
		for(int value:data){
			tree.add(value);
		}
		Node<Integer> node;
		for(int ndx = data.length; ndx > 0; ndx--){
			int value = data[ndx - 1];
			logger.info(String.format("Deleting Node(%d)", value));
			tree.delete(value);
			node = tree.find(value);
			assertNull(String.format("Could find Node(%d) in tree", value), node);
		}
	}
	
	protected void testDelete(int[] insertValues, int[] deleteValues, int[] remainingValues){
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		for(int value:insertValues){
			logger.info(String.format("Adding Node(%d) to the tree.", value));
			tree.add(value);
		}
		Node<Integer> node;
		for(int value:deleteValues){
			tree.print();
			logger.info(String.format("Deleting Node(%d)", value));
			tree.delete(value);
			node = tree.find(value);
			assertNull(String.format("Could find Node(%d) in tree", value), node);
			tree.print();
			logger.info(String.format("root.value(%d)", tree.getRoot().getValue()));
		}
		for(int value:remainingValues){
			logger.info(String.format("Finding Node(%d)", value));
			node = tree.find(value);
			assertNotNull(String.format("Could not find Node(%d) in tree", value), node);
			logger.info(String.format("Found Node(%d)", value));
		}
	}
	
	
	@Test
	public void testDeleteLeaves() {
		int[] data = new int[]{11, 6, 19, 4, 8, 17, 43, 5, 10, 31, 41};
		int[] delete = new int[]{5,10,17,41};
		int[] remaining = new int[]{11, 6, 19, 4, 8, 43, 31};
		testDelete(data, delete, remaining);
	}
	
	@Test
	public void testDeleteParentWSingleChild() {
		int[] data = new int[]{11, 6, 19, 4, 8, 17, 43, 5, 10, 31, 41};
		int[] delete = new int[]{4, 8, 17, 31, 43};
		int[] remaining = new int[]{11, 6, 19, 5, 10, 41};
		testDelete(data, delete, remaining);
	}
	
	@Test
	public void testDeleteParentWTwoChildren() {
		int[] data = new int[]{11, 6, 19, 4, 8, 17, 43, 5, 10, 31, 41};
		int[] delete = new int[]{6,19,11};
		int[] remaining = new int[]{4, 8, 17, 43, 5, 10, 31, 41};
		testDelete(data, delete, remaining);
	}
	
	@Test
	public void testDeleteRoot() {
		int[] data = new int[]{11, 6, 19, 4, 8, 17, 43, 5, 10, 31, 41};
		int[] delete = new int[]{11, 10, 8, 6, 5};
		int[] remaining = new int[]{19, 4, 17, 43, 31, 41};
		testDelete(data, delete, remaining);
	}
	
	
	
	@Test
	public void testNode(){
		Node<Integer> a = new Node<Integer>(5);
		Node<Integer> b = new Node<Integer>(3);
		Node<Integer> c = new Node<Integer>(5);
		
		assertTrue(a.isGreaterThan(b));
		assertTrue(a.isEqual(c));
		assertTrue(b.isLessThan(a));
 	}

}
