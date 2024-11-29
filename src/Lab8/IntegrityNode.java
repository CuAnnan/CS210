package Lab8;

import Lab7.Node;
import Lab7.Student;

public class IntegrityNode extends Node
{
	int integrityCheck = -1;
	IntegrityNode next;
	
	public IntegrityNode(Student s, int integrityCheck)
	{
		super(s);
		this.integrityCheck = integrityCheck;
	}
	
	public void setIntegrityCheck(int n)
	{
		this.integrityCheck = n;
	}
	
	public int getIntegrityCheck()
	{
		return this.integrityCheck;
	}
	
	public IntegrityNode getNext()
	{
		return (IntegrityNode)super.getNext();
	}
	
	public void setNext(IntegrityNode next)
	{
		this.next = next;
	}
	
	public boolean hasNext()
	{
		return this.getNext()!= null;
	}
}
