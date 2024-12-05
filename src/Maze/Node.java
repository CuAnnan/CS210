package Maze;

import java.util.Random;

public class Node
{
    Node[] neighbours;
    int numberOfNeighbours;
    boolean[] walls;
    boolean visited;
    
    
    public Node()
    {
        neighbours = new Node[] {null, null, null, null};
        this.walls = new boolean[] {true, true, true, true};
        this.numberOfNeighbours = 0;
        this.visited = false;
    }
    
    public void addNeighbour(int direction, Node neighbour)
    {
        neighbours[direction] = neighbour;
        if(neighbour != null)
        {
            neighbour.neighbours[Direction.getOpposite(direction)] = this;
        }
    }
    
    public Node getNeighbour(int direction)
    {
        return neighbours[direction];
    }
    
    public boolean hasNeighbour(int direction)
    {
    	return this.neighbours[direction] != null;
    }
    
    public void walk()
    {
    	int direction = this.getRandomUnvisitedDirection();
        
        if(direction < 0)
        {
            return;
        }
        else
        {
        	this.walls[direction] = false;
            this.neighbours[direction].visitFrom(Direction.getOpposite(direction));
            this.neighbours[direction].walk();
            this.walk();
        }
    }
    
    public String getWestWall()
    {
    	return this.walls[Direction.WEST]?"│":" ";
    }
    
    public String getEastWall()
    {
    	return this.walls[Direction.EAST]?"│":" ";
    }
    
    public String getSouthWall()
    {
    	return this.getSouthWestWall()+(this.walls[Direction.SOUTH]?"─":" ");
    }
    
    public String getSouthWestWall()
    {
    	char wall='┼';
    	int wallsInCorner = 0B0;
    	if(this.walls[Direction.SOUTH])
    	{
    		wallsInCorner += 0B0001; 
    	}
    	if(this.walls[Direction.WEST])
    	{
    		wallsInCorner += 0B0010;
    	}
    	if(this.neighbours[Direction.WEST]!= null && this.neighbours[Direction.WEST].hasWall(Direction.NORTH))
    	{
    		wallsInCorner += 0B0100;
    	}
    	if(this.neighbours[Direction.NORTH]!= null && this.neighbours[Direction.NORTH].hasWall(Direction.WEST))
    	{
    		wallsInCorner += 0B1000;
    	}
    	
    	switch(wallsInCorner)
    	{
    		case 0b0001:
    			wall = '╶';
    			break;
    		case 0b0010:
    			wall = '│';
    			break;
    		case 0b0011:
    			wall = '┌';
    			break;
    		case 0b0100:
    			wall = '╴';
    			break;
    		case 0b0101:
    			wall = '─';
    			break;
    		case 0b0110:
    			wall = '┐';
    			break;
    		case 0b0111:
    			wall = '┬';
    			break;
    		case 0b1000:
    			wall = '╵';
    			break;
    		case 0b1001:
    			wall = '└';
    			break;
    		case 0b1010:
    			wall = '│';
    			break;
    		case 0b1011:
    			wall = '├';
    			break;
    		case 0b1100:
    			wall = '┘';
    			break;
    		case 0b1101:
    			wall = '┴';
    			break;
    		case 0b1110:
    			wall = '┤';
    			break;
    	}
    	return ""+wall;
    }
    
    public String getNorthWestWall()
    {
    	char wall='┼';
    	int wallsInCorner = 0B0;
    	if(this.walls[Direction.NORTH])
    	{
    		wallsInCorner += 0B0001; 
    	}
    	if(this.walls[Direction.WEST])
    	{
    		wallsInCorner += 0B0010;
    	}
    	if(this.neighbours[Direction.WEST]!= null && this.neighbours[Direction.WEST].hasWall(Direction.NORTH))
    	{
    		wallsInCorner += 0B0100;
    	}
    	if(this.neighbours[Direction.NORTH]!= null && this.neighbours[Direction.NORTH].hasWall(Direction.WEST))
    	{
    		wallsInCorner += 0B1000;
    	}
    	
    	switch(wallsInCorner)
    	{
    		case 0b0001:
    			wall = '╶';
    			break;
    		case 0b0010:
    			wall = '│';
    			break;
    		case 0b0011:
    			wall = '┌';
    			break;
    		case 0b0100:
    			wall = '╴';
    			break;
    		case 0b0101:
    			wall = '─';
    			break;
    		case 0b0110:
    			wall = '┐';
    			break;
    		case 0b0111:
    			wall = '┬';
    			break;
    		case 0b1000:
    			wall = '╵';
    			break;
    		case 0b1001:
    			wall = '└';
    			break;
    		case 0b1010:
    			wall = '│';
    			break;
    		case 0b1011:
    			wall = '├';
    			break;
    		case 0b1100:
    			wall = '┘';
    			break;
    		case 0b1101:
    			wall = '┴';
    			break;
    		case 0b1110:
    			wall = '┤';
    			break;
    	}
    	return ""+wall;
    }
    
    public String getNorthWall()
    {
    	return this.getNorthWestWall() + (this.walls[Direction.NORTH]?"─":" ");
    }
    
    public boolean hasWall(int direction)
    {
    	return this.walls[direction];
    }
    
    public void visitFrom(int direction)
    {
        this.visited = true;
        this.walls[direction] = false;
    }
    
    
    
    public int getRandomUnvisitedDirection()
    {
        int unvisitedNeighbours = 0;
        
        for(int i = 0; i < this.neighbours.length; i++)
        {
            Node n = this.neighbours[i];
            
            if(n != null && !n.visited)
            {
                unvisitedNeighbours++;
            }
        }
        
        if(unvisitedNeighbours == 0)
        {
            return -1;
        }
        int[] unvisited = new int[unvisitedNeighbours];
        
        unvisitedNeighbours = 0;
        for(int i = 0; i < this.neighbours.length; i++)
        {
            Node n = this.neighbours[i];
            if(n != null && !n.visited)
            {
                unvisited[unvisitedNeighbours] = i;
                unvisitedNeighbours ++;
            }
        }
        
        Random r = new Random();
        int index = r.nextInt(unvisited.length);
        return unvisited[index];
    }
    
    public boolean isVisited()
    {
        return this.visited;
    }
}
