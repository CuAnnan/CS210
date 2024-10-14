package Lab3;

public class PrimeFinder
{
    /**
     * An int array to hold the known primes, starting with 2 and 3
     */
	static int[] knownPrimes = {2, 3} ;
	/**
	 * The number of known primes
	 */
	static int knownPrimesCount = 2;
	
	/**
	 * A method to get the nth prime. This checks the set of known primes first and if not invokes the private method calculateAndFindNthPrime
	 * @see knownPrimes
	 * @see calculateAndFindNthPrime
	 * @param n
	 * @return
	 */
	public static int getNthPrime(int n)
	{
	    // if we already know the nth prime return it
		if(n < knownPrimesCount)
		{
		    return knownPrimes[n - 1];
		}
		// otherwise find it
		return calculateAndFindNthPrime(n);
	}
	
	/**
	 * This method finds the nth known prime by starting with the largest known prime and increasing it by 2 until we get a prime
	 * It does this until the list of known primes is n long
	 * @param n    The index of the prime to find
	 * @return     The nth prime
	 */
	private static int calculateAndFindNthPrime(int n)
	{
		int candidate = knownPrimes[knownPrimesCount - 1];
		// Starting with the last known prime
		do
		{
		    do
		    {
		        // we add two
		        candidate+=2;
		        // and keep doing this until we have a new odd number that has no prime factors
		    }while(hasKnownPrimeFactors(candidate));
		    // add the newly found prime to the set of known primes
		    addKnownPrime(candidate);
		    // we do this until we have n known primes
		}while(knownPrimesCount < n);
		// and return the nth prime
		return candidate;
	}
	
	/**
	 * Check if a number has known prime factors
	 * @param primeCandidate   The number to check for primeness
	 * @return True if has known prime factors, false otherwise
	 */
	private static boolean hasKnownPrimeFactors(int primeCandidate)
	{
		boolean hasKnownPrimeFactors = false;
		int i = 0;
		do
		{
		    hasKnownPrimeFactors = primeCandidate%knownPrimes[i] == 0;
			i++;
		}while(!hasKnownPrimeFactors && i < knownPrimesCount);
		return hasKnownPrimeFactors;
	}
	
	/**
	 * 
	 */
	private static void addKnownPrime(int n)
	{
	    if(knownPrimesCount >= knownPrimes.length)
		{
	        // if the array of known primes is too small
	        // create a new int array of twice its length
	        // copy everything over to the new int array
			int[] newKnownPrimes = new int[knownPrimes.length * 2];
			System.arraycopy(knownPrimes, 0, newKnownPrimes, 0, knownPrimes.length);
			knownPrimes = newKnownPrimes;
		}
	    // and add the new prime to the known prime array
		knownPrimes[knownPrimesCount ] = n;
		knownPrimesCount ++;
		
	}
	
	public static void printKnownPrimes()
	{
	    String out = "";
	    for(int i = 0; i < knownPrimesCount; i++)
	    {
	        out+= knownPrimes[i]+", ";
	    }
	    System.out.println(out);
	}
}
