package Lab4;

public class BubbleSorter extends Sorter
{
 
    public void reset()
    {
        System.out.println("Bubble sort");
        super.reset();
    }
    
    
    /**
     * A method to bubble sort the array based on the spec of the lab.
     * @param sizeAscending     If lengthOrder is true, sorts ascending. If it's false, it sorts descending. Because of the other implementations, this "defaults" to true.
     * @param lexicalAscending  If wordOrder is true, sorts ascending. If it's false, it sorts descending. Because of the other implementations, this "defaults" to true.
     */
    public void sort(boolean sizeAscending, boolean lexicalAscending)
    {
        // loop forward from the first to the second to last
        for(int i = 0; i < Sorter.words.length - 1; i++)
        {
            // loop forward from the first to the second to last *unsorted* (because by the last i will be sorted)
            for(int j = 0; j < Sorter.words.length - i - 1; j++)
            {
                if(
                    (
                        Sorter.words[j].length() == Sorter.words[j+1].length() && // if the words are of equal length
                        Sorter.words[j].compareToIgnoreCase(Sorter.words[j+1]) > 0 /* and the word comes after the next word*/ == lexicalAscending // this comparison allows us to change the sort order 
                    )
                    ||
                    (Sorter.words[j].length() > Sorter.words[j+1].length() /* If the next word is longer */ == sizeAscending /* This comparison allows us to change the sort order*/)
                )
                {
                    /* call the swap */
                    Sorter.swap(j, j+1);
                }
            }
        }
    }
}
