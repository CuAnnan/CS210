package Lab7;

import java.util.Scanner;

public class LabDriver
{
	static LinkedList l;
	static Iterator i;
	static Scanner sc;
	static String key;
	static String value;
	
	public static void printList()
	{
		Iterator i = l.getIterator();
		
		while(i.hasNext())
		{
			Student s = i.getNext().getStudent();
			System.out.println(s.toString());
		}
	}
	
	
	public static void populate()
	{
		l.addToTail(
			new Student().setAge(26).setDegree("CSSE").setYearOfStudy(2).setName("Bunny")
		);
		l.addToTail(
			new Student().setAge(18).setDegree("ARTS").setYearOfStudy(1).setName("Larry")
		);
		l.addToTail(
			new Student().setAge(32).setDegree("Computational Thinking").setYearOfStudy(4).setName("Steve")
		);
		i = l.getIterator();
	}
	
	public static boolean searchForStudent(String key, String value)
	{
		System.out.println(key +" "+ value);
		key = key.toLowerCase();
		value = value.toLowerCase();
		Student s = null;
		boolean found = false;
		while(!found && i.hasNext())
		{
			s = i.getNext().getStudent();
			switch(key)
			{
				case "name":
					found = s.getName().toLowerCase().equals(value);
					break;
				case "age":
					found = s.getAge() == Integer.parseInt(value);
					break;
				case "degree":
					found = s.getDegree().toLowerCase().equals(value);
					break;
				case "yearofstudy":
					found = s.getYearOfStudy() == Integer.parseInt(value);
					break;
			}
		}
		return found;
		
	}
	
	public static void removeStudent()
	{
		i.removeCurrent();
	}
	
	public static void printCurrentStudent()
	{
		System.out.println(i.getCurrentStudent().toString());
	}
	
	public static void operate()
	{
		String input = "EOM";
		boolean enteringKey = false;
		
		
		while(!input.equals(""))
		{
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
		System.out.println("Done");
	}
	
	
	public static void main(String[] args)
	{
		sc = new Scanner(System.in);
		
		l = new LinkedList();
		populate();
		operate();
		
		sc.close();
	}
}
