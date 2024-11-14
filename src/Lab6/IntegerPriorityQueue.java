package Lab6;

class Node
{
	int value;
	Node next;
	
	public Node(int n)
	{
		this.value = n;
		this.next = null;
	}
	
	public boolean gte(Node other)
	{
		return this.value >= other.value;
	}
	
	public boolean gte(int n)
	{
		return this.value >= n;
	}
	
	public boolean gt(int n)
	{
		return this.value > n;
	}
	
	public boolean gt(Node other)
	{
		return this.value > other.value;
	}
	
	public boolean hasNext()
	{
		return this.next != null;
	}
}

class LinkedList
{
	Node head;
	Node tail;
	int length;
	
	public LinkedList()
	{
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public void addToHead(int n)
	{
		this.addToHead(new Node(n));
	}
	
	public void addToHead(Node n)
	{
		if(this.head == null)
		{
			this.head = n;
			this.tail = n;
		}
		else
		{
			n.next = this.head;
			this.head = n;
		}
		this.length++;
	}
	
	public void addToTail(int n)
	{
		this.addToTail(new Node(n));
	}
	
	public void addToTail(Node n)
	{
		if(this.head == null)
		{
			this.head = n;
			this.tail = n;
		}
		else
		{
			this.tail.next = n;
			this.tail = n;
		}
		this.length++;
	}
	
	public Node pop()
	{
		Node toPop = this.head;
		this.head = this.head.next;
		this.length--;
		return toPop;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public void debug()
	{
		System.err.println("Debug:");
		String out = "";
		Node current = this.head;
		out += current.value+" ";
		while(current.hasNext())
		{
			current = current.next;
			out += current.value +" ";
		}
		
		System.out.println(out);
	}
}

public class IntegerPriorityQueue extends LinkedList
{
	int size;
	
	public IntegerPriorityQueue(int size)
	{
		this.size = size;
	}
	
	public void insert(int n)
	{
		// create a new node to insert and then figure out where to put it
		Node toInsert = new Node(n);
		
		// if we have nothing in the linked list, skip all searching
		if(this.length == 0)
		{
			this.addToHead(toInsert);
			return;
		}
		
		// figure out where to insert by looping through the contents until what we have is not
		// bigger than current and then insert the 
		Node current = this.head;
		Node previous = null;
		
		
		while(current != null && toInsert.gte(current))
		{
			previous = current;
			current = current.next;
		}
		
		
		// other edge case. We've nothing before this node because the second element is bigger
		if(previous == null)
		{
			this.addToHead(n);
			return;
		}
		
		//System.out.println("Adding "+n+" between "+previous.value+" and "+current.value);
		toInsert.next = current;
		previous.next = toInsert;
		this.length++;
	}
	
	public int remove()
	{
		Node toRemove = this.head;
		this.head = this.head.next;
		return toRemove.value;
	}
	
	public boolean isFull()
	{
		return this.length == this.size;
	}
	
	public boolean isEmpty()
	{
		return this.head == null;
	}
}
