package Lab9;

public class QuickSorter extends Sorter
{
	public static void quickSortRight(int[] toSort, int start, int end)
	{
		if(end <= start)
		{
			return;
		}
		
		int partitionIndex = doPartition(toSort, start, end);
		quickSortRight(toSort, start, partitionIndex - 1);
		quickSortRight(toSort, partitionIndex + 1, end);
	}
	
	public static int doPartition(int[] toSort, int start, int end)
	{
	    return doRightPartition(toSort, start, end);
	}
	
	public static int doRightPartition(int[] toSort, int start, int end)
	{
		int left = start - 1;
		int right = end;
		
		int pivot = toSort[end];
		
		while(true)
		{
		    while(left < toSort.length - 1 && toSort[++left] < pivot == sortAscending) {};
			while(right > 0 && toSort[--right] > pivot == sortAscending) {};
			if(left >= right)
			{
				break;
			}
			swap(toSort, left, right);
		}
		
		swap(toSort, left, end);
		return left;
	}
	
	public static void quickSortMedian3(int[] toSort, int start, int end)
	{
		if(end <= start)
		{
			return;
		}
		
		int middle = (start + end) / 2;
		
		if(toSort[start] > toSort[end] == sortAscending)
		{
			swap(toSort, start, end);
		}
		if(toSort[end] > toSort[middle] == sortAscending)
		{
			swap(toSort, end, middle);
		}
		if(toSort[start] < toSort[middle] == sortAscending)
		{
			swap(toSort, start, middle);
		}
		int partitionIndex = doPartition(toSort, start, end);
		quickSortMedian3(toSort, start, partitionIndex - 1);
		quickSortMedian3(toSort, partitionIndex + 1, end);
		
	}
	
	public static void swap(int[] array, int a, int b)
	{
	    int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
