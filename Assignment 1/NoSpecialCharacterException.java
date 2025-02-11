
public class NoSpecialCharacterException extends RunTimeException {

	public NoSpecialCharacterException()
	{
		super("The password must contain at least one special character");
	}
}
