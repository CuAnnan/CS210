package Lab8;

import Lab7.Student;
import Lab7.Node;
import Lab7.Iterator;
import Lab7.LinkedList;

public class Lab8Driver
{
	
	public static void populate(LinkedList list)
	{
		list.addToTail(
			new Student().setAge(26).setDegree("CSSE").setYearOfStudy(2).setName("Bunny")
		);
		list.addToTail(
			new Student().setAge(18).setDegree("ARTS").setYearOfStudy(1).setName("Larry")
		);
		list.addToTail(
			new Student().setAge(32).setDegree("Computational Thinking").setYearOfStudy(4).setName("Steve")
		);
		list.addToTail(
			new Student().setAge(19).setDegree("ARTS").setYearOfStudy(5).setName("Frances")
		);
		list.addToTail(
			new Student().setAge(23).setDegree("CSSE").setYearOfStudy(3).setName("Carl")
		);
		list.addToTail(
			new Student().setAge(36).setDegree("Arts").setYearOfStudy(3).setName("Carly")
		);
		list.addToTail(
				new Student().setAge(26).setDegree("CSSE").setYearOfStudy(2).setName("Bunny")
		);
		list.addToTail(
			new Student().setAge(18).setDegree("ARTS").setYearOfStudy(1).setName("Larry")
		);
		list.addToTail(
			new Student().setAge(32).setDegree("Computational Thinking").setYearOfStudy(4).setName("Steve")
		);
		list.addToTail(
			new Student().setAge(19).setDegree("ARTS").setYearOfStudy(5).setName("Frances")
		);
		list.addToTail(
			new Student().setAge(23).setDegree("CSSE").setYearOfStudy(3).setName("Carl")
		);
		list.addToTail(
			new Student().setAge(36).setDegree("Arts").setYearOfStudy(3).setName("Carly")
		);
		
	}
	
	public static void createMalformation(LinkedList list)
	{
		Iterator iterator = list.getIterator();
		
		for(int i = 0; i < 9; i++)
		{
			iterator.next();
		}
		
		
		Node toMalform = iterator.getCurrent();
		System.out.println("Malforming from node "+toMalform.getIntegrityValue()+":");
		System.out.println(toMalform.getStudent().toString());
		iterator.reset();
		for(int i = 0; i < 4; i++)
		{
			iterator.next();
		}
		
		Node toMalformTo = iterator.getCurrent();
		System.out.println("To node "+toMalformTo.getIntegrityValue()+":");
		System.out.println(toMalformTo.getStudent().toString());
		toMalform.setNext(toMalformTo);
	}
	
	public static Node findMalformationUsingIntegrityCheck(LinkedList list)
	{
		return list.findMalformedNode();
	}
	
	public static void checkInsertBefore(LinkedList l)
	{
		Iterator iter = l.getIterator();
		for(int i = 0; i < 5; i++)
		{
			iter.next();
		}
		iter.insertBeforeCurrent(
			new Student().setAge(67).setDegree("French").setYearOfStudy(2).setName("Francois")
		);
	}
	
	public static void checkIntegritySequence(LinkedList l)
	{
	    Iterator iter = l.getIterator();
	    Node current = iter.getCurrent();
	    while(current != null)
	    {
	        
	    }
	}
	
	public static void main(String[] args)
	{
		System.out.println("Test case");
		LinkedList malformed = new LinkedList();
		populate(malformed);
		
		createMalformation(malformed);
		Node found = findMalformationUsingIntegrityCheck(malformed);
		if(found != null)
		{
		    System.out.println("Malformation found at node "+found.getIntegrityValue()+":");
		    System.out.println(found.getStudent().toString());
		}
		System.out.println();
		
		System.out.println("Control");
		LinkedList properlyFormed = new LinkedList();
		populate(properlyFormed);
		found = findMalformationUsingIntegrityCheck(properlyFormed);
		if(found != null)
		{
		    System.out.println("Control found a malformation at node "+found.getIntegrityValue()+":");
            System.out.println(found.getStudent().toString());
		}
		else
		{
		    System.out.println("No malformation found");
		}
		
	}
}
