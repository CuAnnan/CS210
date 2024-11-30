package Lab7;

public class Node
{
	Node next;
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
	}
	
	public boolean hasNext()
	{
		return this.next != null;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public Student getStudent()
	{
		return this.student;
	}
}