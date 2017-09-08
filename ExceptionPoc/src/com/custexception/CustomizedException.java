package com.custexception;

class InvalidAgeException extends RuntimeException {
	InvalidAgeException(String s) {
		super(s);
	}
}

public class CustomizedException {

	static void validate(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("Your age is not valid to vote");
		} else {
			System.out.println("Welcome to voting");
		}

	}

	public static void main(String[] args) {
		validate(13);
	}
}
