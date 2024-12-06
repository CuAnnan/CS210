package Maze;

import java.util.Random;

public class Maze
{
    int width;
    int height;
    Cell topLeft;
    Cell bottomRight;
    Random rng;
    
    
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
        this(width, height, 1337);
    }
    
    public Maze(int width, int height, long randomSeed)
    {
        this.width = width;
        this.height = height;
        
        this.rng = new Random(randomSeed);
        Cell.rng = this.rng;
        
        this.construct();
    }
    
    private void construct()
    {
        this.topLeft = new Cell();
        Cell current = this.topLeft;
        Cell northNeighbour = null;
        
        
        for(int height = 0; height < this.height; height++)
        {
            Cell leftMost = current;
            northNeighbour = current.getNeighbour(Direction.NORTH);
            for(int width = 1; width < this.width; width++)
            {
                 Cell neighbour = new Cell();
                 current.addNeighbour(Direction.EAST, neighbour);
                 if(northNeighbour != null)
                 {
                	 northNeighbour = northNeighbour.getNeighbour(Direction.EAST);
                     neighbour.addNeighbour(Direction.NORTH, northNeighbour);
                 }
                 current = neighbour;
                 this.bottomRight = current;
            }
            
            if(height < this.height - 1)
            {
                current = new Cell();
                leftMost.addNeighbour(Direction.SOUTH, current);
            }
        }
        
        this.topLeft.visited = true;
        this.topLeft.walk();
        this.topLeft.isStart = true;
        this.bottomRight.isEnd = true;
        this.topLeft.hasVisitor = true;
        
//        this.topLeft.walls[Direction.SOUTH] = false; 
//        this.topLeft.getNeighbour(Direction.SOUTH).visitFrom(Direction.NORTH);
    }
    
    public void draw()
    {
    	Cell current = this.topLeft;
        Cell leftMost = current;
        Cell previous = null;
        while(current != null)
        {
            
            while(current != null)
            {
            	System.out.print(current.getNorthWall());
            	previous = current;
            	current = current.getNeighbour(Direction.EAST);
            }
            System.out.println();
            
            current = leftMost;
            
            while(current != null)
            {
                System.out.print(current.getWestWall()+current.getContents());
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
        
        
    }
    
    public Cell getStartNode()
    {
    	return this.topLeft;
    }
    
    public Cell getEndNode()
    {
    	return this.bottomRight;
    }
}
