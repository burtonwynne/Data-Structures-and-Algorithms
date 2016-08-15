package com.codejock.algorithms.linkedlist;

public class LinkedList<T> {
	private Node<T> first;
	private Node<T> last;
	private int size = 0;
	
	public void add(Node<T> node){
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
	
	public Node<T> getFirst(){
		return first;
	}
	
	public Node<T> getLast(){
		return last;
	}
	public Node<T> find(T value){
		Node<T> foundNode = null, currentNode = first;
		T currentValue;
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
	
	public void reverse(){
		last = first;
		reverse2(first);
	}
	
	public Node<T> reverse2(Node<T> node){
		if(node.getNext() == null){
			first = node;
			return node;
		}else{
			node.setPrevious(node.getNext());
			reverse2(node.getNext()).setNext(node);
			return node;
		}
	}
	
	public void print(){
		
	}
	
	public Node<T> remove(T value){
		Node<T> removedNode = find(value);
		if(removedNode != null){
			Node<T> previous = removedNode.getPrevious();
			Node<T> next = removedNode.getNext();
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
