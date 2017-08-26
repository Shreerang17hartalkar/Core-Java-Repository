package com.inhc;

public class Test {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.m1();
		// p.m2();//compilation error

		Child c = new Child();
		c.m1();
		c.m2();
		Parent p1 = new Child();
		p1.m1();
		// p1.m2();Compilation Error

		// Child c1 = new Parent(); //C.Error

	}

}
