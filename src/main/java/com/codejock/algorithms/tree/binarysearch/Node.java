package com.codejock.algorithms.tree.binarysearch;

public class Node <T extends Comparable>{
	private T value;
	private Node<T> right;
	private Node<T> left;
	
	
	public Node(T value) {
		super();
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public boolean isLessThan(T value){
		return this.value.compareTo(value) < 0;
	}
	public boolean isGreaterThan(T value){
		return this.value.compareTo(value) > 0;
	}
	public boolean isEqual(T value){
		return this.value.equals(value);
	}

	public boolean isLessThan(Node<T> node){
		if(node == null){
			return false;
		}else{
			return this.isLessThan(node.value);
		}
	}
	public boolean isGreaterThan(Node<T> node){
		if(node == null){
			return false;
		}else{
			return this.isGreaterThan(node.value);
		}
	}
	public boolean isEqual(Node<T> node){
		if(node == null){
			return false;
		}else{
			return this.isEqual(node.value);
		}
	}
	
	public boolean isLeaf(){
		return right == null && left == null;
	}
	
	
}
