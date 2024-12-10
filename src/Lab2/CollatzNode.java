package Lab2;

/**
 * A class to contain the values for a collatz sequence entry It's just a POJO though.
 */
public class CollatzNode
{
	/**
	 * The value of the node
	 */
	int value;
	/**
	 * The next node in the sequence
	 */
	CollatzNode next = null;
	
	/**
	 * Constructor
	 * @param value The value to store
	 */
	public CollatzNode(int value)
	{
		this.value = value;
	}
	
	/**
	 * Setter for the next node
	 * @param next The next CollatzNode in the sequence
	 * @return Returns a reference to this for ease of chaining
	 */
	public CollatzNode setNext(CollatzNode next)
	{
		this.next= next;
		return this;
	}
	
	/**
	 * Check if there is a next node. Allows iteration.
	 * @return True if there is a next node. False otherwise
	 */
	public boolean hasNext()
	{
		return this.next != null;
	}
	
	/**
	 * A method to get the next node
	 * @return	The Collatz Node that's next in the sequence
	 */
	public CollatzNode getNext()
	{
		return this.next;
	}
	
	/**
	 * Getter for the value in this node.
	 * @return The value in this node
	 */
	public int getValue()
	{
		return this.value;
	}
}
