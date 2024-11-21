package Lab6;

import java.util.Scanner;


public class LabDriver
{
   
	
	
    public static Scanner getScanner(boolean useDefault)
    {
        if(useDefault)
        {
            return new Scanner("13\n17\n19\n31\n62\n13\n78\n8\n1\nremove\n25\nremove");
        }
        return new Scanner(System.in);
    }
    
	public static void main(String[] args)
	{
	    Scanner sc = getScanner(true);
	    String input = sc.nextLine();
	    
	    IntegerPriorityQueue queue = new IntegerPriorityQueue(Integer.parseInt(input));
	    int lastAdded = -1;
	    
	    while(sc.hasNext())
	    {
	    	input = sc.nextLine().toLowerCase();
	    	switch(input)
	    	{
	    		case "remove":
	    			int toRemove = queue.remove();
	    			toRemove = lastAdded + 1;
	    			lastAdded = toRemove;
	    			queue.insert(lastAdded);
	    			break;
	    		default:
	    			int toAdd = Integer.parseInt(input);
	    			if(lastAdded < toAdd)
	    			{
	    				lastAdded = toAdd;
	    			}
	    			queue.insert(toAdd);
	    			break;
	    	}
	    }
	    queue.debug();
	    
	    sc.close();
	}
}
