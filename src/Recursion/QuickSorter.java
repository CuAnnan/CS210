package Recursion;

public class QuickSorter
{
	public static void quickSortRight(int[] toSort, int start, int end)
	{
		if(end <= start)
		{
			return;
		}
		
		int partitionIndex = doRightPartition(toSort, start, end);
		quickSortRight(toSort, start, partitionIndex - 1);
		quickSortRight(toSort, partitionIndex + 1, end);
	}
	
	public static int doRightPartition(int[] toSort, int start, int end)
	{
		int left = start - 1;
		int right = end;
		
		int pivot = toSort[end];
		
		while(true)
		{
		    while(toSort[++left] < pivot) {};
			while(right > 0 && toSort[--right] > pivot) {};
			if(left >= right)
			{
				break;
			}
			swap(toSort, left, right);
		}
		
		swap(toSort, left, end);
		return left;
	}
	
	public static void swap(int[] array, int a, int b)
	{
	    int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
