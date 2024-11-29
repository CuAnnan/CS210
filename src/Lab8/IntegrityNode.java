package Lab8;

import Lab7.Node;
import Lab7.Student;

public class IntegrityNode extends Node
{
	int integrityCheck = -1;
	
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
}
