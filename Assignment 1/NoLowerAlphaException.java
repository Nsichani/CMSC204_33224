
public class NoLowerAlphaException extends Exception {

	public NoLowerAlphaException()
	{
		super("Error: The password must contain at least one lowercase alphabetic character!");
	}
}
