
public class NoSpecialCharacterException extends Exception {

	public NoSpecialCharacterException()
	{
		super("Error: The password must contain at least one special character!");
	}
}
