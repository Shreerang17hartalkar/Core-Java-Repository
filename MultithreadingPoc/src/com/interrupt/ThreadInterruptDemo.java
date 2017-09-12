package com.interrupt;

class MyThread extends Thread {
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("I am lazy thread");
				Thread.sleep(5000);
			}
		} catch (InterruptedException ie) {
			System.out.println("I got interrupted");
		}
	}
}

public class ThreadInterruptDemo {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		t.interrupt();
	}

}
