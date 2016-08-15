package com.burton.wynne.algorithms.tests;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import com.codejock.algorithms.linkedlist.LinkedList;
import com.codejock.algorithms.linkedlist.Node;

public class LinkedListTest {
	private Logger logger= Logger.getLogger(this.getClass().getSimpleName());
	
	@Test
	public void testAdd() {
		LinkedList linkedlist = createNumberedLininkedList();
		Node node;
		
		node = linkedlist.find(1);
		testNode(1, node);
		node = linkedlist.find(2);
		testNode(2, node);
		node = linkedlist.find(3);
		testNode(3, node);
		node = linkedlist.find(4);
		testNode(4, node);
		node = linkedlist.find(5);
		testNode(5, node);
		assertEquals("Expect size: 5.  Actual LinkedList size:" + linkedlist.size(), 5,  linkedlist.size());
		node = linkedlist.find(6);
		assertNull("Expected this null to be null but got Node('" + node + "') instead.", node);
		int count = 0;
		
		node = linkedlist.getFirst();
		
		while(node != null){
			count++;
			testNode(count , node);
			node = node.getNext();
		}
		
		assertEquals("Count(" + count + ") did not equal actual LinkedList.size(" + linkedlist.size() + ")", linkedlist.size(), count);
		
		node = linkedlist.getLast();
		
		while(node != null){
			testNode(count, node);
			node = node.getPrevious();
			count--;
		}
	}
	
	@Test
	public void testReverse(){
		LinkedList<Integer> list = createNumberedLininkedList();
		list.reverse();
		Node currNode = list.getFirst();
		for(int counter = 5; counter > 0; counter--){
			assertEquals(String.format("The counter(%d) did not match Node(%d).", counter, currNode.getValue()), counter,  currNode.getValue());
			currNode = currNode.getNext();
		}
		
		currNode = list.getLast();
		for(int counter = 1; counter < 6; counter++){
			logger.info(String.format("Current Node(%d)", currNode.getValue()));
			assertEquals(String.format("The counter(%d) did not match Node(%d).", counter, currNode.getValue()), counter,  currNode.getValue());
			currNode = currNode.getPrevious();
		}
	}
	
	private LinkedList<Integer> createNumberedLininkedList(){
		LinkedList<Integer> linkedlist = new LinkedList();
		linkedlist.add(new Node<Integer>(1));
		linkedlist.add(new Node<Integer>(2));
		linkedlist.add(new Node<Integer>(3));
		linkedlist.add(new Node<Integer>(4));
		linkedlist.add(new Node<Integer>(5));
		return linkedlist;
	}
	
	
	
	
	private void testNode(Object obj, Node node){
		assertNotNull("Expected Node('" + obj + "') is null", node);
		assertEquals("Expected Node('" + obj + "') but was Node('" + node.getValue() + "') instead", obj, node.getValue());
	}

}
