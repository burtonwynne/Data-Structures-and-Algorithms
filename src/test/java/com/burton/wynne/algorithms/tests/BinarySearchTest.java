/**
 * 
 */
package com.burton.wynne.algorithms.tests;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.burton.wynne.search.BinarySearchAlgorithm;

/**
 * @author burtonwynne
 *
 */
public class BinarySearchTest {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGenrarl() {
		BinarySearchAlgorithm<Integer> binarySearch = new BinarySearchAlgorithm<>();
		Integer[] subject = new Integer[1000];
		IntStream.range(0, 1000).forEachOrdered(n ->{subject[n] = n;});
		Random randomizer = new Random();
		int index;
		int item;
		for(int times = 0; times < 500; times++){
			item = randomizer.nextInt(999);
			index = binarySearch.search(item, subject);
			assertEquals(String.format(
					"Binary search failed to return item(%d); index(%d)", 
					item, index), item, index);
		}
	}
	
	
	@Test
	public void testValuesBelowRange(){
		BinarySearchAlgorithm<Integer> binarySearch = new BinarySearchAlgorithm<>();
		Integer[] subject = new Integer[1000];
		Random randomizer = new Random();
		int index;
		int item;
		
		IntStream.range(0, 1000).forEachOrdered(n ->{subject[n] = n;});
		for(int times = 0; times < 500; times++){
			item = randomizer.nextInt(999) - 2000;
			index = binarySearch.search(item, subject);
			assertEquals(String.format(
					"Binary search for item(%d) returned index(%d) instead of -1", 
					item, index), -1, index);
		}
	}
	
	@Test
	public void testValuesAboveRange(){
		BinarySearchAlgorithm<Integer> binarySearch = new BinarySearchAlgorithm<>();
		Integer[] subject = new Integer[1000];
		Random randomizer = new Random();
		int index;
		int item;
		
		IntStream.range(0, 1000).forEachOrdered(n ->{subject[n] = n;});
		for(int times = 0; times < 500; times++){
			item = randomizer.nextInt(999) + 1000;
			index = binarySearch.search(item, subject);
			assertEquals(String.format(
					"Binary search for item(%d) returned index(%d) instead of -1", 
					item, index), -1, index);
		}
		
		
	}
	
	
	@Test
	public void testValueNotInSet(){
		BinarySearchAlgorithm<Integer> binarySearch = new BinarySearchAlgorithm<>();
		Integer[] subject = new Integer[1000];
		Random randomizer = new Random();
		int index;
		int item;
		
		IntStream.range(0, 1000).forEachOrdered(n ->{subject[n] = n * 2 + 1;});
		IntStream.range(0, 1000).forEachOrdered(n ->{logger.info(String.format("subject[%d] = %d;", n, subject[n]));});
		for(int times = 0; times < 500; times++){
			item = randomizer.nextInt(999) * 2;
			index = binarySearch.search(item, subject);
			assertEquals(String.format(
					"Binary search for item(%d) returned index(%d) instead of -1", 
					item, index), -1, index);
		}
		
		
	}

}
