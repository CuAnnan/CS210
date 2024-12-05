package Maze;

public class Maze
{
    int width;
    int height;
    Node topLeft;
    
    public Maze()
    {
        this(50);
    }
    
    public Maze(int size)
    {
        this(size, size);
    }
    
    public Maze(int width, int height)
    {
        this.width = width;
        this.height = height;
        
        this.construct();
    }
    
    private void construct()
    {
        this.topLeft = new Node();
        Node current = this.topLeft;
        Node northNeighbour = null;
        
        
        for(int height = 0; height < this.height; height++)
        {
            Node leftMost = current;
            northNeighbour = current.getNeighbour(Direction.NORTH);
            for(int width = 1; width < this.width; width++)
            {
                 Node neighbour = new Node();
                 current.addNeighbour(Direction.EAST, neighbour);
                 if(northNeighbour != null)
                 {
                	 northNeighbour = northNeighbour.getNeighbour(Direction.EAST);
                     neighbour.addNeighbour(Direction.NORTH, northNeighbour);
                 }
                 current = neighbour;
            }
            
            if(height < this.height - 1)
            {
                current = new Node();
                leftMost.addNeighbour(Direction.SOUTH, current);
            }
        }
        
        this.topLeft.visited = true;
        this.topLeft.walk();
//        this.topLeft.walls[Direction.SOUTH] = false; 
//        this.topLeft.getNeighbour(Direction.SOUTH).visitFrom(Direction.NORTH);
    }
    
    public void draw()
    {
    	
    	
        Node current = this.topLeft;
        Node leftMost = current;
        Node previous = null;
        while(current != null)
        {
            while(current != null)
            {
            	System.out.print(current.getNorthWall());
            	previous = current;
            	current = current.getNeighbour(Direction.EAST);
            }
            
            System.out.println("█");
            
            current = leftMost;
            
            while(current != null)
            {
                System.out.print(current.getWestWall()+" ");
                previous = current;
                current = current.getNeighbour(Direction.EAST);
            }
            System.out.println(previous.getEastWall());
            
            if(leftMost.getNeighbour(Direction.SOUTH) != null)
            {
                leftMost = leftMost.getNeighbour(Direction.SOUTH);
                current = leftMost;
            }
        }
        
        current = leftMost;
        
        while(current != null)
        {
            System.out.print(current.getSouthWall());
            current = current.getNeighbour(Direction.EAST);
        }
        System.out.println("█");
        
    }
}
