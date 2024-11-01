package Lab4;

/**
 * A class to sort an array of words using the selection sort
 * @author Éamonn "Wing" Kearns 60460770
 */
public class ArraySelectionSorter extends ArraySorter
{
    
    public ArraySelectionSorter() throws StringsNotSetException
    {
        super();
    }
    
    /**
     * Dummy method which calls the two workhorse methods
     */
    public void sort(boolean sizeAscending, boolean lexicalAscending)
    {
        // run the size sort
        this.sortSize(sizeAscending);
        // run the lexical sort
        this.sortLexical(lexicalAscending);
    }
    
    /**
     * Selection sort based on the size of the words
     * @param sortAscending If true, sort ascending. If false, sort descending.
     */
    public void sortSize(boolean sortAscending)
    {
        // loop forward to the second last word
        for(int i = 0; i < words.length - 1; i++)
        {
            // assume the current index is the smallest word
            int min = i;
            // loop forward looking for words that are smaller than the current index
            for(int j = i+1; j < words.length; j++)
            {
                // do the comparison
                if(words[j].length() < words[min].length() == sortAscending)
                {
                    // if the current word is smaller, we set min to it
                    min = j;
                }
            }
            // now that we're done, if there is a swap to be done
            if(i != min)
            {
                // swap
                swap(i, min);
            }
        }
    }
    
    /**
     * This is the lexical sort method for the selection sort algorithm.
     * @param sortAscending If true, sort ascending. If false, sort descending.
     */
    public void sortLexical(boolean sortAscending)
    {
        // start at the start and move forward in blocks of same size text
        for(int i = 0; i < words.length-1; i++)
        {
            // internal loop index
            int j = i;
            
            // assume that this is the word we're gonna swap
            int lexicalSwapIndex = i;
            
            // loop forward again but only while the next word is the same length as this word (and we have a next element)
            while(j < words.length - 1 && words[j].length() == words[j+1].length())
            {
                // do the lexical comparison
                if(words[lexicalSwapIndex].compareToIgnoreCase(words[j+1]) > 0 == sortAscending)
                {
                    // if a swap is needed, set the word to be swapped
                    lexicalSwapIndex = j+1;
                }
                // increase the internal loop index
                j++;
            }
            
            // if a swap is needed
            if(lexicalSwapIndex != i)
            {
                // do the swap
                swap(i, lexicalSwapIndex);
            }
        }
    }
}
