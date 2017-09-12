/*
 * Java Program to show the how Executor framework works.
 * We have created 3 thread in Thread Pool who are executing 6 jobs,
 * so one thread can handle multiple jobs
 * 
 */
package com.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Shreerang
 *
 */

class PrintJob implements Runnable {
	String name;

	PrintJob(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println(name + "...Job Started by Thread: " + Thread.currentThread().getName());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println(name + "...Job Completed by Thread: " + Thread.currentThread().getName());

	}
}

public class ExecutorDemo {

	public static void main(String[] args) {
		PrintJob[] jobs = { new PrintJob("Shree"), new PrintJob("Ravi"), new PrintJob("Shiva"), new PrintJob("Pavan"),
				new PrintJob("Suresh"), new PrintJob("Anil") };
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
	}

}
