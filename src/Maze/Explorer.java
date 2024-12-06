package Maze;

import LinkedLists.LinkedList;

public class Explorer
{
	Cell current;
	Maze maze;
	LinkedList<Cell> visited;
	Cell lastBranch;
	boolean endCellFound;
	
	public Explorer(Maze maze)
	{
		this.maze = maze;
		visited = new LinkedList<Cell>();
		current = maze.getStartNode();
		lastBranch = current;
		visited.push(current);
	}
	
	public void explore()
	{
		if(current == maze.getEndNode())
		{
			this.endCellFound = true;
			return;
		}
		if(current.hasUnexploredNeighbours())
		{
		    Cell neighbour = current.getRandomUnexploredNeighbour();
		    this.visited.push(neighbour);
		    this.current = neighbour;
		    this.explore();
		}
		else
		{
		     
		}
	}
}
