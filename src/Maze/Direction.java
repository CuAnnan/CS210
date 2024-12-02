package Maze;

public class Direction
{
    static final int NORTH = 0;
    static final int EAST = 1;
    static final int SOUTH = 2;
    static final int WEST = 3;
    
    static String[] names = {"North", "East", "South", "West"};
    
    public static int getOpposite(int direction)
    {
        return (direction + 2) % 4; 
    }
    
    public static String getName(int direction)
    {
        return names[direction];
    }
    
}