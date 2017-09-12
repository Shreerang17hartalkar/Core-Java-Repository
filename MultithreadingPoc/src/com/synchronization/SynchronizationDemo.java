/*
 * Java Program to show the synchronization effect on wish()method
 * 
 */
package com.synchronization;

class MyThread extends Thread {
	Display d;
	String name;

	MyThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}

	public void run() {

		d.wish(name);
	}
}

public class SynchronizationDemo {

	public static void main(String[] args) {
		Display d1 = new Display();
		MyThread t1 = new MyThread(d1, "Dhoni");
		MyThread t2 = new MyThread(d1, "Yuvraj");
		t1.start();
		t2.start();

	}

}
