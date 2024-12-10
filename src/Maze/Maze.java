package Maze;

import java.util.Random;

public class Maze
{
    int width;
    int height;
    Cell topLeft;
    Cell bottomRight;
    Random rng;
    boolean randomSeeded = false;
    int backFillAmount = 0;
    
    
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
        this(width, height, 0);
    }

    public Maze(int width, int height, int backFillAmount)
    {
        this(width, height, backFillAmount,0);
    }
    
    public Maze(int width, int height, int backFillAmount, long randomSeed)
    {
        this.width = width;
        this.height = height;
        
        if(this.randomSeeded)
        {
            this.rng = new Random(randomSeed);
        }
        else
        {
            this.rng = new Random();
        }
        Cell.rng = this.rng;
        this.backFillAmount = backFillAmount;
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
        this.topLeft.isStart = true;
        this.bottomRight.isEnd = true;
        this.topLeft.walk();
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
        System.out.println();
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
