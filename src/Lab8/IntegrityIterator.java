package Lab8;

import Lab7.Student;

public class IntegrityIterator extends Lab7.Iterator
{
	IntegrityNode current;
	IntegrityNode previous;
	IntegrityLinkedList list;
	
	public IntegrityIterator(IntegrityLinkedList list)
	{
		this.list = list;
		this.reset();
		// TODO Auto-generated constructor stub
	}
	
	public void reset()
	{
		this.previous = null;
		this.current = this.list.getHead();
	}
	
	public void next()
	{
		this.previous = this.current;
		this.current = this.current.getNext();
	}
	
	public IntegrityNode getCurrent()
	{
		return this.current;
	}

	
	public void insertBeforeCurrent(Student s)
	{
		if(this.current == list.getHead())
		{
			if(this.current.getIntegrityCheck() == 0)
			{
				this.list.updateIntegrityConstraints();
			}
			list.addToHead(s);
			 return;
		}
		if(this.current.getIntegrityCheck() - this.previous.getIntegrityCheck() == 1)
		{
			
			this.list.updateIntegrityConstraints();
		}
		
		IntegrityNode studentNode = new IntegrityNode(s, (this.previous.getIntegrityCheck() + this.current.getIntegrityCheck())/2);
		this.previous.setNext(studentNode);
		studentNode.setNext(this.current);
		this.current = studentNode;
	}
	
	public void updateIntegrityConstraints()
	{
		IntegrityNode first = (IntegrityNode)this.list.getHead();
	}
	
}
