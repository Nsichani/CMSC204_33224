
public class NoUpperAlphaException extends RunTimeException 
{
	public NoUpperAlphaException()
	{
		super("Error: The password must contain at least one uppercase alphabetic character");
	}
}
