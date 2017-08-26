package com.poly;

class Animal {

}

class Monkey extends Animal {

}

public class MethodOverloading {
	public void m1(Animal a) {
		System.out.println("Animal Version...");

	}

	public void m1(Monkey m) {
		System.out.println("Monkey Version...");
	}

	public static void main(String[] args) {

		MethodOverloading movld = new MethodOverloading();
		Animal a = new Animal();
		movld.m1(a);// Animal Version

		Monkey m = new Monkey();
		movld.m1(m);// monkey version
		Animal a1 = new Monkey();
		movld.m1(a1);/*
					 * Animal version.In Overloading method resolution always
					 * takes care by comipler based on reference type
					 */

	}

}
