package Lab4;

/**
 * Bubble sort implementation
 */
public class ArrayBubbleSorter extends ArraySorter
{
    public ArrayBubbleSorter() throws StringsNotSetException 
    {
        super();
    }
    
    
    /**
     * A method to bubble sort the array based on the spec of the lab.
     * @param sizeAscending     If lengthOrder is true, sorts ascending. If it's false, it sorts descending. Because of the other implementations, this "defaults" to true.
     * @param lexicalAscending  If wordOrder is true, sorts ascending. If it's false, it sorts descending. Because of the other implementations, this "defaults" to true.
     */
    public void sort(boolean sizeAscending, boolean lexicalAscending)
    {
        // loop forward from the first to the second to last
        for(int i = 0; i < this.words.length - 1; i++)
        {
            // loop forward from the first to the second to last *unsorted* (because by the last i will be sorted by the end of the loop)
            for(int j = 0; j < this.words.length - i - 1; j++)
            {
                if(
                    (
                        words[j].length() == words[j+1].length() && // if the words are of equal length
                        words[j].compareToIgnoreCase(words[j+1]) > 0 /* and the word comes after the next word*/ == lexicalAscending // this comparison allows us to change the sort order 
                    )
                    ||
                    (words[j].length() > words[j+1].length() /* If the next word is longer */ == sizeAscending /* This comparison allows us to change the sort order*/)
                )
                {
                    /* call the swap */
                    this.swap(j, j+1);
                }
            }
        }
    }
}
