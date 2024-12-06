package Lab9;
//
//import java.util.Random;
import java.util.Scanner;

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
    	System.out.println("Quick Sorting Median3");
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
    
    public static Scanner getScanner(boolean useSysin)
    {
        Scanner sc = null;
        if(useSysin)
        {
            sc = new Scanner(System.in);
        }
        else
        {
            sc = new Scanner("20\n92 35 1 33 23 96 17 37 29 18 74 1214 93 75 2 8 7 17 2 12 5 921");
        }
        return sc;    
    }
    
    public static void main(String[] args)
    {
        int[] unsorted;
        Scanner sc = getScanner(false);
        
        System.out.println("Enter array size: ");
        int size = Integer.parseInt(sc.nextLine());
        unsorted = new int[size];
        
        System.out.println("Enter space separated ints:");
        Scanner intScanner = new Scanner(sc.nextLine());
        int i = 0;
        while(i < size)
        {
            unsorted[i++] = intScanner.nextInt();
        }
        
        System.out.println();
        
        doMergeSorting(unsorted);
        System.out.println();
        doQuickSorting(unsorted);
        System.out.println();
        doQuickSortingMedian3(unsorted);
        
        intScanner.close();
        sc.close();
    }
}
