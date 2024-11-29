package Lab7;

public class Iterator
{
	protected Node previous;
	protected Node current;
	protected LinkedList list;
	
	public Iterator() {}
	
	
	public Iterator(LinkedList list)
	{
		this.list = list;
		this.reset();
	}
	
	public boolean hasNext()
	{
		return this.current.next != null;
	}
	
	public Node getCurrent()
	{
		return this.current;
	}
	
	public void insertBeforeCurrent(Student s)
	{
		if(this.current == list.getHead())
		{
			list.addToHead(s);
			return;
		}
		Node studentNode = new Node(s);
		this.previous.next = studentNode;
		studentNode.setNext(this.current);
		this.current = studentNode;
		
	}
	
	public Student getCurrentStudent()
	{
		return this.current.getStudent();
	}
	
	public void next()
	{
		this.previous = this.current;
		this.current = this.current.next;
	}
	
	public Node removeCurrent()
	{
		Node toRemove;
		if(this.previous == null)
		{
			toRemove = this.list.getHead();
			this.list.removeHead();
		}
		else
		{
			toRemove = current;
			current.setNext(null);
			this.previous.setNext(current.getNext());
		}
		return toRemove;
	}
	
	public void reset()
	{
		this.previous = null;
		this.current = this.list.getHead();
	}
}