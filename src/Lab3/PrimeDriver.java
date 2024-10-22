package Lab3;
import java.util.Scanner;

public class PrimeDriver
{
	public static void main(String args[])
	{
	    long start = System.currentTimeMillis();
	    
	    System.out.println("Populating Erathosthenes' Sieve.");
	    EratosthanesSieve.populate();
	    long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println(
			"Took "+duration+" milliseconds to find the first "+EratosthanesSieve.numberOfPrimes+" primes up to "+EratosthanesSieve.largestPrime
		);
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Get Nth and 2Nth primes for N:");
	    int n = sc.nextInt();
	    int n2 = n * 2;
	    
	    System.out.println(EratosthanesSieve.findNthPrime(n)+" is the "+n+"th prime");
	    System.out.println(EratosthanesSieve.findNthPrime(n2)+" is the "+(n*2)+"th prime");

		
		
		
		sc.close();
		
	}
}
