
public class NoLowerAlphaException extends RunTimeException {

	public NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
}
