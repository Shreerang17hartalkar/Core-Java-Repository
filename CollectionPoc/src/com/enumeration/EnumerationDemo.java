package com.enumeration;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {
	public static void main(String[] args) {

		Vector<Integer> vector = new Vector<Integer>();

		for (int i = 0; i < 10; i++) {
			vector.addElement(i);
		}

		Enumeration enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			Integer i = (Integer) enumeration.nextElement();
			if (i % 2 == 0) {
				System.out.println(i);
			}

		}
		System.out.println(vector);

	}
}