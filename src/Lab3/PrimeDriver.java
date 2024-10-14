package Lab3;

public class PrimeDriver
{
	public static void main(String args[])
	{
	    long start = System.currentTimeMillis();
	    
	    int n = 50000;
	    
	    System.out.println("The "+n+"th prime is "+PrimeFinder.getNthPrime(50000));
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println("Took "+duration+" milliseconds to find");
	}
}
