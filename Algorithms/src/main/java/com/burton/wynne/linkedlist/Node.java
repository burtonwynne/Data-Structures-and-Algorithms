package com.burton.wynne.linkedlist;

public class Node {
	private Object value;
	private Node next;
	private Node previous;
	
	public Node(Object value){
		this.value = value;
	}
	
	public Object getValue(){
		return value;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node node){
		this.next = node;
	}
	
	public Node getPrevious(){
		return previous;
	}
	
	public void setPrevious(Node node){
		this.previous = node;
	}
}
