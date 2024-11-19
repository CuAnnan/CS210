package Lab6;

/**
 * A node element
 * Used to store data and to act as links in the linked list
 */
class Node
{
    /**
     * The value to store
     */
	int value;
	/**
	 * The next element it points to
	 */
	Node next;
	
	/**
	 * Constructor
	 * @param n    The value to store
	 */
	public Node(int n)
	{
		this.value = n;
		this.next = null;
	}
	
	/**
	 * A comparator for whether the value in this node is bigger than or equal to the value in the other
	 * @param other
	 * @return
	 */
	public boolean gte(Node other)
	{
		return this.value >= other.value;
	}
	
	/**
	 * A comparator for whether the value in this node is bigger or equal tothan some int value
	 * @param n
	 * @return
	 */
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

/**
 * A double ended Linked List to act as the implementation data type for the queue
 */
class LinkedList
{
    /**
     * Head node
     */
	Node head;
	/**
	 * Tail node
	 */
	Node tail;
	
	/**
	 * The current number of items in the linked list. We have to update this every add or remove
	 */
	int length;
	
	/**
	 * Constructor. Just initialises instance variables.
	 */
	public LinkedList()
	{
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	/**
	 * This is generally the public face of the addToHead method because you're seldom dealing with Nodes.
	 * @param n
	 */
	protected void addToHead(int n)
	{
		this.addToHead(new Node(n));
	}
	
	/**
	 * The actual implementation
	 * @param n
	 */
	protected void addToHead(Node n)
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
	
	protected void addToTail(int n)
	{
		this.addToTail(new Node(n));
	}
	
	protected void addToTail(Node n)
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
	
	protected Node pop()
	{
		Node toPop = this.head;
		this.head = this.head.next;
		this.length--;
		return toPop;
	}
	
	protected int getLength()
	{
		return this.length;
	}
	
	public String getDebugString()
	{
	    String out = "";
        Node current = this.head;
        out += current.value+" ";
        while(current.hasNext())
        {
            current = current.next;
            out += current.value +" ";
        }
        return out;
	}
	
	public void debug()
	{
		System.out.println("Debug:\nLength: "+this.length+"\n"+this.getDebugString());
	}
}

public class IntegerPriorityQueue
{
	int size;
	boolean orderAscending;
	LinkedList list;
	
	public IntegerPriorityQueue(int size)
	{
		this(size, true);
	}
	
	public IntegerPriorityQueue(int size, boolean orderAscending)
	{
		
	    this.size = size;
	    this.orderAscending = orderAscending;
	    this.list = new LinkedList();
	}
	
	public void debug()
	{
	    System.out.print((this.orderAscending?"Ascending":"Descending")+" Priority Queue ");
	    System.out.println("Debug:\nLength: "+this.list.length+"\nMaximum Size: "+this.size+"\n"+this.list.getDebugString());
	}
	
	
	/**
	 * A method to insert the int n at the appropriate position in the queue according to its priority
	 * If this.sortAscending is set to true, the default, the sort order will be low to high. Otherwise high to low
	 * @param n    The int to be inserted
	 * @return     True if the insertion happened, false otherwise
	 */
	public boolean insert(int n)
	{
	    // if the amount of things (this.size) in this list is equal to the current length of the list (this.lengh)
	    // this method returns false immediately
//	    if(this.list.length == this.size)
//	    {
//	        return false;
//	    }
	    
	    // otherwise we create a new node to insert
		Node toInsert = new Node(n);
		
		// if we have nothing in the linked list, skip all searching and just insert it at the head
		if(this.list.length == 0)
		{
			this.list.addToHead(toInsert);
			return true;
		}
		
		// Start by assuming the current is the head and the previous is null
		Node current = this.list.head;
		Node previous = null;
		
		/*
		 * While current isn't null, we can move previous to current and figure out if the element to be inserted
		 * should be inserted before the new current
		 * We do the second comparison to allow reverse order insertion.
		 */
		while(current != null && toInsert.gte(current) == this.orderAscending)
		{
			previous = current;
			current = current.next;
		}
		
		
		// If there's nothing before current, we should be adding to the head.
		if(previous == null)
		{
			this.list.addToHead(n);
            return true;
		}
		
		// Otherwise we add it before current and after previous
		toInsert.next = current;
		previous.next = toInsert;
		// and increase the length by one
		
		// and return true
        return true;
	}
	
	
	
	/**
	 *  pop and remove the value of the head element of the queue
	 *  @return Returns the int value at the head of the queue
	 */
	public int remove()
	{
		Node toRemove = this.list.pop();
		return toRemove.value;
	}
	
	/**
	 * Returns true if the number of things added (this.length) equals the maximum size (this.size)
	 * @return
	 */
	public boolean isFull()
	{
		return this.list.length == this.size;
	}
	
	/**
	 * Returns true if there's nothing in this queue
	 * @return
	 */
	public boolean isEmpty()
	{
		return this.list.head == null;
	}
}
