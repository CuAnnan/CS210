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

public class Hanoi
{
    /**
     *  Three arrays of hanoi discs
     */
    HanoiDisc[] stack1, stack2, stack3;
    
    int size;
    
    public Hanoi(int size)
    {
        stack1 = new HanoiDisc[size];
        stack2 = new HanoiDisc[size];
        stack3 = new HanoiDisc[size];
        
        this.size = size;
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        for(int i = 0; i < size; i ++)
        {
            stack1[i] = new HanoiDisc(alphabet.charAt(size - i - 1));
        }
    }
    
    public void print()
    {
        System.out.println("        *        *        *");
        
        for(int i = this.size - 1; i >=0; i --)
        {
            String label1 = stack1[i] == null?" * ":"["+stack1[i].label+"]";
            String label2 = stack2[i] == null?" * ":"["+stack2[i].label+"]";
            String label3 = stack3[i] == null?" * ":"["+stack3[i].label+"]";
            
            System.out.println(
                    "       "+label1+
                    "      "+label2+
                    "      "+label3
            );
        }
        System.out.println("    ********* ********* *********");
    }
    
    public static void main(String[] args)
    {
        Hanoi test = new Hanoi(3);
        test.print();
    }
}
