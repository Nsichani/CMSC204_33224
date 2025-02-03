
public class NoUpperAlphaException extends Exception 
{
	public NoUpperAlphaException()
	{
		super("Error: The password must contain at least one uppercase alphabetic character!");
	}
}
