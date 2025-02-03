
/*
 * I used the following Youtube video to learn how to create my own exception class:
 * 
 * https://www.youtube.com/watch?v=V_jVp6WdW0Y
 * 
 * */

public class UnmatchedException extends RuntimeException
{
	public UnmatchedException()
	{
		super("Error: The passwords do not match!");
	}

	
}
