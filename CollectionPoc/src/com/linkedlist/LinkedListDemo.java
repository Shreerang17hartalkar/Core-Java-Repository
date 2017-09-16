package com.linkedlist;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList linkList = new LinkedList();
		linkList.add("shree");
		linkList.add(8);
		linkList.add("shree");
		linkList.add(null);

		System.out.println(linkList);

		linkList.set(0, "Java");
		linkList.removeLast();

		System.out.println(linkList);

	}

}
