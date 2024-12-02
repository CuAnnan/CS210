package Recursion;

public class QuickSorter
{
	private static int[] toSort;
	public static void quickSort(int start, int end)
	{
		System.out.println(start+", "+end);
		if(start >= end)
		{
			return;
		}
		
		int partitionIndex = doPartition(start, end);
		quickSort(start, partitionIndex - 1);
		quickSort(partitionIndex + 1, end);
	}
	
	public static int doPartition(int start, int end)
	{
		int i = start - 1;
		int j = end + i;
		
		int pivot = toSort[end];
		while(true)
		{
			while(toSort[++i] < pivot) {};
			while(j > i && toSort[--j] > pivot) {};
			if(i >= j)
			{
				System.out.println(j);
				return j;
			}
			swap(toSort, start, end);
		}
	}
	
	public static void swap(int[] array, int a, int b)
	{
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	public static void main(String[] args)
    {
        toSort = new int[]{15, 23, 1, 91, 23, 96, 13, 5, 2, 29};
        for(int i = 0; i < toSort.length; i++)
        {
            System.out.print(toSort[i]+(i < toSort.length - 1?", ":""));
        }
        quickSort(0, toSort.length - 1);
        for(int i = 0; i < toSort.length; i++)
        {
            System.out.print(toSort[i]+(i < toSort.length - 1?", ":""));
        }
    }
}
