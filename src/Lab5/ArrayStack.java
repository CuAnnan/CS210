package Lab5;

/**
 * A class to implement an array based stack. I have to rely on supression of warnings because java doesn't
 * like generic arrays. Which, fine. I guess.
 * @author Éamonn "Wing" Kearns
 * @param <T>
 */
public class ArrayStack<T>
{
	/**
	 * Max size of the stack
	 */
	private int size;
	// Container array for data in the stack
	private Object[] contents;
	// The index of the top element in the array
	private int top;
	
	/**
	 * Constructor. Just does some basic instantiation.
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int size)
	{
		this.size = size;
		// https://stackoverflow.com/questions/2927391/whats-the-reason-i-cant-create-generic-array-types-in-java
		this.contents = (T[]) new Object[size];
		// default the top to -1 meaning empty
		this.top = -1;
	}
	
	/**
	 * A method to return the count of items in the stack
	 * @return
	 */
	public int getSize()
	{
		return this.top + 1;
	}
	
	/**
	 * Add a thing to the stack
	 * @param n
	 */
	public void push(T n)
	{
		this.contents[++top] = n;
	}
	
	/**
	 * Remove and return a thing from the array.
	 * It only removes in effect by reducing the top allowing the element to be overwritten.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T pop()
	{
		//
		return (T)this.contents[top--];
	}
	
	/**
	 * See the current top element
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T peek()
	{
		return (T)this.contents[top];
	}
	
	/**
	 * empty the array
	 */
	public void empty()
	{
		top = -1;
	}
	
	/**
	 * Compares top to -1, the empty value, and returns the result
	 * @return 
	 */
	public boolean isEmpty()
	{
		return this.top == -1;
	}
	
	/**
	 * Checks if the stack is full
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
			System.out.print((T)this.contents[i]);
		}
	}
}
