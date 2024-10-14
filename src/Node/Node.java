package Node;

public class Node
{
	int value;
	public Node next;
	
	public Node(int value)
	{
		this.value = value;
	}
	
	public Node setNext(Node next)
	{
		this.next = next;
		return this;
	}
	
	public boolean hasNext()
	{
		return this.next != null;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
