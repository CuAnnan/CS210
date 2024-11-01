package Lab4;

public class SelectionSorter extends Sorter
{
    public void reset()
    {
        System.out.println("Selection sort");
        super.reset();
    }
    
    
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
        for(int i = 0; i < Sorter.words.length - 1; i++)
        {
            // assume the current index is the smallest word
            int min = i;
            // loop forward looking for words that are smaller than the current index
            for(int j = i+1; j < Sorter.words.length; j++)
            {
                // do the comparison
                if(Sorter.words[j].length() < Sorter.words[min].length() == sortAscending)
                {
                    // if the current word is smaller, we set min to it
                    min = j;
                }
            }
            // now that we're done, if there is a swap to be done
            if(i != min)
            {
                // swap
                Sorter.swap(i, min);
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
        for(int i = 0; i < Sorter.words.length-1; i++)
        {
            // internal loop index
            int j = i;
            
            // assume that this is the word we're gonna swap
            int lexicalSwapIndex = i;
            
            // loop forward again but only while the next word is the same length as this word (and we have a next element)
            while(j < Sorter.words.length - 1 && Sorter.words[j].length() == Sorter.words[j+1].length())
            {
                // do the lexical comparison
                if(Sorter.words[lexicalSwapIndex].compareToIgnoreCase(Sorter.words[j+1]) > 0 == sortAscending)
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
                Sorter.swap(i, lexicalSwapIndex);
            }
        }
    }
}
