package Lab1;


public class Card
{
	/**
	 * An array of byte numbers to hold the value of the card number.
	 */
	protected byte[] number;
	/**
	 * The check digit.
	 */
	protected byte checkDigit;
	
	/**
	 * Default constructor
	 * This will throw in a number we know should pass
	 */
	public Card()
	{
		this("4539682995824395");
	}
	
	/**
	 * This is a helper method that assumes that the checkdigit has been provided
	 */
	public Card(String number)
	{
		this(number, true);
	}
	
	/**
	 * @param number		The number of the card to be verified
	 * @param hasCheckDigit	Whether or not the card number has a check digit
	 */
	public Card(String number, boolean hasCheckDigit)
	{
		// build the number array
		this.number = new byte[hasCheckDigit?number.length():number.length() + 1];
		for(int i = 0; i < number.length(); i++)
		{
			this.number[i] = (byte)((number.charAt(i)) - '0');
		}
		
		// set the check digit
		if(hasCheckDigit)
		{
			// it's provided to just store it
			this.checkDigit = (byte)this.number[this.number.length - 1];
		}
		else
		{
			// it's not provided, so calculate it.
			int luhn = this.getLuhnNumber();
			this.checkDigit = (byte)(10 - luhn%10);
			this.number[this.number.length - 1] = checkDigit;
		}
	}
	
	/**
	 * Print the number on the card as a string
	 * @return A concatenated String made of the bytes in the number
	 */
	public String getNumber()
	{
		String out = "";
		for(byte b: this.number)
		{
			out += b;
		}
		return out;
	}
	
	/**
	 * Gets the luhn number of the card
	 * @see https://en.wikipedia.org/wiki/Luhn_algorithm
	 * @return The LuhnNumber of the card
	 */
	private int getLuhnNumber()
	{
		boolean odd = true;
		int checkSum = 0;
		
		for(int i = this.number.length - 1; i >=0; i--)
		{
			if(odd)
			{
				checkSum += this.number[i];
			}
			else
			{
				int sum = this.number[i] * 2;
				checkSum += sum < 10?sum:sum - 9;
			}
			odd = !odd;
		}
		return checkSum;
	}
	
	/**
	 * Validates a card against its luhn number and the provided constraints
	 * @return True if valid, false otherwise
	 */
	public boolean isValid()
	{
		if(this.number.length > 30 || this.number.length < 4)
		{
			return false;
		}
		// this is modified for the full marks.
		return this.getLuhnNumber() % 5 == 0;
	}
}
