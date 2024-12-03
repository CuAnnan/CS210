package Lab7;

public class Node
{
	// had to do this to make it all "work"
	public Node next;
	Node previous;
	Student student;
	int integrityValue;
	
	public Node(Student student)
	{
		this.student = student;
	}
	
	public void setIntegrityValue(int integrityValue)
	{
	    this.integrityValue = integrityValue;
	}
	
	public int getIntegrityValue()
	{
	    return this.integrityValue;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
		if(next != null)
		{
			next.previous = this;
		}
	}
	
	public boolean hasNext()
	{
		return this.next != null;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public void setPrevious(Node previous)
	{
		this.previous = previous;
		if(previous != null)
		{
			previous.next = this;
		}
	}
	
	public boolean hasPrevious()
	{
		return this.previous != null;
	}
	
	public Node getPrevious()
	{
		return this.previous;
	}
	
	public Student getStudent()
	{
		return this.student;
	}
}