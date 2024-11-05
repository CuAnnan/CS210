package Lab5;

public class StringArrayStack
{
	String[] contents;
	int size;
	int top;
	
	public StringArrayStack(int size)
	{
		this.size = size;
		this.contents = new String[size];
		this.top = -1;
	}
	
	public void push(String s)
	{
		this.contents[++top] = s;
	}
	
	public String pop()
	{
		return this.contents[top--];
	}
	
	public String peek()
	{
		return this.contents[top];
	}
	
	public void empty()
	{
		this.top = -1;
	}
	
	public boolean isEmpty()
	{
		return this.top == -1;
	}
	
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
