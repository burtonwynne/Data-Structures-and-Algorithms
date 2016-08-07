package com.burton.wynne.linkedlist;

public class Node<T> {
	private T value;
	private Node<T> next;
	private Node<T> previous;
	
	public Node(T value){
		this.value = value;
	}
	
	public T getValue(){
		return value;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public void setNext(Node<T> node){
		this.next = node;
	}
	
	public Node<T> getPrevious(){
		return previous;
	}
	
	public void setPrevious(Node<T> node){
		this.previous = node;
	}
}
