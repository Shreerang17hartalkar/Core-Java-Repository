package com.poly;

class Parent {
	public void property() {
		System.out.println("Cash + Gold+ land");

	}

	public void marry() {
		System.out.println("Subbalaxmi");
	}
}

class Child extends Parent {
	public void marry() {
		System.out.println("Trisha");
	}
}

public class MethodOverriding {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.marry();// Parent Method
		Child c = new Child();
		c.marry();// Child Method
		Parent p1 = new Child();
		p1.marry();// Child method

	}
}