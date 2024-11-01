package Lab4;
import java.util.Scanner;

public class LabDriver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Input data:");
//		
//		int n = Integer.parseInt(sc.nextLine());
//		
//		DictionarySorter d = new DictionarySorter(n);
//		for(int i = 0; i < n; i++)
//	    {
//		    d.addWord(sc.nextLine());
//	    }

		String[] words = "This is a pretty good random sentence of as yet undecided length and a good spread of letter lengths that I will randomise later with a Durstenfield Fisher Yates shuffling algorithm solid set of words that I can randomly pull from with varying lengths because that's what stream of consciousness gets you".split(" ");
		
		ArraySorter.setWordCount(words.length);
		for(String s: words)
		{
		    ArraySorter.addWord(s);
		}
		
		try
		{
		    ArrayBubbleSorter b = new ArrayBubbleSorter();
	        b.demonstrateSorting();
	        ArraySelectionSorter s = new ArraySelectionSorter();
	        s.demonstrateSorting();
	        ArrayInsertionSorter i = new ArrayInsertionSorter();
	        i.demonstrateSorting();
		}
		catch(StringsNotSetException e)
		{
		    System.out.println("Tried instantiating sorters with no array.");
		}
		
		sc.close();
		
	}
}
