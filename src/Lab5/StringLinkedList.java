package Lab5;



public class StringLinkedList
{
	private Node head;
	private Node tail;
	private int size;
	
	public StringLinkedList()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void addToHead(String value)
	{
		this.addToHead(new Node(value));
	}
	
	public void addToHead(Node element)
	{
		if(this.head == null)
		{
			this.head = element;
			this.tail = element;
		}
		else
		{
			element.setNext(this.head);
			this.head = element;
		}
		this.size++;
	}
	
	public void addToTail(String value)
	{
		this.addToTail(new Node(value));
	}
	
	public void addToTail(Node element)
	{
		if(this.head == null)
		{
			this.head = element;
			this.tail = element;
		}
		else
		{
			this.tail.setNext(element);
			this.tail = element;
		}
		this.size++;
	}
	
	public Node getHead()
	{
		return this.head;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public String peek()
	{
		return this.head.contents;
	}
	
	public Node removeFromHead()
	{
		Node toRemove = this.head;
		this.head = this.head.next;
		toRemove.next = null;
		return toRemove;
	}
	
	
	
}