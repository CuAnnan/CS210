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

/**
 * This is a Double Ended Singly Linked List class to store Student objects. Would normally use generics.
 *  @author Éamonn Wing Kearns 60460770
 */
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
		previous.setIntegrityValue(this.length);
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
		next.setIntegrityValue(this.length);
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
	
	public Node getTail()
	{
	    return this.tail;
	}
	
	protected void removeHead()
	{
		if(this.head != null)
		{
			this.head = this.head.next;
		}
		this.length --;
	}
	
	/**
	 * A method to find any looping nodes
	 * @return The node that causes the loop if there is any
	 * 
	 */
	public Node findMalformedNode()
	{
	    Node current = this.head;
	    Node malformed = null;
	    while(malformed == null && current != null)
	    {
	        if(current.next != null && current.integrityValue > current.next.integrityValue)
	        {
	            malformed = current;
	        }
	        current = current.next;
	    }
	    return malformed;
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
