package Lab9;

public abstract class Sorter
{
    static boolean sortAscending = true;
    
    public static void swap(int[] array, int a, int b)
	{
	    int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
