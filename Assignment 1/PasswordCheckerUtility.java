import java.util.ArrayList;

public class PasswordCheckerUtility 
{
	
	
	// comparePasswords class that will check the equality of passwords
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
	
		if(!password.equals(passwordConfirm)) // Checking to see if the passwords are not equal.
		{
			throw new UnmatchedException(); // In the case that passwords are not equal throwing the exception.
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
	
	public static boolean isValidLength(String password) throws LengthException
	{
		if(password.length() >= 6) // Checking to see if the password has at least 6 characters.
		{
			return true; // If so returning true.
		}
		else
		{
			throw new LengthException(); // If not so throwing exception.
		}
	}
	
	// hasUpperAlpha method to make sure the password has at least 1 uppercase letter.
	
	/* I used the following link to understand how to identify if the password has at least 1 uppercase letter or not:
	 * 
	 * https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase
	 * 
	 * */
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
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
			
		throw new NoUpperAlphaException(); // If there is no uppercase character then throwing the appropriate exception.
	}

	// hasLowerAlpha method to make sure the password has at least 1 lowercase letter.
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
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
			
			throw new NoLowerAlphaException(); // If there is no lowercase character then throwing the appropriate exception.
	}

	// hasDigit method to make sure the password has at least 1 digit.
	
	public static boolean hasDigit(String password) throws NoDigitException
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
			
			throw new NoDigitException(); // If there is no digit then throwing the appropriate exception.
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
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
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
			
			throw new NoSpecialCharacterException (); // If there is no special characters then throwing the appropriate exception.
	}
	
	// NoSameCharinSequence method to make sure that there is no more than 2 of the same character in sequence in the password.
	
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
	{
		int counter = 1; // Creating a counter to keep track of how many characters there are in sequence.
		
		for(int i = 1; i < password.length(); i++) // Looping through the characters
		{
			if(password.charAt(i) ==  password.charAt(i-1)) // comparing the current character and one behind it to see if they match.
			{
				counter++; // Incrementing if they match
				
				if(counter > 2) // Checking to see if there are more than 2 of the same character in sequence.
				{
					throw new InvalidSequenceException(); // If so throwing the exception.
				}
			}
			else
			{
				counter = 1; // if characters at current index aren't equal reseting counter and moving onto next pair.
			}
		}
		
		return true; // No more than two of the same character were in sequence.
	}
	
	// isValidPassword method that checks to see if all requirements are met or not and acts accordingly.
	
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		if(!isValidLength(password)) // Checking to see if the password has a valid length.
		{
			throw new LengthException(); // If not throwing the appropriate exception.
		}
		
		if(!hasUpperAlpha(password)) // Checking to see if the password has a uppercase letter.
		{
			throw new NoUpperAlphaException(); // If not throwing the appropriate exception.
		}
		
		if(!hasLowerAlpha(password)) // Checking to see if the password has a lowercase letter. 
		{
			throw new NoLowerAlphaException(); // If not throwing the appropriate exception.
		}
		
		if(!hasDigit(password)) // Checking to see if the password has a digit.
		{
			throw new NoDigitException(); // If not throwing the appropriate exception.
		}
		
		if(!hasSpecialChar(password)) // Checking to see if the password has a special character.
		{
			throw new NoSpecialCharacterException(); // If not throwing the appropriate exception.
		}
		
		if(!NoSameCharInSequence(password)) // Checking to see if the password has no more than two of the same characters in sequence.
		{
			throw new InvalidSequenceException(); // If not throwing the appropriate exception.
		} 
		
		return true; // If all requirements are passed returning true.
	}
	
	// hasBetweenSixAndNineChars method that checks to see if the password has no less than 6 and no more than 9 characters
	
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		if(password.length() >= 6 || password.length() <= 9)
		{
			return true;
		}
		
		return false;
	}
	
	// isWeakPassword method to check to see if the password is weak or not.
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		
		if(isValidPassword(password) == true && hasBetweenSixAndNineChars(password) == true)
		{
			throw new WeakPasswordException();
		}
		else //if(isValidPassword(password) && hasBetweenSixAndNineChars(password) == false)
		{
			return false;
		}
		
		//return true;
//		
		
//		try {
//			if(isValidPassword(password) && hasBetweenSixAndNineChars(password) == false)
//			{
//				return false;
//				
//			}
//		} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
//				| NoSpecialCharacterException | InvalidSequenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		throw new WeakPasswordException();
//		
//		
	}
	
	// getInvalidPasswords method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status of any invalid passwords.
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		// Creating an array list
		
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		// Going through the whole list
		
		for(int i = 0; i < passwords.size(); i++)
		{
			
			String passwordAtIndex = passwords.get(i);
		
			try 
			{
				isValidPassword(passwordAtIndex);
			} 
			catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e)
			{
				// TODO Auto-generated catch block
				//invalidPasswords.add(passwordAtIndex);
				invalidPasswords.add(passwordAtIndex + " " + e.getMessage());
			}
			
		}
		
		// Returning invalid passwords
		
		return invalidPasswords;
	}
}

	




