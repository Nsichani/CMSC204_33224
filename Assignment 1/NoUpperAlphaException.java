
public class NoUpperAlphaException extends Exception 
{
	public NoUpperAlphaException(String password)
	{
		super(password);
	}
}
