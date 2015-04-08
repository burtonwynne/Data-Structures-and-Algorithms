package com.burton.wynne.linkedlist;

public class LinkedList {
	private Node first;
	private Node last;
	private int size = 0;
	
	public void add(Node node){
		if(first == null){
			first = node;
			last = node;
		}else{
			last.setNext(node);
			node.setPrevious(last);
			last = node;
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public Node getFirst(){
		return first;
	}
	
	public Node getLast(){
		return last;
	}
	public Node find(Object value){
		Node foundNode = null, currentNode = first;
		Object currentValue;
		while(currentNode != null){
			currentValue = currentNode.getValue();
			if(value.equals(currentValue)){
				foundNode = currentNode;
				break;
			}
			currentNode = currentNode.getNext();
		}
		return foundNode;
	}
	
	public Node remove(Object value){
		Node removedNode = find(value);
		if(removedNode != null){
			Node previous = removedNode.getPrevious();
			Node next = removedNode.getNext();
			if(previous != null){
				previous.setNext(next); 
			}
			
			if(next != null){
				next.setPrevious(previous);
			}
			
			if(first == removedNode){
				first = next;
			}
			
			if(last == removedNode){
				last = previous;
			}
			size--;
		}
		return removedNode;
	}
}
