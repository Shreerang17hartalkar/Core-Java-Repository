package com.throwsclausedemo;

import java.util.Scanner;

public class ThrowClause {
	// Throw Exception if num1 is greater than 1000
	static int add(int num1, int num2) {
		if (num1 > 1000) {
			throw new ArithmeticException("Num1 should be less than 1000");

		} else {
			System.out.println("Both nos are correct!!!");
		}
		return num1 + num2;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number1: ");
		int num1 = scanner.nextInt();
		System.out.println("Enter number2: ");
		int num2 = scanner.nextInt();
		int result = add(num1, num2);
		System.out.println("Addition result is :" + result);

	}

}
