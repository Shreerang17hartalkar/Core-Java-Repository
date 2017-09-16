package com.treeset;

import java.util.TreeSet;

public class TreeSetDemo3 {

	public static void main(String[] args) {
		TreeSet t = new TreeSet(new MyComparator2());
		t.add("A");
		t.add("XX");
		t.add("ABCD");
		t.add("A");
		t.add(new StringBuffer("ABC"));
		t.add(new StringBuffer("AA"));
		System.out.println(t);

	}

}
