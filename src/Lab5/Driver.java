package Lab5;

public class Driver
{
	public static void main(String[] args)
	{
		DirectionsStackContainer dc = new DirectionsStackContainer();
		String[] directionsSet = "Go North;Go North;Go West;Go Back;Go East;Go South;Go North;Go Back;Arrived".split(";");
		for(String direction: directionsSet)
		{
			dc.addInstruction(direction);
		}
		
	}
}
