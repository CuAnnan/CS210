package Lab6;

import java.util.Scanner;

public class LabDriver
{
   
    public static Scanner getScanner(boolean useDefault)
    {
        if(useDefault)
        {
            return new Scanner("13 17 19 31 62 13 78 8 1 remove 3 1 79 12 remove 9 19 91 152");
        }
        return new Scanner(System.in);
    }
    
	public static void main(String[] args)
	{
	    Scanner scSysIn = getScanner(true);
	    String input = scSysIn.nextLine();
	    String[] parts = input.split(" ");
	    
	    IntegerPriorityQueue example = new IntegerPriorityQueue(Integer.parseInt(parts[0]));
	    IntegerPriorityQueue exampleReversed = new IntegerPriorityQueue(Integer.parseInt(parts[0]), false);
	    
	    for(int i = 1; i < parts.length; i++)
	    {
	        switch(parts[i].toLowerCase())
	        {
	            case "remove":
	                example.remove();
	                exampleReversed.remove();
	                break;
                default:
                    example.insert(Integer.parseInt(parts[i]));
                    exampleReversed.insert(Integer.parseInt(parts[i]));
                    break;
	        }
	    }
	    example.debug();
	    exampleReversed.debug();
	    
	    scSysIn.close();
	}
}
