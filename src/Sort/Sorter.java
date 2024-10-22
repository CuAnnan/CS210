package Sort;

public class Sorter
{
	int[] array;
	
	public Sorter(int[] array)
	{
		this.setArray(array);
	}
	
	public void setArray(int[] array)
	{
		this.array = array;
	}
	
	public void swap(int i, int j)
	{
		int temp = this.array[i];
		this.array[i] = this.array[j];
		this.array[j] = temp;
	}
	
	public void bubbleSort()
	{
		for(int i = 0; i < this.array.length - 1; i++)
		{
			for(int j = 0; j < this.array.length - 1 - i; j++)
			{
				if(this.array[j] > this.array[j+1])
				{
					this.swap(j,  j+1);
				}
			}
		}
	}
	
	public void selectionSort()
	{
		for(int i = 0; i < this.array.length; i++)
		{
			int min = i;
			for(int j = i+1; j < this.array.length; j++)
			{
				if(this.array[j] < this.array[min])
				{
					min = j;
				}
			}
			this.swap(i, min);
		}
	}
	
	public void printArray()
	{
		for(int i = 0; i < this.array.length - 1; i++)
		{
			System.out.print(this.array[i]+", ");
		}
		System.out.println(this.array[this.array.length - 1]);
	}
	
}
