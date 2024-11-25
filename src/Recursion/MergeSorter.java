package Recursion;

public class MergeSorter
{
    
    public static void mergeSortRecursive(int[] toSort)
    {
        if(toSort == null || toSort.length <= 1)
        {
            return;
        }
        
        int mid = toSort.length / 2; // doesn't matter that this loses precision because we don't care
        int[] left = new int[mid]; // a new array for the points left of the mid
        int[] right =new int[toSort.length - mid]; // and right of the mid
        
        System.arraycopy(toSort,  0,  left, 0, left.length); // make our first int array
        
        if(toSort.length >= mid) // if necessary make our second one
        {
            System.arraycopy(toSort, mid, right, 0, right.length);
        }
        
        mergeSortRecursive(left); // Recursively mergeSort left
        mergeSortRecursive(right); // Recursively mergeSort right
        merge(left, right, toSort); // do the merging of the recursively sorted left and right
    }
    
    public static void merge(int[] left, int[] right, int[] sorted)
    {
        int i =0, j = 0, k = 0;
        
        while(i < left.length && j < right.length)
        {
            if(left[i] <= right[j])
            {
                sorted[k++] = left[i++];
            }
            else
            {
                sorted[k++] = right[j++];
            }
        }
        
        for(int l= i; l < left.length; l++)
        {
            sorted[k++] = left[l];
        }
        for(int r = j; r < right.length; r++)
        {
            sorted[k++] = right[r];
        }
    }
    
    public static void main(String[] args)
    {
        int[] toSort = {15, 23, 1, 91, 23, 96, 13, 5, 2, 29};
        mergeSortRecursive(toSort);
        for(int i = 0; i < toSort.length; i++)
        {
            System.out.print(toSort[i]+(i < toSort.length - 1?", ":""));
        }
    }
}
