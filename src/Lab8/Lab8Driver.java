package Lab8;

import Lab7.Student;
import Lab7.Node;
import Lab7.Iterator;

public class Lab8Driver
{
	
	public static void populate(IntegrityLinkedList list)
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
	
	public static void createMalformation(IntegrityLinkedList list)
	{
		Iterator iterator = list.getIterator();
		
		for(int i = 0; i < 9; i++)
		{
			iterator.next();
		}
		
		
		System.out.println("Creating malformation at node with integrity check value "+((IntegrityNode)iterator.getCurrent()).getIntegrityCheck()+":");
		System.out.println(iterator.getCurrent().getStudent().toString());
		Node toMalform = iterator.getCurrent();
		iterator.reset();
		for(int i = 0; i < 4; i++)
		{
			iterator.next();
		}
		Node toMalformTo = iterator.getCurrent();
		
		toMalform.setNext(toMalformTo);
		System.out.println("Malforming to link to ");
		System.out.println(toMalformTo.getStudent().toString());
	}
	
	public static void findMalformationUsingIntegrityCheck(IntegrityLinkedList list)
	{
		IntegrityCheckResult result = list.performIntegrityCheck();
		if(result.hasPassed())
		{
			System.out.println("No malformation detected");
		}
		else
		{
			System.out.println("Malformation found at node with integrity check value "+(result.getNode().getIntegrityCheck())+":");
			System.out.println(result.getNode().getStudent().toString());
		}
	}
	
	public static void checkInsertBefore(IntegrityLinkedList l)
	{
		IntegrityIterator iter = l.getIterator();
		for(int i = 0; i < 5; i++)
		{
			iter.next();
		}
		iter.insertBeforeCurrent(
			new Student().setAge(67).setDegree("French").setYearOfStudy(2).setName("Francois")
		);

	}	
	
	public static void main(String[] args)
	{
		System.out.println("Test case");
		IntegrityLinkedList malformed = new IntegrityLinkedList();
		populate(malformed);
		malformed.debug();
		checkInsertBefore(malformed);
		
		malformed.debug();
//		createMalformation(malformed);
//		findMalformationUsingIntegrityCheck(malformed);
//		System.out.println();
//		
//		System.out.println("Control");
//		IntegrityLinkedList properlyFormed = new IntegrityLinkedList();
//		populate(properlyFormed);
//		findMalformationUsingIntegrityCheck(properlyFormed);
		
	}
}
