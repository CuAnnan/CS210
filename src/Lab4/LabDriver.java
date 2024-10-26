package Lab4;

public class LabDriver
{
	public static void main(String[] args)
	{
		String[] words = "This is a pretty good random spread of words to test on".split(" ");
		DictionarySorter d = new DictionarySorter(words.length);
		for(String word: words)
		{
			d.addWord(word);
		}
		
		System.out.println("=== [Bubbleish sort] ===");
		d.reset();
		System.out.println("Unsorted dictionary:");
		d.printArrayContents();
		d.bubbleishSort();
		System.out.println("Sorted dictionary:");
		d.printArrayContents();
		
		System.out.println("=== [Selectionish sort] ===");
		d.reset();
		System.out.println("Unsorted dictionary: ");
		d.printArrayContents();
		d.selectionishSort();
		System.out.println("Sorted dictionary:");
		d.printArrayContents();
		
		System.out.println("=== [Insertionish sort] === ");
		d.reset();
		System.out.println("Unsorted dictionary: ");
		d.printArrayContents();
		d.insertionishSort();
		System.out.println("Sorted dictionary:");
		d.printArrayContents();
	}
}
