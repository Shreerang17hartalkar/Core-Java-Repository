/**
  Java Program to demonstrate join()method.Main thread will wait
 * until the execution of child thread
 */
package com.join;

/**
 * @Shreerang
 * 
 */

class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Sita Thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}

public class ThreadJoinDemo {
	public static void main(String[] args) throws InterruptedException {

		MyThread t = new MyThread();
		t.start();
		t.join();
		for (int i = 0; i < 10; i++) {
			System.out.println("Rama Thread");
		}
	}

}
