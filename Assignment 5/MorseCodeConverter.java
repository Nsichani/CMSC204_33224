import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter 
{
	// Class Attributes
	
	private static MorseCodeTree morseCodeTree = new MorseCodeTree();
	
	// printTree method that prints the tree created to make sure it has been done correctly
	
	public static String printTree()
	{
		
		StringBuilder data = new StringBuilder(); // Creating a string builder to hold all the letters
		int counter = 0; // creating a counter to go through the list
		
		while(counter < morseCodeTree.toArrayList().size()) // as long as the size is greater than the counter
		{
			data.append(morseCodeTree.toArrayList().get(counter) + " "); // adding the data into my string builder
			counter++; // incrementing the counter
		}
		
		return data.toString(); // returning the completed string builder by using toString.
	}
	
	// convertToEnglish method that turns morse code to English text
	
	public static String convertToEnglish(String code)
	{		
		StringBuilder translated = new StringBuilder(); // Creating a string builder to hold my translation
		
		String[] brokenCode = code.trim().split(" / "); // Breaking the code down
		
		for(String broken : brokenCode)
		{
			String[] signs = broken.trim().split(" ");
			
			for(String codeSign : signs)
			{
				String individualLetter = (String) morseCodeTree.fetch(codeSign);
				translated.append(individualLetter);
			}
			
			translated.append(" ");
		}
		
		return translated.toString().trim();
	}

	public static String convertToEnglish(File codeFile) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		
		StringBuilder data = new StringBuilder(); // Creating a string builder to hold all the letters
		
		try
		{
			Scanner inputFile = new Scanner(codeFile);
			
			while(inputFile.hasNextLine())
			{
				data.append(inputFile.nextLine());
			}
			
			return data.toString();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return data.toString();
	}
}
