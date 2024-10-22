package Lab3;

public class AtkinSieve
{
	final static int LIMIT = 10000000;
	
	static boolean[] isPrime = new boolean[LIMIT];
	
	// set of wheel hit positions
	static int[] s = {1, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 46, 53, 59};
	// mod 60 quad 4 1 hits
	static int[] s2 = {1, 13, 17, 29, 37, 41, 49, 53};
	// mod 60 quad 3 hits
	static int[] s3 = {7, 19, 31, 43};
	// mod 60 quad 3 x - y hits
	static int[] s4 = {11, 23, 47, 59};
	
	
	
	static void populate()
	{
		int w = (int)Math.floor(LIMIT/60.0);
		isPrime[2] = true;
		isPrime[3] = true;
		isPrime[5] = true;
		
		
		
	}
	
	static int quadraticModulus(int xCoefficient, int x, int yCoefficient, int y)
	{
		return (xCoefficient * x * x + yCoefficient * y * y) % 60;
	}
	
}
