
public class PasswordCheckerUtility 
{
	
	
	// comparePasswords class that will check the equality of passwords
	
	public static void comparePasswords(String password, String passwordConfirm)
	{
		try // try and catch block to avoid crashing.
		{
			if(!password.equals(passwordConfirm)) // Checking to see if the passwords are not equal.
			{
				throw new UnmatchedException("The passwords do not match!"); // In the case that passwords are not equal throwing the exception.
			}
		}
		catch (UnmatchedException e) // catching the exception for debugging purposes.
		{
			System.out.println("Error: " + e); // Displaying error to understand what when wrong.
		}
	}
	
	// comparePasswordsWithReturn method that will return a boolean after comparing equality.
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		if(password.equals(passwordConfirm)) // Checking to see if the passwords are equal.
		{
			return true; // If so returning true.
		}
		else
		{
			return false; // If not so returning false;
		}
	}
	
	// isValidLength method that makes sure the password is at least 6 characters. 
	
	public static boolean isValidLength(String password)
	{
		try // try and catch block to avoid crashing.
		{
			if(password.length() >= 6) // Checking to see if the password has at least 6 characters.
			{
				return true; // If so returning true.
			}
			else
			{
				throw new LengthException("The password must be at least 6 characters long!"); // If not so throwing exception.
			}
		}
		catch (LengthException e) // catching the exception for debugging purposes.
		{
			System.out.println("Error: " + e); // Displaying error to understand what when wrong.
		}
		
		return false; // Returning false when initial "if-statement" is not true.		
	}
	
	// hasUpperAlpha method to make sure the password has at least 1 uppercase letter.
	
	/* I used the following link to understand how to identify if the password has at least 1 uppercase letter or not:
	 * 
	 * https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase
	 * 
	 * */
	
	public static boolean hasUpperAlpha(String password)
	{
		try
		{
			// Creating a variable to hold the character at the current index.
			
			char charAtIndex;
			
			// Creating a loop to go through every character.
			
			for(int i = 0; i < password.length(); i++)
			{
				// Setting the character variable to be equal to the character at the current index.
				
				charAtIndex = password.charAt(i);
				
				// If the current character is uppercase then the method will return true.
				
				if(Character.isUpperCase(charAtIndex))
				{
					return true;
				} 
			}
			
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character!"); // If there is no uppercase character then throwing the appropriate exception.
		}
		catch (NoUpperAlphaException e)
		{
			System.out.println("Error: " + e);
		}
		
		return false; // No uppercase characters found and therefore returning false. 
	}

	// hasLowerAlpha method to make sure the password has at least 1 lowercase letter.
	
	public static boolean hasLowerAlpha(String password)
	{
		try
		{
			// Creating a variable to hold the character at the current index.
			
			char charAtIndex;
			
			// Creating a loop to go through every character.
			
			for(int i = 0; i < password.length(); i++)
			{
				// Setting the character variable to be equal to the character at the current index.
				
				charAtIndex = password.charAt(i);
				
				// If the current character is lowercase then the method will return true.
				
				if(Character.isLowerCase(charAtIndex))
				{
					return true;
				} 
			}
			
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character!"); // If there is no lowercase character then throwing the appropriate exception.
		}
		catch (NoLowerAlphaException e)
		{
			System.out.println("Error: " + e);
		}
		
		return false; // No lowercase characters found and therefore returning false. 
	}

	// hasDigit method to make sure the password has at least 1 digit.
	
	public static boolean hasDigit(String password)
	{
		try
		{
			// Creating a variable to hold the character at the current index.
			
			char charAtIndex;
			
			// Creating a loop to go through every character.
			
			for(int i = 0; i < password.length(); i++)
			{
				// Setting the character variable to be equal to the character at the current index.
				
				charAtIndex = password.charAt(i);
				
				// If the current character is a digit then the method will return true.
				
				if(Character.isDigit(charAtIndex))
				{
					return true;
				} 
			}
			
			throw new NoDigitException("The password must contain at least one digit!"); // If there is no digit then throwing the appropriate exception.
		}
		catch (NoDigitException e)
		{
			System.out.println("Error: " + e);
		}
		
		return false; // No lowercase characters found and therefore returning false. 
	}
	
	// hasSpecialChar method to make sure the password has at least 1 special character.
	
	/*
	 * Used ChatGPT to see how i can identify if there is a special character included.
	 * 
	 * Link: https://chatgpt.com/share/679a1480-676c-8011-9cde-0b058fa72b93
	 * Prompt/Question: is there a Character.isSpecialCahracter in java
	 * Summarized Answer: No, but you can use the !Character.isLetterOrDigit(ch) to find everything that isn't a letter a digit which are considered special characters
	 * 
	 * */
	
	public static boolean hasSpecialChar(String password)
	{
		try
		{
			// Creating a variable to hold the character at the current index.
			
			char charAtIndex;
			
			// Creating a loop to go through every character.
			
			for(int i = 0; i < password.length(); i++)
			{
				// Setting the character variable to be equal to the character at the current index.
				
				charAtIndex = password.charAt(i);
				
				// If the current character is a special character then the method will return true.
				
				if(!Character.isLetterOrDigit(charAtIndex))
				{
					return true;
				} 
			}
			
			throw new NoSpecialCharacterException ("The password must contain at least one special character!"); // If there is no special characters then throwing the appropriate exception.
		}
		catch (NoSpecialCharacterException  e)
		{
			System.out.println("Error: " + e);
		}
		
		return false; // No special characters found and therefore returning false. 
	}
	
	// NoSameCharinSequence method to make sure that there is no more than 2 of the same character in sequence in the password.
	
	public static boolean NoSameCharInSequence(String password)
	{
		try
		{
			
			throw new InvalidSequenceException ("The password cannot contain more than two of the same character in sequence.");
		}
		catch(InvalidSequenceException e)
		{
			System.out.println("Error " + e);
		}
		
		return false; // More than two of the same character were in sequence.
	}
	
	
}


