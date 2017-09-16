/**
    Java Program to insert String abject into the Treeset where sorting
    order is reverse of alphabetical order
 * 
 */
package com.treeset;

import java.util.TreeSet;

/**
 * Shreerang Hartalkar
 *
 */
public class TreeSetDemo1 {

	public static void main(String[] args) {

		TreeSet t = new TreeSet(new MyComparator1());
		t.add("Roja");
		t.add("Sobharani");
		t.add("Rajakumari");
		t.add("Gangabhavani");
		t.add("Trisha");
		System.out.println(t);

	}

}
