package com.throwsclausedemo;

import java.util.Scanner;

public class ThrowsClauseDemo 
{
	//Throws Exception if any no is divided by 0
	static int divide(int num1,int num2)throws ArithmeticException
	{
		int result = num1/num2;
		return result;
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 1 : ");
        int num1 = scanner.nextInt();
        System.out.println("Enter number 2 : ");
        int num2 = scanner.nextInt();
        int result=divide(num1,num2);
        System.out.println("Result is : "+result);

	}

}
