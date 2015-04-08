package com.burton.wynne.algorithms.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.burton.wynne.linkedlist.LinkedList;
import com.burton.wynne.linkedlist.Node;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList linkedlist = new LinkedList();
		linkedlist.add(new Node("1"));
		linkedlist.add(new Node("2"));
		linkedlist.add(new Node("3"));
		linkedlist.add(new Node("4"));
		linkedlist.add(new Node("5"));
		Node node;
		
		node = linkedlist.find("1");
		testNode("1", node);
		node = linkedlist.find("2");
		testNode("2", node);
		node = linkedlist.find("3");
		testNode("3", node);
		node = linkedlist.find("4");
		testNode("4", node);
		node = linkedlist.find("5");
		testNode("5", node);
		assertEquals("Expect size: 5.  Actual LinkedList size:" + linkedlist.size(), 5,  linkedlist.size());
		node = linkedlist.find("6");
		assertNull("Expected this null to be null but got Node('" + node + "') instead.", node);
		int count = 0;
		
		node = linkedlist.getFirst();
		
		while(node != null){
			count++;
			testNode(count + "", node);
			node = node.getNext();
		}
		
		assertEquals("Count(" + count + ") did not equal actual LinkedList.size(" + linkedlist.size() + ")", linkedlist.size(), count);
		
		node = linkedlist.getLast();
		
		while(node != null){
			testNode(count + "", node);
			node = node.getPrevious();
			count--;
		}
	}
	
	private void testNode(Object obj, Node node){
		assertNotNull("Expected Node('" + obj + "') is null", node);
		assertEquals("Expected Node('" + obj + "') but was Node('" + node.getValue() + "') instead", obj, node.getValue());
	}

}
