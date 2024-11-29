package Lab7;




class IteratorOutOfBoundsException extends Exception
{
	private static final long serialVersionUID = 1L;

	public IteratorOutOfBoundsException()
	{
		super("Iterator out of bounds");
	}
	
	public IteratorOutOfBoundsException(String message)
	{
		super(message);
	}
}


public class LinkedList
{
	private Node tail;
	private Node head;
	private int length;
	
	public LinkedList()
	{
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public void addToHead(Student s)
	{
		this.addToHead(new Node(s));
	}
	
	public void addToHead(Node previous)
	{
		if(this.head == null)
		{
			this.head = previous;
			this.tail = previous;
		}
		else
		{
			previous.setNext(this.head);
			this.head = previous;
		}
		this.length ++;
	}
	
	public void addToTail(Student s)
	{
		this.addToTail(new Node(s));
	}
	
	public void addToTail(Node next)
	{
		if(this.head == null)
		{
			this.head = next;
			this.tail = next;
		}
		else
		{
			this.tail.setNext(next);
			this.tail = next;
		}
		this.length ++;
	}
	
	public Iterator getIterator()
	{
		return new Iterator(this);
	}
	
	public Node getHead()
	{
		return this.head;
	}
	
	protected void removeHead()
	{
		if(this.head != null)
		{
			this.head = this.head.next;
		}
		this.length --;
	}
	
	
	public int getLength()
	{
		return this.length;
	}
	
	public void printList()
	{
		Node current = this.head;
		while(current != null)
		{
			System.out.println(current.getStudent().toString());
			current = current.getNext();
		}
	}
}
