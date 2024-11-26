package Recursion;

import java.util.concurrent.TimeUnit;

/**
 * Very primitive stack class to handle the towers themselves. This *could* have been done with just arrays but this provided some nice debugging potential.
 * @author Éamonn "Wing" Kearns 60460770
 */
class Tower
{
    /**
     * The chars representing the named tiles being stored
     */
	char[] discs;
	/**
	 * The number of tiles on this stack, used for rendering
	 */
	int length;
	/**
	 * The name of the tower (used for debugging)
	 */
	String name;
	
	/**
	 * Constructor
	 * @param name The name of the tower
	 * @param size The maximum size of the tower. Used to instantiate the array.
	 */
	public Tower(String name, int size)
	{
	    this.discs = new char[size];
	    this.name = name;
		this.length = 0;
	}
	
	/**
	 * Adder. Adds to the last element of the array.
	 * @param disc
	 */
	public void addDisc(char disc)
	{
		this.discs[this.length++] = disc;
	}
	
	/**
	 * Getter for an individual index
	 * @param i
	 * @return
	 */
	public char getDisc(int i)
	{
		return this.discs[i];
	}
	
	/**
	 * Pop a disc off the last space
	 * @return
	 */
	public char removeTopDisc()
	{
		return this.discs[--this.length];
	}

	/**
	 * Get the name
	 * @return
	 */
    public String getName()
    {
        return name;
    }

}

/**
 * Towers of Hanoi simulator. Prints out each stage. Done as part of the Recursion part of the lectures.
 * @author Éamonn "Wing" Kearns 60460770
 */

public class Hanoi
{
    /**
     *  Three arrays of hanoi discs
     */
    Tower[] towers=new Tower[3];
    int size;
    
    /**
     * This throws an exception if you run out of characters from the alphabet, putting a hard cap of 26 tiles on the tower.
     * But given that would be O(2^26), I'm okay with that. 
     * @param size
     */
    public Hanoi(int size)
    {
        /*
         * Instantiate out towers
         */
        towers[0] = new Tower("Tower 1", size);
        towers[1] = new Tower("Tower 2", size);
        towers[2] = new Tower("Tower 3", size);
        
        /*
         * Store the size as a property, we use this in the print method
         */
        this.size = size;
        
        /*
         * Name the towers alphabetically
         */
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        /**
         * populate the first tower
         */
        for(int i = 0; i < size; i ++)
        {
            towers[0].addDisc(alphabet.charAt(size - i - 1));
        }
    }
    
    /**
     * Solve kickstarter. Calls swap with the original tower and full size
     */
    public void solve()
    {
        System.out.println("Starting state:");
        this.print();
    	swap(this.size, towers[0], towers[1], towers[2]);
    	System.out.println("Finished state:");
    	this.print();
    }
    
    /**
     * @param n             This is used as the simplest possible anchor case. It also helps with output
     * @param src           The tower to move the tile from
     * @param intermediate  The tower to use as a swap space
     * @param destination   The tower to end the substack on
     */
    public void swap(int n, Tower src, Tower intermediate, Tower destination)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(300);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // base case
        if(n == 0)
    	{
            return;
    	}
        // swap a substack to the intermediate tower
        swap(n - 1, src, destination, intermediate);
        // Do the swap of the single tile
        destination.addDisc(src.removeTopDisc());
        // print out the state
        this.print();
        // swap it to its destination
        swap(n - 1, intermediate, src, destination);
    }
    
    
    
    public void print()
    {
        String state="    *         *         *\n";
        
        for(int i = this.size - 1; i >=0; i --)
        {
            for(int j = 0; j < 3; j++)
            {
                state +=  "   "+(towers[j].length <= i ? " * " : "["+towers[j].getDisc(i)+"]")+"    ";
            }
            state += "\n";
            
        }
        state += " *******   *******   *******\n";
        
        System.out.println(state);

    }
    
    public static void main(String[] args)
    {
        Hanoi test = new Hanoi(5);
        test.solve();
    }
}
