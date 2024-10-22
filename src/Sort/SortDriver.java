package Sort;

public class SortDriver
{
	public static void main(String[] args)
	{
		Sorter s = new Sorter(new int[] {2, 6, 1, 68, 29, -1});
		System.out.println("Unsorted:");
		s.printArray();
		System.out.println("Bubble sort:");
		s.bubbleSort();
		s.printArray();
		s.setArray(new int[] {2, 6, 1, 68, 29, -1});
		System.out.println("\nReset\n");
		System.out.println("Unsorted:");
		s.printArray();
		System.out.println("Selection sort:");
		s.selectionSort();
		s.printArray();
	}
}
