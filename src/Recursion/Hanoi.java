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
	public Tower(int size)
	{
		this.discs = new HanoiDisc[size];
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
}

public class Hanoi
{
    /**
     *  Three arrays of hanoi discs
     */
    Tower tower1, tower2, tower3;
    
    int size;
    
    public Hanoi(int size)
    {
        tower1 = new Tower(size);
        tower2 = new Tower(size);
        tower3 = new Tower(size);
        
        this.size = size;
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i = 0; i < size; i ++)
        {
            tower1.addDisc(new HanoiDisc(alphabet.charAt(size - i - 1)));
        }
        
        
    }
    
    public void solve()
    {
    	swap(this.size, tower1, tower2, tower3);
    }
    
    public void swap(int n, Tower src, Tower intermediate, Tower destination)
    {
    	if(n == 1)
    	{
    		destination.addDisc(src.removeTopDisc());
    		return;
    	}
    	swap(n - 1, src, destination, intermediate);
    	swap(n - 1, intermediate, src, destination);
    }
    
    
    
    public void print()
    {
        System.out.println("        *         *         *");
        
        for(int i = this.size - 1; i >=0; i --)
        {
        	String label1 = tower1.length <= i ? " * " : "["+tower1.getDisc(i).label+"]";
            String label2 = tower2.length <= i ? " * " : "["+tower2.getDisc(i).label+"]";
            String label3 = tower3.length <= i ? " * " : "["+tower3.getDisc(i).label+"]";
            
            System.out.println(
                    "       "+label1+
                    "       "+label2+
                    "       "+label3
            );
        }
        System.out.println("    ********* ********* *********");
    }
    
    public static void main(String[] args)
    {
        Hanoi test = new Hanoi(5);
        test.print();
        test.solve();
        test.print();

    }
}
