package com.yield;

/**
 * Java Program to demonstrate yield()method
 * 
 * @author Shreerang Hartalkar
 */

class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Chid Thread");
		}
	}
}

public class ThreadYieldDemo {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		for (int i = 0; i < 10; i++) {
			Thread.yield();

			System.out.println("Main Thread");

		}
	}

}
