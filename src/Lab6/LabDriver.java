package Lab6;

public class LabDriver
{
	public static void main(String[] args)
	{
		int size = 100;
		
		IntegerPriorityQueue queue = new IntegerPriorityQueue(size);
		
		for(int i = 0; i < size; i++)
		{
			int value = (int)(Math.random() * 2 * size) + 1;
			queue.insert(value);
		}
		
		queue.debug();
	}
}
