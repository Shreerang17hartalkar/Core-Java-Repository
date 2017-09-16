package com.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arrayList.add(i);
		}
		System.out.println(arrayList);
		Iterator itr = arrayList.iterator();
		while (itr.hasNext()) {
			Integer i = (Integer) itr.next();
			if (i % 2 == 0)
				System.out.println(i);
			else
				itr.remove();
		}
		System.out.println(arrayList);

	}

}
