package com.burton.wynne.tree.binarysearch;

abstract public class Node {
	private Object value;
	private Node right;
	private Node left;
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}

	abstract boolean isLessThan(Node node);
	abstract boolean isGreaterThan(Node node);
	abstract boolean isEqual(Node node);

}
