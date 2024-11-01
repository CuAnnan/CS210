package Lab4;

class StringsNotSetException extends Exception
{
    /**
     * Eclipse said this was advised so I did it. UIDs are a thing, I guess.
     */
    private static final long serialVersionUID = 8358562907423591928L;

    public StringsNotSetException()
    {
        
    }
}


/**
 * Abstract method to define some shared methods and the one abstract method that needs implementing on the instance level. I figure that as we do more sorting algorithms this might be useful.
 * Assuming, that is, that we don't just move on to other data structures like Linked Lists and only write the sorting algorithms for those. Also. Neat idea. 
 * The words are stored in static arrays and this class has a bunch of helper methods.
 * 
 * @Author Eamonn "Wing" Kearns 60460770
 */
public abstract class ArraySorter
{
    /**
     * The words to be sorted
     */
    String[] words;
    /**
     * The unsorted form of the words. So that we can reset the array.
     */
    static String[] wordsBackup;
    /**
     * An index ticker for handing the adding of words.
     */
    static int index = 0;
    
    /**
     * Swap to entries in the array based on the indices of their locations in the array
     * @param i The first entry to swap
     * @param j The second entry to swap
     */
    public void swap(int i, int j)
    {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
    
    /**
     * A method to define the size of the static array to be sorted
     * @param n
     */
    public static void setWordCount(int n)
    {
        wordsBackup = new String[n];
        index = 0;
    }
    
    /**
     * Add a word to the array to be sorted
     * @param word
     */
    public static void addWord(String word)
    {
        wordsBackup[index] = word;
        index++;
    }
    
    /**
     * Constructor in an abstract class, weird I know. But I want to ensure that there's no flim flamming going on.
     * The constructor tries to copy the contents of the static array to the instance array.
     * @throws StringsNotSetException
     */
    public ArraySorter() throws StringsNotSetException
    {
        if(index == 0)
        {
            throw new StringsNotSetException();
        }
        this.words = new String[wordsBackup.length];
        System.arraycopy(wordsBackup, 0, words, 0, wordsBackup.length);
    }
    
    /**
     * A method to print out the content of the array
     */
    public void printArray()
    {
        String out = "";
        for(int i = 0; i < words.length - 1; i ++)
        {
            out += words[i]+", ";
        }
        out += words[words.length-1];
        System.out.println(out);
    }
    
    /**
     * Sort ascending helper function
     */
    public void sortAscending()
    {
        this.sort(true, true);
    }
    
    /**
     * Sort descending helper function
     */
    public void sortDescending()
    {
        this.sort(false, false);
    }
    
    /**
     * A method to demonstrate everything working
     */
    public void demonstrateSorting()
    {
        // print the name
        System.out.println(this.getClass().getName());
        // show the unsorted array
        System.out.println("Input Array:");
        this.printArray();
        
        // sort it one way
        this.sortAscending();
        
        // show the sorted ascending array
        System.out.println("Sorted Ascending:");
        this.printArray();
        
        // sort it the other way
        this.sortDescending();
        
        // print it again
        System.out.println("Sorted Descending:");
        this.printArray();
        
        // a new line for clean output
        System.out.println();
    }
    
    /**
     * Each implementation will need to have a workhorse sort function
     * @param sizeAscending     Whether to sort in word order size ascending or descending
     * @param lexicalAscending  Whether to sort lexically in ascending or descending order, when words are the same size.
     */
    public abstract void sort(boolean sizeAscending, boolean lexicalAscending);
    
}
