package Lab3;

public class EratosthanesSieve
{
	// both 0 and 1 are considered prime.
	static boolean[] isPrime;
	final static int LIMIT = 20000000;
	final static int SQRT_LIMIT = (int)Math.sqrt(LIMIT);
	static int[] primes;
	static boolean populated = false;
	static int largestPrime;
	static int numberOfPrimes = 0;
	
	public static void populate()
	{
		// only populate once
		if(populated)
		{
			return;
		}
		// initialise an array
		isPrime = new boolean[LIMIT];
		
		// default it to true
		for(int i = 0; i < LIMIT; i++)
		{
			isPrime[i] = true;
		}
		
		// 0 and 1 are not prime
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i = 2; i < SQRT_LIMIT; i++)
		{
			for(int j = i*i; j < LIMIT; j+=i)
			{
				// set the square of i + j*i to be non prime
				isPrime[j] = false;
			}
		}
		
		// count the primes we have so we can populate the array
		
		for(int i = 0; i < isPrime.length; i++)
		{
			if(isPrime[i])
			{
				numberOfPrimes++;
			}
		}
		// initalise the array
		primes = new int[numberOfPrimes];
		
		// reset the ticker
		numberOfPrimes = 0;
		// populate our primes
		for(int i = 0; i < isPrime.length; i++)
		{
			if(isPrime[i])
			{
				primes[numberOfPrimes] = i;
				numberOfPrimes ++;
				largestPrime = i;
			}
		}
		// set it to populated
		populated = true;
		
	}
	
	public static int findNthPrime(int n)
	{
		populate();
		return primes[n-1];
	}
}
