package Lab8;

import Lab7.Iterator;
import Lab7.LinkedList;
import Lab7.Student;

public class IntegrityLinkedList extends LinkedList
{
	public void addToHead(Student s)
	{
		IntegrityNode n = new IntegrityNode(s, this.getLength());
		super.addToHead(n);
	}
	
	public void addToTail(Student s)
	{
		IntegrityNode n = new IntegrityNode(s, this.getLength());
		super.addToTail(n);
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
}
