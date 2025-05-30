
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	// Creating objects to use in my Tests
	
	ArrayList<String> testPasswords;
	String stdTestPassword1, stdTestPassword2;

	@Before
	public void setUp() throws Exception {
		
		String[] testPasswordsArray = {"SecurePass123!", "Ab1!", "StrongPass1!", "weakpass1!", "ValidPass1!", "INVALID123!", "Password1!", "NoDigitsHere!", "GoodPass1$", "NoSpecial123", "NoRepetitions1!", "AAAbbb123!", "Str0ngP@ssword", "P@ssw0rd", "Match123!", "Password2!"}; // Passwords to use in tests generated by ChatGPT (https://chatgpt.com/c/67ab9903-f184-8011-915b-cde96a307021).
		testPasswords = new ArrayList<String>(); 
		testPasswords.addAll(Arrays.asList(testPasswordsArray)); // Adding the test passwords into the array.
		
	}

	@After
	public void tearDown() throws Exception 
	{
		testPasswords = null; // Setting the array list to null
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		// Password that does meet requirement and should assertTrue
		
		try
		{
			assertTrue(PasswordCheckerUtility.isValidLength("SecurePass123!"));
			assertTrue("Did not throw lengthException", true);
		}
		catch (LengthException e)
		{
			assertTrue("Exception thrown properly.", true);
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
		
		// Password that does not meet requirement and should assertFalse
		
		try
		{
			assertFalse(PasswordCheckerUtility.isValidLength("Ab1!"));
		}
		catch (LengthException e)
		{
			assertTrue("Exception thrown properly.", true);
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		// Password that does meet requirement and should assertTrue
		
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("StrongPass1!"));
			assertTrue("Did not throw lengthException", true);
		}
		catch (NoUpperAlphaException e)
		{
			assertTrue("Exception thrown properly.", true);
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
					
		// Password that does not meet requirement and should assertFalse
		
		try
		{
			assertFalse(PasswordCheckerUtility.isValidPassword("weakpass1!"));
		}
		catch (NoUpperAlphaException e)
		{
			assertTrue("Exception thrown properly.", true);		
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		// Password that does meet requirement and should assertTrue
		
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("ValidPass1!"));
			assertTrue("Did not throw lengthException", true);
		}
		catch (NoLowerAlphaException e)
		{
			assertTrue("Exception thrown properly.", true);
		}
		catch (Exception e)
		{
		assertTrue("A different exception was thrown", true);
		}
							
		// Password that does not meet requirement and should assertFalse
				
		try
		{
			assertFalse(PasswordCheckerUtility.isValidPassword("INVALID123!"));
		}
		catch (NoLowerAlphaException e)
		{
			assertTrue("Exception thrown properly.", true);		
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		// Password that does meet requirement and should assertTrue
		
		try
		{
			assertTrue(PasswordCheckerUtility.isWeakPassword("Ns123*"));
			assertTrue("Did not throw lengthException", true);
		}
		catch (WeakPasswordException e)
		{
			assertTrue("Exception thrown properly.", true);
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
									
		// Password that does not meet requirement and should assertFalse
						
		try
		{
			assertFalse(PasswordCheckerUtility.isWeakPassword("P@ssw0rdTesting"));
		}
		catch (WeakPasswordException e)
		{
			assertTrue("Exception thrown properly.", true);		
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		// Password that does meet requirement and should assertTrue
		
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("NoRepetitions1!"));
			assertTrue("Did not throw lengthException", true);
		}
		catch (InvalidSequenceException e)
		{
			assertTrue("Exception thrown properly.", true);
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
											
		// Password that does not meet requirement and should assertFalse
								
		try
		{
			assertFalse(PasswordCheckerUtility.isValidPassword("aaabbb123!"));
		}
		catch (InvalidSequenceException e)
		{
			assertTrue("Exception thrown properly.", true);		
		}
			catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		// Password that does meet requirement and should assertTrue
		
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Password1!"));
			assertTrue("Did not throw lengthException", true);
		}
		catch (NoDigitException e)
		{
			assertTrue("Exception thrown properly.", true);
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
													
		// Password that does not meet requirement and should assertFalse
										
		try
		{
			assertFalse(PasswordCheckerUtility.isValidPassword("NoDigitsHere!"));
		}
		catch (NoDigitException e)
		{
			assertTrue("Exception thrown properly.", true);		
		}
		catch (Exception e)
		{
			assertTrue("A different exception was thrown", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		// Password that does meet requirement and should assertTrue
		
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Nimajan*123"));
			assertTrue("Did not throw lengthException", true);
		}
				
		catch (Exception e)
		{
			assertTrue("A exception for the many was thrown", true);
		}
															
		// Password that does not meet requirement and should assertFalse
										
		try
		{
			assertFalse(PasswordCheckerUtility.isValidPassword("Annn1!"));
		}
				
		catch (Exception e)
		{
			assertTrue("A exception for the many was thrown", true);
		}	
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {

		ArrayList<String> invalids;
		invalids = PasswordCheckerUtility.getInvalidPasswords(testPasswords);
		
		  Scanner scan = new Scanner(invalids.get(0));  
	        assertEquals(scan.next(), "Ab1!");  
	        String nextResults = scan.nextLine().toLowerCase(); 
	        assertTrue(nextResults.contains("long"));

	        scan = new Scanner(invalids.get(1));  
	        assertEquals(scan.next(), "weakpass1!");  
	        nextResults = scan.nextLine().toLowerCase(); 
	        assertTrue(nextResults.contains("uppercase"));

	        scan = new Scanner(invalids.get(2));  
	        assertEquals(scan.next(), "INVALID123!");  
	        nextResults = scan.nextLine().toLowerCase(); 
	        assertTrue(nextResults.contains("lower"));

	        scan = new Scanner(invalids.get(3));  
	        assertEquals(scan.next(), "NoDigitsHere!");  
	        nextResults = scan.nextLine().toLowerCase(); 
	        assertTrue(nextResults.contains("digit"));

	        scan = new Scanner(invalids.get(4));  
	        assertEquals(scan.next(), "NoSpecial123");  
	        nextResults = scan.nextLine().toLowerCase(); 
	        assertTrue(nextResults.contains("special"));

	        scan = new Scanner(invalids.get(5));  
	        assertEquals(scan.next(), "AAAbbb123!");  
	        nextResults = scan.nextLine().toLowerCase(); 
	        assertTrue(nextResults.contains("sequence"));
	    
	}
	
}
