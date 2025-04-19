 
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTestStudent {
	
	@Test
	public void testConvertToEnglishString() {	
		String cnvrt = MorseCodeConverter.convertToEnglish("-. .. -- .- / ... .. -.-. .... .- -. ..");
		assertEquals("nima sichani", cnvrt);
	}
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */
	
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String cnvrt2 = MorseCodeConverter.convertToEnglish("- .... . / ... . -.-. --- -. -.. / - --- / .-.. .- ... - / .--. .-. --- .--- . -.-. -");
		assertEquals("the second to last project", cnvrt2);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*Make sure howDoILoveThee.txt is in the src directory for this 
		  test to pass
		*/
		File file = new File("src/StudentFile.txt"); 
		try {
			assertEquals("this is the student txt file", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	

}
