package Recursion;

public class MergeSorter
{
    
	/*
	 * This should actually be done via moving the indices, not arraycopying
	 */
    public static void mergeSortRecursive(int[] toSort, int lowerBound, int upperBound)
    {
        if(lowerBound == upperBound)
        {
            return;
        }
        
        int mid = (lowerBound + upperBound) / 2; // doesn't matter that this loses precision because we don't care
        
        mergeSortRecursive(toSort, lowerBound, mid); // Recursively mergeSort left
        mergeSortRecursive(toSort, mid + 1, upperBound); // Recursively mergeSort right
        merge(toSort, lowerBound, mid + 1, upperBound);
    }
    
    public static void merge(int[] toSort, int lowerBound, int mid, int upperBound)
    {
        int i =0, j = 0, k = 0;
        
        
    }
    
    public static void main(String[] args)
    {
        int[] toSort = {15, 23, 1, 91, 23, 96, 13, 5, 2, 29};
        mergeSortRecursive(toSort, 0, toSort.length);
        for(int i = 0; i < toSort.length; i++)
        {
            System.out.print(toSort[i]+(i < toSort.length - 1?", ":""));
        }
    }
}
