package Recursion;

public class ArraySorting
{
    public static void printArray(int[] someArray)
    {
        for(int i = 0; i < someArray.length - 1; i++)
        {
            System.out.print(someArray[i]+", ");
        }
        System.out.println(someArray[someArray.length - 1]);
    }
    
    public static void main(String[] args)
    {
        int[] unsorted = {15, 23, 1, 91, 23, 96, 13, 5, 2, 29};
        int[] toSort = new int[unsorted.length];
        
        System.arraycopy(unsorted, 0, toSort, 0, unsorted.length);
        
        System.out.println("Unsorted");
        printArray(toSort);
        MergeSorter.mergeSortRecursive(toSort, 0, toSort.length - 1);
        System.out.println("Sorted");
        printArray(toSort);
    }
}
