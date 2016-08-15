package com.codejock.algorithms.stack;
import java.lang.reflect.Array;
import java.util.*;

public class Stack <T>{

	private T[] elements;
	
	private int size = 0;
	
	public Stack(int initialCapacity) {
	
		this.elements = (T[]) new Object[initialCapacity];
	
	}
	
	public void push(T e) {
	
		ensureCapacity();
		
		elements[size++] = e;
	
	}
	
	public T pop() {
		
		if (size==0){
			throw new EmptyStackException();
		}else{
			return elements[--size];
		}
	}
	
	/**
	
	* Ensure space for at least one more element, roughly
	
	* doubling the capacity each time the array needs to grow.
	
	*/
	
	private void ensureCapacity() {
	
		if (elements.length == size) {
			T[] oldElements = elements;
			
			elements = (T[]) new Object[2 * elements.length + 1];
			
			System.arraycopy(oldElements, 0, elements, 0, size);
		
		}
	
	}
}
