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
	    // 
        this.reset();
        System.out.println("Size sort ascending: "+sizeSortAscending);
        System.out.println("Lexical sort ascendign: ");
        for(int i = 1; i < this.words.length; i++)
        {
            boolean searching = true;
            int j = i;
            
            do
            {
                if(words[j-1].length()==words[j].length())
                {
                    if(words[j-1].compareToIgnoreCase(words[j]) > 0 == lexicalSortAscending)
                    {
                        this.swap(j-1, j);                        
                    }
                }
                else if(words[j-1].length() > words[j].length() == sizeSortAscending)
                {
                    this.swap(j-1, j);
                }
                
                
                j--;
                if(j == 0)
                {
                    searching = false;
                }
            }while(searching);
        }
	}
	
	public void selectionishSort()
	{
		this.selectionishSort(true);
	}
	
	public void selectionishSort(boolean sortAscending)
	{
		this.selectionishSort(sortAscending, sortAscending);
	}
	
	public void selectionishSort(boolean sizeSortAscending, boolean lexicalSortAscending)
	{
		this.reset();
		this.selectionishSortSize(sizeSortAscending);
		this.selectionishSortLexical(lexicalSortAscending);
	}
	
	public void selectionishSortSize(boolean sortAscending)
	{
		for(int i = 0; i < this.words.length - 1; i++)
		{
			int min = i;
			for(int j = i+1; j < this.words.length; j++)
			{
				if(
					this.words[j].length() < this.words[min].length() == sortAscending
				)
				{
					min = j;
				}
			}
			if(i != min)
			{
				this.swap(i, min);
			}
		}
	}
	
	public void selectionishSortLexical(boolean sortAscending)
	{
		// start at the start and move forward in blocks of same size text
		for(int i = 0; i < this.words.length-1; i++)
		{
			int j = i;
			int shortest = i;
			while(j < this.words.length - 1 && this.words[j].length() == this.words[j+1].length())
			{
				if(this.words[shortest].compareToIgnoreCase(this.words[j+1]) > 0 == sortAscending)
				{
					shortest = j+1;
				}
				j++;
			}
			
			if(shortest != i)
			{
				this.swap(i, shortest);
			}
		}
	}
	
	public void printArrayContents()
	{
		for(int i = 0; i < this.words.length - 1; i++)
		{
			System.out.print(this.words[i]+", ");
		}
		System.out.println(this.words[this.words.length - 1]);
	}

	
}
