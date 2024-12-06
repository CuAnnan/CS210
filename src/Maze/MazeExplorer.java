package Maze;

import LinkedLists.LinkedList;

public class MazeExplorer
{
	Node currentNode;
	Maze maze;
	LinkedList<Node> visited;
	Node lastBranch;
	boolean endCellFound;
	
	public MazeExplorer(Maze maze)
	{
		this.maze = maze;
		visited = new LinkedList<Node>();
		currentNode = maze.getStartNode();
		lastBranch = currentNode;
		visited.push(currentNode);
	}
	
	public void explore()
	{
		if(currentNode == maze.getEndNode())
		{
			this.endCellFound = true;
			return;
		}
		
	}
}
