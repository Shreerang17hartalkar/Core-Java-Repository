package com.lstiterator;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

	public static void main(String[] args) 
	{
		List<String> l = new LinkedList<String>();
		l.add("sai");
		l.add("praval");
		l.add("sairam");
		l.add("srisai");
		System.out.println(l);
		ListIterator itr = l.listIterator();
		while(itr.hasNext())
		{
			String s = (String) itr.next();
	
			if(s.equals("praval"))
			{
				itr.remove();
			}
		}
		System.out.println(l);
  
	}

}
