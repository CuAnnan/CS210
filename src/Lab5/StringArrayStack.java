package Lab5;

/**
 * A stack class to specifically store strings.
 * Removing elements is actually done via reducing the top index rather than nulling or deletion, which is probably more efficient.
 */
public class StringArrayStack
{
	/**
	 * The contents of the stack
	 */
	String[] contents;
	/**
	 * The maximum size of the stack
	 */
	int size;
	/**
	 * The top index
	 */
	int top;
	
	/**
	 * Constructor
	 * @param size	Max size of the contents
	 */
	public StringArrayStack(int size)
	{
		this.size = size;
		this.contents = new String[size];
		this.top = -1;
	}
	
	/**
	 * Add an element to the top
	 * @param s
	 */
	public void push(String s)
	{
		// increment the top index and add a string at the new index
		this.contents[++top] = s;
	}
	
	/**
	 * Remove and return the top element
	 * @return
	 */
	public String pop()
	{
		return this.contents[top--];
	}
	
	/**
	 * Return the top element without removing
	 * @return
	 */
	public String peek()
	{
		return this.contents[top];
	}
	
	/**
	 * Empty the stack by setting the top indexz to -1
	 */
	public void empty()
	{
		this.top = -1;
	}
	
	/**
	 * Check whether there are contents of the stack
	 * @return
	 */
	public boolean isEmpty()
	{
		return this.top == -1;
	}
	
	/**
	 * Check if the stack is full.
	 * @return
	 */
	public boolean isFull()
	{
		return this.top == this.size - 1;
	}
	
	/**
	 * Debug method
	 */
	public void debug()
	{
		System.out.println("Top: "+top+"\nContents: ");
		for(int i = 0; i <= top; i++)
		{
			System.out.print(this.contents[i]+" ");
		}
	}
}
