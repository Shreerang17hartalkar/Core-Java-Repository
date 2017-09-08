package com.returnfinallystatement;

public class Test {
	public static void main(String[] args) {
		// finally Block return statement will get more
		// priority than try-catch return statement
		System.out.println(m1());
	}

	public static int m1() {
		try {
			return 777;
		} catch (Exception e) {
			return 888;
		} finally {
			return 999;
		}
	}

}
