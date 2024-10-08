package Prime;

public class PrimeDriver
{
	public static void main(String[] args)
	{
		Sieve.initialise(1000);
		System.out.println("First "+Sieve.primesInSieve+" primes");
		for(int i = 0; i < Sieve.primesInSieve; i++)
		{
			System.out.println(Sieve.primes[i]);
		}
	}
}
