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

		String[] words = "This is a pretty good random sentence of as yet undecided length and a good spread of letter lengths".split(" ");
		DictionarySorter d = new DictionarySorter(words.length);
		for(String s: words)
		{
		    d.addWord(s);
		}
		    
		    
		System.out.println("=== [Bubbleish sort] ===");
		d.reset();
		System.out.println("Unsorted dictionary:");
		d.printArrayContents();
		d.bubbleishSort(false);
		System.out.println("Sorted dictionary:");
		d.printArrayContents();
		System.out.println();
		
		System.out.println("=== [Selectionish sort] ===");
		d.reset();
		System.out.println("Unsorted dictionary: ");
		d.printArrayContents();
		d.selectionishSort(false);
		System.out.println("Sorted dictionary:");
		d.printArrayContents();
		System.out.println();
		
		System.out.println("=== [Insertionish sort] === ");
		d.reset();
		System.out.println("Unsorted dictionary: ");
		d.printArrayContents();
		d.insertionishSort(false);
		System.out.println("Sorted dictionary:");
		d.printArrayContents();
		
		sc.close();
	}
}
