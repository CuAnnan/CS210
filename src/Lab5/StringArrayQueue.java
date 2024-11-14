package Lab5;

public class StringArrayQueue
{
	int size;
	String[] contents;
	int front, rear;
	int count;

	
	public StringArrayQueue(int size)
	{
		this.contents = new String[size];
		this.size = size;
		this.front = -1;
		this.rear = -1;
		this.count = 0;
	}
	
	public void add(String value)
	{
		this.contents[(++this.rear)%this.size] = value;
		
		// prevent rear from eventually overloading
		this.rear = this.rear%this.size;
		
		if(this.front == -1)
		{
			this.front = 0;
		}
		this.count ++;
	}
	
	public String removeFromFront()
	{
		if(this.count == 0)
		{
			return null;
		}
		
		String value = this.contents[this.front++];
		this.front = this.front%this.size;
		this.count --;
		return value;
	}
	
	public String removeFromRear()
	{
		if(this.count == 0)
		{
			return null;
		}
		
		String value = this.contents[this.rear--];
		if(this.rear < 0)
		{
			this.rear += this.size;
		}
		this.count --;
		return value;
	}
	
	public boolean isFull()
	{
		return this.front == 0 && this.rear == this.size - 1 || this.front == this.rear + 1;
	}
	
	public boolean isEmpty()
	{
		return this.count == 0;
	}

	public void debug()
	{
		String out = "";
		System.out.println("Front: "+this.front+"\nRear: "+this.rear);
		int end = this.rear > this.front?this.rear:this.rear + this.size;
		
		for(int i = this.front; i <= end; i++)
		{
			
			out += this.contents[i%this.size]+"\n";
		}
		System.out.println(out);
	}
}
