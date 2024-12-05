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
