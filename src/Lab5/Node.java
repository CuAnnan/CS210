package Lab5;

public class Node
{
	String contents;
	Node next;
	
	public Node(String contents)
	{
		this.contents = contents;
		this.next = null;
	}
	
	public boolean hasNext()
	{
		return this.next != null;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Node getNext()
	{
		return this.next;
	}
}