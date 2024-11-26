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
public class LinkedList
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