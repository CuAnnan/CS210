package Maze;

import LinkedLists.LinkedList;

public class Explorer
{
	Cell current;
	Maze maze;
	LinkedList<Cell> searchPath;
	Cell lastBranch;
	boolean endCellFound;
	
	public Explorer(Maze maze)
	{
		this.maze = maze;
		searchPath = new LinkedList<Cell>();
		current = maze.getStartNode();
		lastBranch = current;
		searchPath.push(current);
	}
	
	public void startExploring()
	{
	    long startTime = System.currentTimeMillis();
	    this.explore();
	    long solveTime = System.currentTimeMillis();
	    System.out.println((solveTime - startTime) +"ms to solve");
	    this.markExplored();
	    long markTime = System.currentTimeMillis();
	    System.out.println((markTime - solveTime)+ "ms to update search path");
	}
	
	public void explore()
	{
		if(current == maze.getEndNode())
		{
			return;
		}
		if(current.hasUnexploredNeighbours())
		{
		    Cell neighbour = current.getRandomUnexploredNeighbour();
		    this.searchPath.push(neighbour);
		    neighbour.explored = true;
		    this.current = neighbour;
		    this.explore();
		}
		else
		{
			this.current.isDeadEnd = true;
		    this.searchPath.pop();
		    this.current = this.searchPath.getHead().getContents();
		    this.explore();
		}
	}
	
	public void markExplored()
	{
	    Cell current = this.searchPath.pop();
	    while(current != null)
	    {
	        current.solution = true;
	        current = this.searchPath.pop();
	    }
	}
}
