package com.codejock.algorithms.tree.binarysearch;

import java.util.logging.Logger;

public class BinarySearchTree <T extends Comparable>{
	private Node<T> root;
	Logger logger = Logger.getLogger(getClass().getSimpleName());

	public Node<T> find(T value){
		Node<T> foundNode = null;
		
		if(root != null){
			foundNode = find2(root, value);
		}
		return foundNode;
	}
	
	protected Node<T> find2(Node<T> node, T value){
		if(node.isEqual(value)){
			return node;
		}else if(node.isLessThan(value) && node.getRight() != null){
			return find2(node.getRight(), value);
		}else if(node.isGreaterThan(value) && node.getLeft() != null){
			return find2(node.getLeft(), value);
		}else{
			return null;
		}
	}

	public boolean add(Node<T> node){
		
		boolean addedNode = false;
		Node<T> foundNode = find(node.getValue());
		if( foundNode == null){
			if(root == null){
				root = node;
				addedNode = true;
			}else{
				addedNode = add2(root, node);
			}
		}
		return addedNode;
	}
	
	public boolean add(T value){
		
		return add(new Node<T>(value));
	}
	
	protected boolean add2(Node<T> currentNode, Node<T> newNode){
		if(currentNode.isLessThan(newNode)){
			if(currentNode.getRight() != null){
				return add2(currentNode.getRight(), newNode);
			}else{
				currentNode.setRight(newNode);
				return true;
			}
		}else{
			if(currentNode.getLeft() != null){
				return add2(currentNode.getLeft(), newNode);
			}else{
				currentNode.setLeft(newNode);
				return true;
			}
		}
	}
	
	protected Node<T> findParent(Node<T> node){
		Node<T> parent = null, currentNode = root;
		while(parent == null && !node.equals(root)){
			if(node.equals(currentNode.getLeft()) || node.equals(currentNode.getRight())){
				parent = currentNode;
			}else if(currentNode.isGreaterThan(node) && currentNode.getLeft() != null){
				currentNode = currentNode.getLeft();
			}else if(currentNode.isLessThan(node) && currentNode.getRight() != null){
				currentNode = currentNode.getRight();
			}else{
				break;// value can't be found.
			}
		}
		return parent;
	}
	

	public boolean delete(T value){
		boolean deleted = false;
		Node<T> delNode;
		Node<T> parent;
		Node<T> replacement;
		boolean isRoot = false;
		logger.info("\n\tDeleteing value(" + value + ")");
		if(root != null){
			if(root.isEqual(value)){
				//logger.info("\n\tThe value is the root");
				delNode = root;
				isRoot = true;
				parent = null;
			}else{
				delNode = find(value);
				if(delNode == null){
					logger.info("Tree does not contain value " + value + ".");
					return deleted;
				}
				parent = findParent(delNode);
			}
			
			if(delNode.isLeaf()){
				logger.info("\n\tDelete Node is a leaf.");
				if(isRoot){
					root = null;
					deleted = true;
					return deleted;
				}else{
					replacement = null;
				}
			}else if(delNode.getLeft() == null){
				logger.info("\n\tDelete Node has only a right child.");
				replacement = delNode.getRight();
			}else if(delNode.getRight() == null){
				logger.info("\n\tDelete Node has only a left child.");
				replacement = delNode.getLeft();
			}else{
				logger.info("\n\tDelete Node has only 2 children.");
				
				replacement = getReplacement(delNode);
			}
			if(isRoot){
				
				replacement.setLeft(root.getLeft());
				replacement.setRight(root.getRight());
				root = replacement;
			} else {
				if(delNode.isEqual(parent.getLeft())){
					parent.setLeft(replacement);
				}else{
					parent.setRight(replacement);
				}	
			}
			deleted = true;
		}
		return deleted;
	}
	
	public void print(){
		StringBuffer buffer = new StringBuffer();
		buffer.append('{');
		print2(root, buffer);
		buffer.append('}');
		logger.info(String.format("Tree: %s", buffer.toString()));
	}
	
	protected void print2(Node<T> node, StringBuffer buffer){
		if( node == null){
			return;
		}else{
			logger.info("\t\t***On Node:" + node.getValue());
			print2(node.getLeft(), buffer);
			logger.info("\t\t***Adding:" + node.getValue());
			buffer.append(node.getValue());
			buffer.append(", ");
			print2(node.getRight(), buffer);
		}
	}
	
	private Node<T> getReplacement(Node<T> node){
		Node<T> replacement = null;
		if(!node.isLeaf()){
			Node<T> previous = node;
			if(node.getLeft() != null){
				replacement = node.getLeft();//go left
				while(replacement.getRight() != null){//go as far right as possible.
					previous = replacement;
					replacement = replacement.getRight();
					logger.info("Go Right!");
				}
				if(!previous.isEqual(node) && !previous.equals(replacement.getLeft())){
					previous.setRight(replacement.getLeft());
				}
			}else{
				if(!previous.isEqual(node)){
					replacement = node.getRight();
				}
				while(replacement.getLeft() != null){
					previous = replacement;
					replacement = replacement.getLeft();
					logger.info("Go Left!");
				}
				if(!previous.isEqual(node) && !previous.equals(replacement.getRight())){
					previous.setLeft(replacement.getRight());
				}
			}
			
			if(replacement != null && !replacement.isLeaf()){
				delete(replacement.getValue());
			}
			
			if(!replacement.equals(node.getLeft())){
				replacement.setLeft(node.getLeft());
			}
			if(!replacement.equals(node.getRight())){
				replacement.setRight(node.getRight());
			}
		}
		
		return replacement;
	}
	
	
	public Node<T> getRoot(){
		return root;
	}
	

}
