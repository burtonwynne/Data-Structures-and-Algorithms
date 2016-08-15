package com.burton.wynne.algorithms.tests;
import java.util.Random;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		int limit = 1000000000;
		Random random = new Random();
		
		for(int index = 0; index < limit; index++){
			stack.push(new Integer(random.nextInt(limit)));
		}
		
		for(int index = 0; index < limit; index++){
			System.out.println("Pop(" + index + "): " +  stack.pop());
		}

	}

}
