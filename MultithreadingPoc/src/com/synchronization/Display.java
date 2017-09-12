package com.synchronization;

class Display {
	public synchronized void wish(String name) {
		for (int i = 0; i <= 10; i++) {
			System.out.println("Good Morning: ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.print(e);
			}
			System.out.println(name);
		}

	}
}
