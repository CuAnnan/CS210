package Maze;


public class Driver
{
    public static void main(String[] args)
    {
        Maze maze = new Maze(40, 20);
        Explorer explorer = new Explorer(maze);
        explorer.startExploring();
        maze.draw();
    }
}
