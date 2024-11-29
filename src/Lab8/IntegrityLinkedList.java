package Lab8;

import Lab7.Iterator;
import Lab7.LinkedList;
import Lab7.Student;

public class IntegrityLinkedList extends LinkedList
{
	public void addToHead(Student s)
	{
		IntegrityNode n;
		if(this.getLength() > 0)
		{
			if(this.getHead().getIntegrityCheck() == 0)
			{
				this.updateIntegrityConstraints();
			}
			n = new IntegrityNode(s, this.getHead().getIntegrityCheck() / 2);
		}
		else
		{
			n = new IntegrityNode(s, 10);
		}
		
		super.addToHead(n);
	}
	
	public IntegrityIterator getIterator()
	{
		return new IntegrityIterator(this);
	}
	
	public void addToTail(Student s)
	{
		IntegrityNode n = new IntegrityNode(s, (this.getLength( )+ 1) * 10);
		super.addToTail(n);
	}
	
	public IntegrityNode getHead()
	{
		return (IntegrityNode)super.getHead();
	}
	
	/**
	 * This doesn't check the last node, but if the last node doesn't link to another node, which is what would happen if not hasNext
	 * there is no loop
	 * @return
	 */
	public IntegrityCheckResult performIntegrityCheck()
	{
		Iterator iterator = this.getIterator();
		
		while(iterator.hasNext())
		{
			IntegrityNode n = (IntegrityNode)iterator.getCurrent();
			if(n.getIntegrityCheck() > ((IntegrityNode)n.getNext()).getIntegrityCheck())
			{
				return new IntegrityCheckResult(n);
			}
			else
			{
				iterator.next();
			}
		}
		
		return new IntegrityCheckResult(null);
	}
	
	public void updateIntegrityConstraints()
	{
		IntegrityNode current = this.getHead();
		int i = 1;
		while(current.hasNext())
		{
			current.setIntegrityCheck(i++ * 10);
			current = current.getNext();
		}
	}
	
	public void debug()
	{
		int i = 0;
		IntegrityNode current = this.getHead();
		
		while(current.hasNext())
		{
			System.out.print(current.getIntegrityCheck()+", ");
			current = current.getNext();
			i++;
		}
		System.out.println(current.getIntegrityCheck());
	}
}
