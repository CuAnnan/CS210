package Lab5;

public class DirectionsStackContainer
{
	ArrayStack<String> directions;
	
	
	
	public DirectionsStackContainer()
	{
		directions = new ArrayStack<String>(100);
	}
	
	public static String getReverse(String direction)
	{
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
	
	public void reverseDirections()
	{
		while(!directions.isEmpty())
		{
			System.out.println(
				getReverse(directions.pop())
			);
		}
	}
	
	public void addDirection(String direction)
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
	
	public void debug()
	{
		this.directions.debug();
	}
}
