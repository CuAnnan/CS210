package Maze;


public class Driver
{
    public static void main(String[] args)
    {
        Maze maze = new Maze(60, 10);
        maze.draw();
        MazeExplorer explorer = new MazeExplorer(maze);
        
    }
}
