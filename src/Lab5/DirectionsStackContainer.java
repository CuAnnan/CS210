package Lab5;


/**
 * Class to fulfil lab brief.
 */
public class DirectionsStackContainer
{
	/**
	 * A Stack for the directions;
	 */
//	ArrayStack<String> directions;
	StringArrayStack directions;
	
	/**
	 * Constructor
	 */
	public DirectionsStackContainer()
	{
//		directions = new ArrayStack<String>(100);
		directions = new StringArrayStack(100);
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
		// While we have a direction
		while(!directions.isEmpty())
		{
			// pop it and print it to the screen
			System.out.println(
				getReverse(directions.pop())
			);
		}
	}
	
	/**
	 * Add an instruction to the container. If the direction is one of the cardinal directions, add that to
	 * the stack. If it's "Go Back", we remove the last added direction. If it's "Arrived" we reverse the
	 * directions
	 * @param direction
	 */
	public void addInstruction(String direction)
	{
		switch(direction)
		{
			case "Go Back":
				directions.pop();
				break;
			case "Arrived":
				reverseDirections();
				break;
			default:
				directions.push(direction);
				break;
		}
	}
	
	public static void main(String args[])
	{
		
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
