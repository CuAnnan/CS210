package Lab4;

public class InsertionSorter extends Sorter
{
    public void reset()
    {
        System.out.println("Insertion Sorter");
        super.reset();
    }
    
    public void sort(boolean sizeAscending, boolean lexicalAscending)
    {
     // loop forward through the words from the second to the last  
        for(int i = 1; i < words.length; i++)
        {
            // this is a boolean to allow us to search forward until we're done
            boolean searching = true;
            // set the start of the backwards search to the 
            int j = i;
            
            // loop back and swap until we no longer meet a valid swap
            do
            {
                // while I'd love to do this as a single if statement (and it is possible) the if statement becomes unwieldy
                // so what we do is check if they're equal length
                if(words[j-1].length()==words[j].length())
                {
                    // and if they are and the lexical sorting needs to be done
                    if(words[j-1].compareToIgnoreCase(words[j]) > 0 == lexicalAscending)
                    {
                        // we swap them
                        swap(j, j-1);
                    }
                }
                // otherwise if the size sort needs to be done
                else if(words[j-1].length() > words[j].length() == sizeAscending)
                {
                    // we swap them
                    swap(j, j-1);
                }
                else
                {
                    // if the size swap doesn't need to be done, the list is as sorted as this outer loop will allow
                    searching = false;
                }
                
                // decrease the inner loop counter
                j--;
                if(j == 0)
                {
                    // if we're out of possible indices, then this is the smallest value for this loop and the internal search loop is done
                    searching = false;
                }
            }while(searching);
        }
    }
}
