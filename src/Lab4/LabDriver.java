package Lab4;
import java.util.Scanner;
import java.util.Random;

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
		
//		Random r = new Random();
        
//		for(int i = words.length - 1; i > 1; i--)
//		{
//		    String temp = words[i];
//		    int index = r.nextInt(i + 1);
//		    words[i] = words[index];
//		    words[index] = temp;
//		}
//		
//		int n = r.nextInt(10) + 10;
//		String[] wordsToSort = new String[n];
//		System.arraycopy(words, 0, wordsToSort, 0, n);

		
		Sorter.setWordCount(words.length);
		for(String s: words)
		{
		    Sorter.addWord(s);
		}
		
		BubbleSorter b = new BubbleSorter();
		b.demo();
		
		SelectionSorter s = new SelectionSorter();
		b.demo();
        
		InsertionSorter i = new InsertionSorter();
		i.demo();
		
//		
//		
//		
//		DictionarySorter d = new DictionarySorter(words.length);
//		for(String s: words)
//		{
//		    d.addWord(s);
//		}
//		
//		System.out.println("=== [Selectionish sort] ===");
//		d.reset();
//		System.out.println("Unsorted dictionary: ");
//		d.printArrayContents();
//		d.selectionishSort(false);
//		System.out.println("Sorted dictionary in "+(end - start)+" ms:");
//		d.printArrayContents();
//		System.out.println();
//		
//		System.out.println("=== [Insertionish sort] === ");
//		d.reset();
//		System.out.println("Unsorted dictionary: ");
//		d.printArrayContents();
//		d.insertionishSort(false);
//		System.out.println("Sorted dictionary in "+(end - start)+" ms:");
//		d.printArrayContents();
//		
//		sc.close();
	}
}
