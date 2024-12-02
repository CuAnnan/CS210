package Lab8;

import Lab7.Student;
import Lab7.Node;
import Lab7.Iterator;
import Lab7.LinkedList;

public class Lab8Driver
{
    
    static String[] firstNames = {"Frank", "Aoife", "Larry", "Sean", "Mitchell", "Carlos", "Latitia", "Prue", "Ike", "Hotaru", "Kai", "Oscar", "Romeo", "Lisa", "Siobhan", "Naoise", "Stefany"};
    static String[] courses = {"CSSE", "CSSEA", "General Science", "General Arts", "Maths", "Physics", "Astrophysics", "Bioinformatics", "Engineering", "Business", "Education"};
    static String[] surnames = {"McNamara", "Ryan", "Carter", "Cunningham", "Nishino", "Franks", "Lewis"};
    
    
	
    public static void populate(LinkedList list)
	{
        for(int i = 0; i < 100; i++)
        {
            list.addToTail(
                new Student()
                    .setAge((int)(Math.random()*60 + 10))
                    .setDegree(courses[i%courses.length])
                    .setName(
                        firstNames[i%firstNames.length] + " "+surnames[i%surnames.length]
                    )
            );
        }
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
	
	public static void checkIntegritySequence(LinkedList l)
	{
	    Node current = l.getHead();
	    while(current != null)
	    {
	        System.out.print(current.getIntegrityValue()+", ");
	        current = current.getNext();
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
		LinkedList control = new LinkedList();
		populate(control);
		found = findMalformationUsingIntegrityCheck(control);
		if(found != null)
		{
		    System.out.println("Control found a malformation at node "+found.getIntegrityValue()+":");
            System.out.println(found.getStudent().toString());
		}
		else
		{
		    System.out.println("No malformation found");
		    checkIntegritySequence(control);
		}
		
	}
}
