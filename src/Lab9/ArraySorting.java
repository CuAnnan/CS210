package Lab9;

import java.util.Random;

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
    
    public static void doMergeSorting(int[] unsorted)
    {
        System.out.println("Merge Sorting");
        
        int[] toSort = new int[unsorted.length];
        System.arraycopy(unsorted, 0, toSort, 0, unsorted.length);
        System.out.println("Unsorted");
        printArray(toSort);
        long start = System.currentTimeMillis();
        MergeSorter.mergeSortRecursive(toSort, 0, toSort.length - 1);
        long time = System.currentTimeMillis() - start;
        System.out.println("Sorted in "+time+" ms");
        printArray(toSort);
    }
    
    public static void doQuickSorting(int[] unsorted)
    {
        System.out.println("Quick Sorting");
        int[] toSort = new int[unsorted.length];
        System.arraycopy(unsorted, 0, toSort, 0, unsorted.length);
        System.out.println("Unsorted");
        printArray(toSort);
        long start = System.currentTimeMillis();
        QuickSorter.quickSortRight(toSort, 0, toSort.length - 1);
        long time = System.currentTimeMillis() - start;
        System.out.println("Sorted in "+time+" ms");
        printArray(toSort);
    }
    
    public static void doQuickSortingMedian3(int[] unsorted)
    {
    	System.out.println("Quick Sorting");
        int[] toSort = new int[unsorted.length];
        System.arraycopy(unsorted, 0, toSort, 0, unsorted.length);
        System.out.println("Unsorted");
        printArray(toSort);
        long start = System.currentTimeMillis();
        QuickSorter.quickSortMedian3(toSort, 0, toSort.length - 1);
        long time = System.currentTimeMillis() - start;
        System.out.println("Sorted in "+time+" ms");
        printArray(toSort);
    }
    
    public static void main(String[] args)
    {
        int[] unsorted = new int[10000000];
        Random r = new Random(156879883546891348L);
        for(int i = 0 ; i < unsorted.length; i++)
        {
            unsorted[i] = r.nextInt(1, 1000);
        }
        printArray(unsorted);
        doMergeSorting(unsorted);
        doQuickSorting(unsorted);
        doQuickSortingMedian3(unsorted);
    }
}
