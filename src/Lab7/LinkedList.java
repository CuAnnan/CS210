package Lab7;


class Node
{
	Node next;
	Student student;
	
	public Node(Student student)
	{
		this.student = student;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public boolean hasNext()
	{
		return this.next == null;
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

class Iterator
{
	private Node previous;
	private Node current;
	LinkedList list;
	
	
	public Iterator(LinkedList list)
	{
		this.list = list;
		this.reset();
	}
	
	public boolean hasNext()
	{
		return this.current != null;
	}
	
	public Node getCurrent()
	{
		return this.current;
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
