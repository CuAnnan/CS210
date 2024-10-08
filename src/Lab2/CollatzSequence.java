package Lab2;


/**
 * A class to encapsulate the Collatz Sequence for a given number.
 * @see https://en.wikipedia.org/wiki/Collatz_conjecture
 * 
 * This is essentially a specialized Linked List which self populates given an
 * initial value used to determine the Collatz Sequence for that value
 * @author Eamonn "Wing" Kearns
 */
public class CollatzSequence
{
	/**
	 * A node for the first entry
	 */
	CollatzNode start;
	/**
	 * A node for the last entry. This is the node that gets nodes added to it.
	 */
	CollatzNode end;
	/**
	 * This is the number of steps and or the size of the linked list
	 */
	int steps = 0;
	/**
	 * This is used to prevent double resolution and wasting clock cycles
	 */
	boolean resolved = false;
	
	/**
	 * Dummy constructor, uses Student Number
	 */
	public CollatzSequence()
	{
		this(60460770);
	}
	
	/**
	 * The workhorse Constructor. But all it does is set the initial values for 
	 * the start node and end node
	 * @param number The number to start the Collatz Sequence with.
	 */
	public CollatzSequence(int number)
	{
		this.start = new CollatzNode(number);
		this.end = this.start;
	}
	
	/**
	 * Add a result to the Collatz Sequence Linked List thing
	 * @param number the value of the next number in the sequence
	 * @return Returns a reference to this instance
	 */
	public CollatzSequence addResult(int number)
	{
		CollatzNode next = new CollatzNode(number);
		this.end.setNext(next);
		this.end = next;
		this.steps++;
		return this;
	}
	
	/**
	 * A method to resolve the Collatz Sequence by doing the multiplication
	 * and division.
	 * @return
	 */
	public CollatzSequence resolve()
	{
		// Only does the work if it hasn't been done already
		if(!this.resolved)
		{
			int nextValue;
			do
			{
				// get the current node's value
				int currentValue = this.end.getValue();
				// do the mathy bit
				nextValue = currentValue %2 == 0?currentValue/2:currentValue * 3 + 1;
				// add the result
				this.addResult(nextValue);
				// terminate if the new nextValue is 1
			}while(nextValue != 1);
			// set resolved to true so that the work doesn't repeat if asked
			this.resolved = true;
		}
		
		return this;
	}
	
	/**
	 * A method to print out the value of the Sequence.
	 */
	public void print()
	{
		// resolve it if needed
		this.resolve();
		
		// Print out some basic info
		System.out.println("The Collatz Sequence for "+this.start.getValue()+"\nSteps: "+this.steps);
		
		// print out the values with a loop
		String out = "Values:\t"+this.start.getValue()+", ";
		CollatzNode current = this.start;
		do
		{
			current = current.getNext();
			out += current.getValue();
			// add the next comma if it's needed
			if(current.hasNext())
			{
				out +=", ";
			}
			// add some wrapping
			if(out.length() > 100)
			{
				System.out.println(out);
				out = "\t";
			}
		}while(current.hasNext());
		
		System.out.println(out);
		
	}
	
}
