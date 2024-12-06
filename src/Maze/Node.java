package Maze;

import java.util.Random;

public class Node
{
    Node[] neighbours;
    int numberOfNeighbours;
    boolean[] walls;
    boolean visited;
    boolean hasVisitor = false;
    boolean isStart = false;
    boolean isEnd = false;
    static Random rng;
    
    
    boolean explored = false;
    boolean exploring = false;
    
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
    	return this.walls[Direction.WEST]?"┃":" ";
    }
    
    public String getEastWall()
    {
    	return this.walls[Direction.EAST]?"┃":" ";
    }
    
    public String getSouthWall()
    {
    	return this.getSouthWestWall()+(this.walls[Direction.SOUTH]?"━":" ")+(this.neighbours[Direction.EAST] == null?"┛":"");
    }
    
    public String getSouthWestWall()
    {
    	String wall="┻";
    	
    	
    	if(this.neighbours[Direction.WEST] == null)
    	{
    		wall = "┗";
    	}
    	else if(!this.walls[Direction.WEST])
        {
            wall = "━";
        }
            	
    	return wall;
    }
    
    public String getNorthEastEdgeWall()
    {
        String wall = "┫";
        if(this.neighbours[Direction.NORTH] == null)
        {
            wall = "┓";
        }
        else if(!this.walls[Direction.NORTH])
        {
            wall = "┃";
        }
        
        return wall;
    }
    
    public String getNorthWestWall()
    {
    	String wall="╋";
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
    			wall = "╺";
    			break;
    		case 0b0010:
    			wall = "╻";
    			break;
    		case 0b0011:
    			wall = "┏";
    			break;
    		case 0b0100:
    			wall = "╸";
    			break;
    		case 0b0101:
    			wall = "━";
    			break;
    		case 0b0110:
    			wall = "┓";
    			break;
    		case 0b0111:
    			wall = "┳";
    			break;
    		case 0b1000:
    			wall = "╹";
    			break;
    		case 0b1001:
    			wall = "┗";
    			break;
    		case 0b1010:
    			wall = "┃";
    			break;
    		case 0b1011:
    			wall = "┣";
    			break;
    		case 0b1100:
    			wall = "┛";
    			break;
    		case 0b1101:
    			wall = "┻";
    			break;
    		case 0b1110:
    			wall = "┫";
    			break;
    	}
    	return ""+wall;
    }
    
    public String getNorthWall()
    {
    	return this.getNorthWestWall() + (this.walls[Direction.NORTH]?"━":" ") + (this.neighbours[Direction.EAST]== null?this.getNorthEastEdgeWall():"");
    }
    
    public String getContents()
    {
        if(this.hasVisitor)
        {
            return Color.Background.BLUE+Color.Foreground.Bold.Bright.CYAN+"*"+Color.RESET;
        }
        if(this.isStart)
        {
            return Color.Foreground.RED+"S"+Color.RESET;
        }
        if(this.isEnd)
        {
            return Color.Background.RED+""+Color.Foreground.Bold.Bright.YELLOW+"E"+Color.RESET;
        }
        
        return " ";
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
        
        int index = rng.nextInt(unvisited.length);
        return unvisited[index];
    }
    
    public boolean isVisited()
    {
        return this.visited;
    }
    
    public int getUnexploredNeighbourCount()
    {
    	int n = 0;
    	for(int i = 0; i < this.walls.length; i++)
    	{
    		if(!this.walls[i] && !this.neighbours[i].explored)
    		{
    			n++;
    		}
    	}
    	return n;
    }
    
    public boolean hasUnexploredNeighbours()
    {
    	return this.getUnexploredNeighbourCount() > 0;
    }
    
    public Node getRandomUnexploredNeighbour()
    {
    	int n = this.getUnexploredNeighbourCount();
    	if(n == 0)
    	{
    		return null;
    	}
    	
    	Node[] unexplored = new Node[n];
    	int i = 0;
    	for(int j = 0; j < this.walls.length; j++)
    	{
    		if(!this.walls[j] && !this.neighbours[j].explored)
    		{
    			unexplored[i++] = this.neighbours[j];
    		}
    	}
    	return unexplored[rng.nextInt(0, n - 1)];
    }
}
