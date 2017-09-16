package com.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("Chiranjivi", 700);
		hashMap.put("Balaiah", 800);
		hashMap.put("Nagarjuna", 900);
		hashMap.put("Venkatesh", 1000);
		System.out.println(hashMap);

		Set s = hashMap.keySet();
		System.out.println(s);

		Collection c = hashMap.values();
		System.out.println(c);

		Set s1 = hashMap.entrySet();
		System.out.println(s1);

		Iterator itr = s1.iterator();
		while (itr.hasNext()) {
			Map.Entry m1 = (Map.Entry) itr.next();
			System.out.println(m1.getKey() + "...." + m1.getValue());
			if (m1.getKey().equals("Nagarjuna"))
				m1.setValue(2000);
		}

		System.out.println(hashMap);

	}

}
