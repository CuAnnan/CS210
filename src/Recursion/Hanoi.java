package Recursion;

class HanoiDisc
{
    char label;
    
    public char getLabel()
    {
        return label;
    }

    public void setLabel(char label)
    {
        this.label = label;
    }

    public HanoiDisc(char label)
    {
        this.label = label;
    }
}

class Tower
{
	HanoiDisc[] discs;
	int length;
	String name;
	
	public Tower(String name, int size)
	{
	    this.discs = new HanoiDisc[size];
	    this.name = name;
		this.length = 0;
	}
	
	public void addDisc(HanoiDisc disc)
	{
		this.discs[this.length++] = disc;
	}
	
	public HanoiDisc getDisc(int i)
	{
		return this.discs[i];
	}
	
	public HanoiDisc removeTopDisc()
	{
		return this.discs[--this.length];
	}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

public class Hanoi
{
    /**
     *  Three arrays of hanoi discs
     */
    Tower[] towers=new Tower[3];
    int size;
    int lastPrintLength;
    
    public Hanoi(int size)
    {
        towers[0] = new Tower("Tower 1", size);
        towers[1] = new Tower("Tower 2", size);
        towers[2] = new Tower("Tower 3", size);
        
        this.size = size;
        
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        for(int i = 0; i < size; i ++)
        {
            towers[0].addDisc(new HanoiDisc(alphabet.charAt(size - i - 1)));
        }
        
        
    }
    
    public void solve()
    {
        System.out.println("Starting state:");
        this.print();
    	swap(this.size, towers[0], towers[1], towers[2]);
    	System.out.println("Finished state:");
    	this.print();
    }
    
    public void swap(int n, Tower src, Tower intermediate, Tower destination)
    {
        if(n == 0)
    	{
            return;
    	}
        swap(n - 1, src, destination, intermediate);
        destination.addDisc(src.removeTopDisc());
        this.print();
        swap(n - 1, intermediate, src, destination);
    	
    }
    
    
    
    public void print()
    {
        
        String state = "    *         *         *\n";
        
        for(int i = this.size - 1; i >=0; i --)
        {
            for(int j = 0; j < 3; j++)
            {
                state +=  "   "+(towers[j].length <= i ? " * " : "["+towers[j].getDisc(i).label+"]")+"    ";
            }
            state += "\n";
            
        }
        state += " *******   *******   *******\n";
        System.out.println(state);
        this.lastPrintLength = state.length();
    }
    
    public static void main(String[] args)
    {
        Hanoi test = new Hanoi(5);
        test.solve();
    }
}
