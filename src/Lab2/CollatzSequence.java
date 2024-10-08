package Lab2;


public class CollatzSequence
{
	CollatzNode start;
	CollatzNode end;
	int steps = 0;
	boolean resolved = false;
	
	public CollatzSequence()
	{
		this(60460770);
	}
	
	public CollatzSequence(int number)
	{
		this.start = new CollatzNode(number);
		this.end = this.start;
	}
	
	public CollatzSequence addResult(int number)
	{
		CollatzNode next = new CollatzNode(number);
		this.end.setNext(next);
		this.end = next;
		this.steps++;
		return this;
	}
	
	public CollatzSequence resolve()
	{
		if(!this.resolved)
		{
			int nextValue;
			do
			{
				int currentValue = this.end.getValue();
				nextValue = currentValue %2 == 0?currentValue/2:currentValue * 3 + 1;
				this.addResult(nextValue);
				
			}while(nextValue != 1);
			
			this.resolved = true;
		}
		
		return this;
	}
	
	public void print()
	{
		System.out.println("The Collatz Sequence for "+this.start.getValue()+"\nSteps: "+this.steps);
		
		String out = "Values:\t"+this.start.getValue()+", ";
		CollatzNode current = this.start;
		do
		{
			current = current.getNext();
			out += current.getValue();
			if(current.hasNext())
			{
				out +=", ";
			}
			if(out.length() > 100)
			{
				System.out.println(out);
				out = "\t";
			}
		}while(current.hasNext());
		
		System.out.println(out);
		
	}
	
}
