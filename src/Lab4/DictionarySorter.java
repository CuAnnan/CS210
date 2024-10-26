package Lab4;

/**
 * 
 */
public class DictionarySorter
{
	private String[] words;
	private String[] wordsBackup;
	private int index=0;
	
	public DictionarySorter(int dictionarySize)
	{
		words = new String[dictionarySize];
		wordsBackup = new String[dictionarySize];
	}
	
	public void addWord(String word)
	{
		words[index]=word;
		wordsBackup[index] = word;
		index++;
	}
	
	public void reset()
	{
		System.arraycopy(wordsBackup, 0, words, 0, index);
	}
	
	public void swap(int i, int j)
	{
		String temp = this.words[i];
		this.words[i] = this.words[j];
		this.words[j] = temp;
	}
	
	public void bubbleishSort()
	{
		this.bubbleishSort(true);
	}
	
	
	
	public void bubbleishSort(boolean lengthOrder)
	{
		this.bubbleishSort(lengthOrder, lengthOrder);
	}

	public void bubbleishSort(boolean lengthOrder, boolean wordOrder)
	{
		this.reset();
		for(int i = 0; i < this.words.length - 1; i++)
		{
			for(int j = 0; j < this.words.length - i - 1; j++)
			{
				if(
					(
						this.words[j].length() == this.words[j+1].length() &&
						this.words[j].compareToIgnoreCase(this.words[j+1]) > 0 == wordOrder
					)
					||
					(this.words[j].length() > this.words[j+1].length() == lengthOrder)
				)
				{
					this.swap(j, j+1);
				}
			}
		}
	}
	
	public void insertionishSort()
	{
		this.insertionishSort(true);
	}
	
	public void insertionishSort(boolean sortAscending)
	{
		this.insertionishSort(sortAscending, sortAscending);
	}
	
	public void insertionishSort(boolean sizeSortAscending, boolean lexicalSortAscending)
	{
		this.reset();
		for(int i = 1; i < this.words.length; i++)
		{
			boolean searching = true;
			int j = i;
			
			do
			{
				if(
						words[j-1].length() > words[j].length() == sizeSortAscending
						||
						(
							words[j-1].length() == words[j].length()
							&&
							words[j-1].compareToIgnoreCase(words[j]) > 0 == lexicalSortAscending
						)
				)
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
