package Recursion;

public class Recursion
{
	public static int factorial(int n)
	{
		if(n <= 1)
		{
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	public static int triangular(int n)
	{
		if(n <= 1)
		{
			return 1;
		}
		return n + triangular(n - 1);
	}
	
	
	public static void main(String[] args)
	{
		
	}
}
