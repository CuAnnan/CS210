package Lab4;

public abstract class Sorter
{
    static String[] words;
    static String[] wordsBackup;
    
    static int index = 0;
    
    static boolean sortSizeAscending = true;
    static boolean sortLexicalAscending = true;
    
    public static void swap(int i, int j)
    {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
    
    public static void setWordCount(int n)
    {
        words = new String[n];
        wordsBackup = new String[n];
        index = 0;
    }
    
    public static void addWord(String word)
    {
        words[index] = word;
        wordsBackup[index] = word;
        index++;
    }
    
    public void reset()
    {
        System.arraycopy(wordsBackup, 0, words, 0, wordsBackup.length);
        sortSizeAscending = true;
        sortLexicalAscending = true;
    }
    
    
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
    
    public void sortAscending()
    {
        this.sort(true, true);
    }
    
    public void sortDescending()
    {
        this.sort(false, false);
    }
    
    public void sort()
    {
        sort(sortSizeAscending, sortLexicalAscending);
    }
    
    public void demo()
    {
        this.reset();

        System.out.println("Input Array:");
        this.printArray();
        
        this.sortAscending();
        System.out.println("Sorted Ascending:");
        this.printArray();
        
        this.sortDescending();
        System.out.println("Sorted Descending:");
        this.printArray();
        
        System.out.println();
    }
    
    public abstract void sort(boolean sizeAscending, boolean lexicalAscending);
    
}
