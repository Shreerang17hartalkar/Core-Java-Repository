package com.treeset;

import java.util.Comparator;

public class MyComparator1 implements Comparator {
	public int compare(Object obj1, Object obj2) {
		String s1 = (String) obj1;
		String s2 = (String) obj2;
		return -s1.compareTo(s2);
	}

}
