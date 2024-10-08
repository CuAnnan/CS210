package Lab2;

public class CollatzNode
{
	int value;
	CollatzNode next = null;
	
	public CollatzNode(int value)
	{
		this.value = value;
	}
	
	public CollatzNode setNext(CollatzNode next)
	{
		this.next= next;
		return this;
	}
	
	public boolean hasNext()
	{
		return this.next != null;
	}
	
	public CollatzNode getNext()
	{
		return this.next;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
