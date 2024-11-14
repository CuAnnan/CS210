package LinkedList;

public class Driver
{
    public static void main(String[] args)
    {
        LinkedList<Integer> l = new LinkedList<Integer>();
        for(int i = 0; i < 20; i++)
        {
            l.add(i);
        }
        try
        {
            LinkedList<Integer> l4 = l.slice(0);
            l.debug();
            l4.debug();
            l4.set(6, 78);
            l.debug();
            l4.debug();
            Node<Integer> n = l4.remove(5);
            System.out.println(n.getContents());
            l4.debug();
            
        }
        catch(Exception e)
        {
            e.printStackTrace(System.out);
        }
    }

}
