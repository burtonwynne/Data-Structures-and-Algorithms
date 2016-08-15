package com.burton.wynne.algorithms.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.codejock.algorithms.hashtable.Entry;
import com.codejock.algorithms.hashtable.Hashtable;

public class HashtableTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Hashtable hashtable = new Hashtable(20);
		hashtable.add("one", "1");
		hashtable.add("two", "2");
		hashtable.add("three", "3");
		hashtable.add("five", "5");
		hashtable.add("four", "4");
		
		assertEquals("Expect size: 5.  Actual Hashtable size:" + hashtable.size(), 5,  hashtable.size());
		Entry four = hashtable.find("four");
		
		assertNotNull("Hashtable entry 'four' is null", four);
		assertEquals("Expected Entry to hold value: 'four' but got '" + four.getValue() + "' instead.",  "four", (String) four.getValue());
		hashtable.add("four", "yon");
		four = hashtable.find("four");
		assertEquals("Expected Entry to hold value: 'yon' but got '" + four.getValue() + "' instead.",  "yon", (String) four.getValue());
		hashtable.remove("four");
		four = hashtable.find("four");
		assertNull("Hashtable entry 'four' not null!", four);
		assertEquals("Expect size: 4.  Actual Hashtable size:" + hashtable.size(), 4,  hashtable.size());
	}

}
