package com.burton.wynne.hashtable;

public class Entry {
	private Object key;
	private Object value;
	
	public Entry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}
	
	@Override
	public String toString(){
		return "key: " + key + " value: " + value;
	}
	
	
}
