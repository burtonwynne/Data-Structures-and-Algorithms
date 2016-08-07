package com.codejock.algorithms.search;

import java.util.logging.Logger;

public class BinarySearchAlgorithm<T extends Comparable<T>> {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	public int search(T item, T[] list){
		return search2(item, list, 0, list.length - 1);
	}
	
	public int search2(T item, T[] list, int start, int end){
		
		if(start > end){
			return -1;
		}
		
		
		int median = (end - start)/2 + start;
		
		/*
		logger.info(String.format("item(%d) start(%d).value(%d) "
				+ "end(%d).value(%d) median(%d).value(%d)", item, start, list[start], 
				end, list[end], median, list[median])); 
				*/
		if(item.equals(list[median])){
			return median;
		}else if(start == end){
			return -1;
		}else if(item.compareTo(list[median]) > 0){
			if(median <= (list.length - 1)){
				return search2(item, list, median + 1, end);
			}else{
				return -1;
			}
		}else{
			if(median > 0){
				return search2(item, list, start, median -1);
			}else{
				return -1;
			}
		}
	}
	
}
