package com.burton.wynne.hashtable;
import java.util.LinkedList;


public class Hashtable {
	private int numberOfKeys;
	private float keyToSizeRatio = 1.2f;
	private LinkedList<Entry> buckets[];
	private int size;
	
	{
		size = 0;
	}
	
	public Hashtable(int numberOfKeys){
		this.numberOfKeys = numberOfKeys;
		buckets = new LinkedList[ (int) (numberOfKeys * keyToSizeRatio) ];
		
	}
	
	public Hashtable(){
		this.numberOfKeys = 100;
		buckets = new LinkedList[ (int) (numberOfKeys * keyToSizeRatio) ];
	}
	
	public void add(Object key, Object value){
		Entry entry = new Entry(key, value);
		add(entry);
	}
	
	public void add(Entry entry){
		Object key = entry.getKey();
		int hashCode = key.hashCode();
		int mod = modula(hashCode);
		LinkedList<Entry> list = null;
		if(buckets[mod] == null){
			buckets[mod] = new LinkedList<Entry>();
		}
		list = buckets[mod];
		if(list.isEmpty()){
			list.add(entry);
			size++;
		}else{
			Entry foundEntry = findEntry(key, list);
			if(foundEntry != null){
				list.remove(foundEntry);
				size--;
			}
			list.add(entry);
			size++;
		}
	}
	
	public Entry find(Object key){
		return findEntry(key, getBucket(key));
	}
	
	public int size(){
		return size;
	}
	
	public Entry remove(Object key){
		Entry removedEntry = null;
		LinkedList<Entry> list = getBucket(key);
		if(list != null){
			removedEntry = findEntry(key, list);
			if(removedEntry != null){
				list.remove(removedEntry);
				size--;
			}
		}
		return removedEntry;
	}
	
	private Entry findEntry(Object key, LinkedList<Entry> list){
		Entry foundEntry = null;
		if(list != null){
			for(Entry listEntry : list) {
				if(key.equals(listEntry.getKey())){
					foundEntry = listEntry;
					break;
				}
			}
		}
		return foundEntry;
	}
	
	private int modula(int hashCode){
		int mod = hashCode % numberOfKeys;
		if(hashCode < 0 ){
			mod = numberOfKeys + mod;
		}
		return mod;
	}	
	
	private LinkedList<Entry> getBucket(Object key){
		int hashCode = key.hashCode();
		int mod = modula(hashCode);
		return buckets[mod];
	}	
}
