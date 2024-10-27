package Lab4;

/**
 * A class to demonstrate an understanding of, and implementation of, the bubble sort, insertion sort, and selection sort.
 */
public class DictionarySorter
{
    /**
     * An array of Strings to hold the sorted form of the words
     */
	private String[] words;
	/**
	 * An array of Strings to hold the unsorted words, which allows the rerunning of the array sorts
	 */
	private String[] wordsBackup;
	/**
	 * A ticker for looping
	 */
	private int index=0;
	
	/**
	 * Constructor
	 * @param dictionarySize Just takes the dictionary size and instantiate the arrays
	 */
	public DictionarySorter(int dictionarySize)
	{
		words = new String[dictionarySize];
		wordsBackup = new String[dictionarySize];
	}
	
	/**
	 * Add a word to the array
	 * @param word The word to be added
	 */
	public void addWord(String word)
	{
		words[index]=word;
		wordsBackup[index] = word;
		index++;
	}
	
	/**
	 * Resets the array. String.arrayCopy is more efficient than looping because it copies RAM addresses.
	 */
	public void reset()
	{
		System.arraycopy(wordsBackup, 0, words, 0, index);
	}
	
	/**
	 * Swap too elements in this.words based on the positions
	 * @param i The index of the first element
	 * @param j The index of the second element
	 */
	public void swap(int i, int j)
	{
		String temp = this.words[i];
		this.words[i] = this.words[j];
		this.words[j] = temp;
	}
	
	
	/**
	 * The bubble sort default method. 
	 */
	public void bubbleishSort()
	{
		this.bubbleishSort(true);
	}
	
	/**
	 * The bubble sort for when you want to be able to invert the sort order
	 * @param lengthOrder If lengthOrder is true, sorts ascending. If it's false, it sorts descending.
	 */
	public void bubbleishSort(boolean lengthOrder)
	{
		this.bubbleishSort(lengthOrder, lengthOrder);
	}
	
	/**
	 * A method to bubble sort the array based on the spec of the lab.
	 * @param lengthOrder  If lengthOrder is true, sorts ascending. If it's false, it sorts descending. Because of the other implementations, this "defaults" to true.
	 * @param wordOrder    If wordOrder is true, sorts ascending. If it's false, it sorts descending. Because of the other implementations, this "defaults" to true.
	 */
	public void bubbleishSort(boolean lengthOrder, boolean wordOrder)
	{
	    // reset the array of words to be sorted.
		this.reset();
		
		// loop forward from the first to the second to last
		for(int i = 0; i < this.words.length - 1; i++)
		{
		    // loop forward from the first to the second to last *unsorted* (because by the last i will be sorted)
			for(int j = 0; j < this.words.length - i - 1; j++)
			{
				if(
					(
						this.words[j].length() == this.words[j+1].length() && // if the words are of equal length
						this.words[j].compareToIgnoreCase(this.words[j+1]) > 0 /* and the word comes after the next word*/ == wordOrder // this comparison allows us to change the sort order 
					)
					||
					(this.words[j].length() > this.words[j+1].length() /* If the next word is longer */ == lengthOrder /* This comparison allows us to change the sort order*/)
				)
				{
				    /* call the swap */
					this.swap(j, j+1);
				}
			}
		}
	}
	
	/**
	 * Helper method for the real selection sort with no params. This allows the defaulting of the method's proper implementation to true, true
	 */
	public void insertionishSort()
	{
		this.insertionishSort(true);
	}
	
	/**
	 * Helper method for the real selection with one param. This defaults both params of the real implementation to the provided value.
	 * @param sortAscending If set to true, the sort will be ascending. If it is false, it will be descending.
	 */
	public void insertionishSort(boolean sortAscending)
	{
		this.insertionishSort(sortAscending, sortAscending);
	}
	
	/**
	 * A method to insertion sort the array 
     * @param lengthOrder  If lengthOrder is true, sorts ascending. If it's false, it sorts descending. Because of the other implementations, this "defaults" to true.
     * @param wordOrder    If wordOrder is true, sorts ascending. If it's false, it sorts descending. Because of the other implementations, this "defaults" to true.
	 */
	public void insertionishSort(boolean sizeSortAscending, boolean lexicalSortAscending)
	{
	    // reset the array of words
        this.reset();
        // loop forward through the words from the second to the last  
        for(int i = 1; i < this.words.length; i++)
        {
            // this is a boolean to allow us to search forward until we're done
            boolean searching = true;
            // set the start of the backwards search to the 
            int j = i;
            
            // loop back and swap until we no longer meet a valid swap
            do
            {
                // while I'd love to do this as a single if statement (and it is possible) the if statement becomes unwieldy
                // so what we do is check if they're equal length
                if(words[j-1].length()==words[j].length())
                {
                    // and if they are and the lexical sorting needs to be done
                    if(words[j-1].compareToIgnoreCase(words[j]) > 0 == lexicalSortAscending)
                    {
                        // we swap them
                        swap(j, j-1);
                    }
                }
                // otherwise if the size sort needs to be done
                else if(words[j-1].length() > words[j].length() == sizeSortAscending)
                {
                    // we swap them
                    swap(j, j-1);
                }
                else
                {
                    // if the size swap doesn't need to be done, the list is as sorted as this outer loop will allow
                    searching = false;
                }
                
                // decrease the inner loop counter
                j--;
                if(j == 0)
                {
                    // if we're out of possible indices, then this is the smallest value for this loop and the internal search loop is done
                    searching = false;
                }
            }while(searching);
        }
	}
	
	/**
	 * Selection sort zero paramater helper method. Defaults both to true.
	 */
	public void selectionishSort()
	{
		this.selectionishSort(true);
	}
	
	/**
	 * Selection sort one parameter helper method. Defaults both to the value of sortAscending
	 * @param sortAscending If true; sort ascending, if false; sort descending.
	 */
	public void selectionishSort(boolean sortAscending)
	{
		this.selectionishSort(sortAscending, sortAscending);
	}
	
	/**
	 * Selection sort delegation method. This algorithm needs to be split into two, as the size sort needs to be done before the lexical sort.
	 * @param sizeSortAscending    If true, sort ascending. If false, sort descending.
	 * @param lexicalSortAscending If true, sort ascending. If false, sort descending.
	 */
	public void selectionishSort(boolean sizeSortAscending, boolean lexicalSortAscending)
	{
	    // reset the array
		this.reset();
		// run the size sort
		this.selectionishSortSize(sizeSortAscending);
		// run the lexical sort
		this.selectionishSortLexical(lexicalSortAscending);
	}
	
	/**
	 * Selection sort based on the size of the words
	 * @param sortAscending If true, sort ascending. If false, sort descending.
	 */
	public void selectionishSortSize(boolean sortAscending)
	{
	    // loop forward to the second last word
		for(int i = 0; i < this.words.length - 1; i++)
		{
		    // assume the current index is the smallest word
			int min = i;
			// loop forward looking for words that are smaller than the current index
			for(int j = i+1; j < this.words.length; j++)
			{
			    // do the comparison
				if(this.words[j].length() < this.words[min].length() == sortAscending)
				{
				    // if the current word is smaller, we set min to it
					min = j;
				}
			}
			// now that we're done, if there is a swap to be done
			if(i != min)
			{
			    // swap
				this.swap(i, min);
			}
		}
	}
	
	/**
	 * This is the lexical sort method for the selection sort algorithm.
	 * @param sortAscending If true, sort ascending. If false, sort descending.
	 */
	public void selectionishSortLexical(boolean sortAscending)
	{
		// start at the start and move forward in blocks of same size text
		for(int i = 0; i < this.words.length-1; i++)
		{
		    // internal loop index
			int j = i;
			
			// assume that this is the word we're gonna swap
			int lexicalSwapIndex = i;
			
			// loop forward again but only while the next word is the same length as this word (and we have a next element)
			while(j < this.words.length - 1 && this.words[j].length() == this.words[j+1].length())
			{
			    // do the lexical comparison
				if(this.words[lexicalSwapIndex].compareToIgnoreCase(this.words[j+1]) > 0 == sortAscending)
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
				this.swap(i, lexicalSwapIndex);
			}
		}
	}
	
	/**
	 * A method to print out the array contents.
	 */
	public void printArrayContents()
	{
		for(int i = 0; i < this.words.length - 1; i++)
		{
			System.out.print(this.words[i]+", ");
		}
		System.out.println(this.words[this.words.length - 1]);
	}

	
}
