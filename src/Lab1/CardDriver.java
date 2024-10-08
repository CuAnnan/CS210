package Lab1;
//import java.util.Scanner;

public class CardDriver
{
	public static void main(String[] args)
	{
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("Enter card number: ");
//		String cardNumberIn = sc.nextLine();
//		Card c = new Card(cardNumberIn);
//		System.out.println(c.isValid()?"VALID":"INVALID");
//		sc.close();
		String[] cardNumbers = {"0000", "4539682995824395", "20853871", "1234"};
		for(String cardNumber: cardNumbers)
		{
			Card c=  new Card(cardNumber);
			System.out.print(cardNumber+": ");
			System.out.println(c.isValid()?"VALID":"INVALID");
		}
	
	}
}
