/*
 * Java Program showing how to avoid syncrhonized by using ReentrantLock class
 * and its lock()method
 * 
 */
package com.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shreerang Hartalkar
 *
 */
class Display
{
	ReentrantLock l = new ReentrantLock();

	public void wish(String name)
	{
		l.lock();

		for(int i=0;i<10;i++)
		{
			System.out.println("Good Morning: ");
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			System.out.println(name);
		}
		 l.unlock();
	}
}
class MyThread extends Thread
{
	Display d;
	String name;
	public MyThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	public void run()
	{
		d.wish(name);
	}
	
}
public class ReentrantLock2 {

	public static void main(String[] args) {

		Display d = new Display();
		MyThread t1 = new MyThread(d,"Dhoni");
		MyThread t2 = new MyThread(d,"Yuvraj");
		MyThread t3 = new MyThread(d,"Kohli");
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
