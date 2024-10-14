package Lab3;

public class PrimeFinder
{
	static int[] knownPrimes = {2, 3} ;
	static int knownPrimesCount = 2;
	
	
	public static int getNthPrime(int n)
	{
		if(n < knownPrimesCount)
		{
			return knownPrimes[n - 1];
		}
		
		return calculateAndFindNthPrime(n);
	}
	
	public static int calculateAndFindNthPrime(int n)
	{
		int candidate = knownPrimes[knownPrimesCount - 1] + 2;
		do
		{
			candidate+=2;
		}while(hasKnownPrimeFactors(candidate));
		addKnownPrime(candidate);
		return candidate;
	}
	
	public static boolean hasKnownPrimeFactors(int n)
	{
		boolean hasKnownPrimeFactors = false;
		int i = 0;
		do
		{
			hasKnownPrimeFactors = (n%knownPrimes[i]) == 0;
			i++;
		}while(!hasKnownPrimeFactors && i < knownPrimesCount);
		return hasKnownPrimeFactors;
	}
	
	public static void addKnownPrime(int n)
	{
		if(n - 1 > knownPrimes.length)
		{
			// copy everything over to the new int array
			int[] newKnownPrimes = new int[knownPrimes.length * 2];
			System.arraycopy(knownPrimes, 0, newKnownPrimes, 0, knownPrimes.length);
			knownPrimes = newKnownPrimes;
		}
		
		knownPrimes[knownPrimesCount - 1] = n;
		
		knownPrimesCount ++;
		
	}
	
}
