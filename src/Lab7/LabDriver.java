package Lab7;

import java.util.Scanner;

public class LabDriver
{
	static LinkedList linkedList;
	static Iterator iterator;
	static Scanner sc;
	static String key;
	static String value;
	
	public static void printList()
	{
		Iterator i = linkedList.getIterator();
		
		while(i.hasNext())
		{
			Student s = i.getCurrentStudent();
			System.out.println(s.toString());
			i.next();
		}
	}
	
	
	public static void populate()
	{
		linkedList.addToTail(
			new Student().setAge(26).setDegree("CSSE").setYearOfStudy(2).setName("Bunny")
		);
		linkedList.addToTail(
			new Student().setAge(18).setDegree("ARTS").setYearOfStudy(1).setName("Larry")
		);
		linkedList.addToTail(
			new Student().setAge(32).setDegree("Computational Thinking").setYearOfStudy(4).setName("Steve")
		);
		iterator = linkedList.getIterator();
	}
	
	public static boolean searchForStudent(String key, String value)
	{
		key = key.toLowerCase();
		value = value.toLowerCase();
		Student s = null;
		boolean found = false;
		while(!found && iterator.hasNext())
		{
			s = iterator.getCurrent().getStudent();
			switch(key)
			{
				case "name":
					found = s.getName().toLowerCase().equals(value.toLowerCase());
					break;
				case "age":
					found = s.getAge() == Integer.parseInt(value);
					break;
				case "degree":
					found = s.getDegree().toLowerCase().equals(value.toLowerCase());
					break;
				case "yearofstudy":
					found = s.getYearOfStudy() == Integer.parseInt(value);
					break;
			}
			if(!found)
			{
				iterator.next();
			}
		}
		return found;
		
	}
	
	public static void removeStudent()
	{
		iterator.removeCurrent();
	}
	
	public static void printCurrentStudent()
	{
		System.out.println(iterator.getCurrentStudent().toString());
	}
	
	public static void addNewLink()
	{
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter course: ");
		String course = sc.nextLine();
		System.out.print("Enter age: ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("Enter year of study: ");
		int yearOfStudy = Integer.parseInt(sc.nextLine());
		System.out.print("Enter position to insert at: ");
		int listPosition = Integer.parseInt(sc.nextLine());
		System.out.println(listPosition+", "+linkedList.getLength());
		
		if(listPosition > linkedList.getLength())
		{
			System.out.println("Position out of bounds");
			return;
		}
		Student s = new Student().setName(name).setDegree(course).setAge(age).setYearOfStudy(yearOfStudy);
		iterator.reset();
		for(int i = 1; i <  listPosition; i++)
		{
			iterator.next();
		}
		iterator.insertBeforeCurrent(s);
	}
	
	public static void operate()
	{
		String input = "EOM";
		boolean enteringKey = false;
		
		
		while(!input.equals(""))
		{
			System.out.print("Enter input: ");
			input = sc.nextLine();
			switch(input)
			{
				case "print":
					searchForStudent(key, value);
					printCurrentStudent();
					break;
				case "printlist":
					printList();
					break;
				case "remove":
					searchForStudent(key, value);
					removeStudent();
					break;
				case "new link":
					addNewLink();
					break;
				case "": break;
				default:
					enteringKey = !enteringKey;
					if(enteringKey)
					{
						key = input;
					}
					else
					{
						value = input;
					}
					break;
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		
		
		linkedList = new LinkedList();
		populate();
		operate();
		
		sc.close();
	}
}
