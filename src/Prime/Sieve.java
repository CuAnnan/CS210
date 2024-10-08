package Prime;

public class Sieve
{
	public static boolean[] isPrime;
	static int[] primes;
	static int primesInSieve;
	
	static void initialise(int upperBound)
	{
		isPrime = new boolean[upperBound];
		for(int i = 2; i < upperBound; i++)
		{
			isPrime[i] = true;
		}
		
		for(int i = 2; i < upperBound; i++)
		{
			for(int j = i*2; j < upperBound; j+= i)
			{
				isPrime[j] = false;
			}
		}
		
		int primeCount = 0;
		for(int i = 0; i < upperBound; i++)
		{
			if(isPrime[i])
			{
				primeCount++;
			}
		}
		primesInSieve = primeCount;
		
		primes = new int[primeCount];
		int currPrime = 0;
		for(int i = 0; i < upperBound; i++)
		{
			if(isPrime[i])
			{
				primes[currPrime++] = i;
			}
		}
	}
	
	
	static boolean isPrime(int n)
	{
		boolean searching = true;
		while(searching)
		{
			
		}
		return searching;
	}
}
