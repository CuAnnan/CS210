package Lab9;

public class MergeSorter extends Sorter
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
        int i =0, j = 0, k = lowerBound;
        
        int[] left = new int[mid - lowerBound];
        System.arraycopy(toSort, lowerBound, left, 0, left.length);
        
        int[] right = new int[upperBound - mid + 1];
        System.arraycopy(toSort, mid, right, 0, right.length);
        
        while(i < left.length  && j < right.length)
        {
            if(left[i] < right[j])
            {
                toSort[k++] = left[i++];
            }
            else
            {
                toSort[k++] = right[j++];
            }
        }
        
        while(i < left.length)
        {
            toSort[k++] = left[i++];
        }
        while(j < right.length)
        {
            toSort[k++] = right[j++];
        }
    }
}
