package Lab5;

import java.util.Scanner;


/**
 * Class to fulfil lab brief.
 */
public class Lab5Driver
{
	/**
	 * A Stack for the directions;
	 */
//	ArrayStack<String> directions;
	StringArrayStack directions;
	
	StringArrayQueue directionsIn;
	
	/**
	 * Constructor
	 */
	public Lab5Driver()
	{
//		directions = new ArrayStack<String>(100);
		directions = new StringArrayStack(100);
		directionsIn = new StringArrayQueue(100);
	}
	
	/**
	 * A static method to get the reverse direction for a given direction
	 * @param direction The direction to reverse
	 * @return			The reverse of that direction
	 */
	public static String getReverse(String direction)
	{
		// assume that we're reversing south and override as necessary.
		String reverse = "Go North";
		switch(direction.toLowerCase())
		{
			case "go north":
				reverse = "Go South";
				break;
			case "go west":
				reverse = "Go East";
				break;
			case "go east":
				reverse = "Go West";
				break;
		}
		return reverse;
	}
	
	/**
	 * Print out the reverse of the directions by popping each element of the directions and reversing it.
	 */
	public void reverseDirections()
	{
		System.out.println("In:\t\tOut:");
		// While we have a direction
		while(!directions.isEmpty())
		{
			System.out.print(
				String.format("%-8s", directionsIn.removeFromFront())+"\t"
			);
			// pop it and print it to the screen
			System.out.println(
				getReverse(directions.pop())
			);
		}
	}
	
	/**
	 * Add an instruction to the container. If the direction is one of the cardinal directions, add that to
	 * the stack. If it's "Go Back", we remove the last added direction. If it's "Arrived" we print the
	 * reversed directions
	 * @param direction
	 */
	public void addInstruction(String direction)
	{
		switch(direction)
		{
			case "Go Back":
				directionsIn.removeFromRear();
				directions.pop();
				break;
			case "Arrived":
				reverseDirections();
				break;
			default:
				directionsIn.add(direction);
				directions.push(direction);
				break;
		}
	}
	
	public static Scanner getScanner(boolean useSimple)
	{
		Scanner sc;
		if(useSimple)
		{
			String directions = "Go South\nGo North\nGo West\nGo East\nGo West\nGo Back\nGo North\nGo North\nArrived";
			sc = new Scanner(directions);			
		}
		else
		{
			sc = new Scanner(System.in);
		}
		return sc;
	}
	
	/**
	 * Main method
	 */
	public static void main(String args[])
	{
		Lab5Driver driver = new Lab5Driver();
		
		String direction;
		Scanner sc = getScanner(true);
		do
		{
			direction = sc.nextLine();
			driver.addInstruction(direction);
		}while(direction!="Arrived" && sc.hasNextLine());
		sc.close();
	}
	
	/**
	 * A debug method for helping to test the driver class in the case of unanticipated behaviour.
	 * 
	 */
	public void debug()
	{
		this.directions.debug();
	}
}
