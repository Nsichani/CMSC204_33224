import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class CourseDBManager extends Object implements CourseDBManagerInterface 
{
	// Class Attributes
	
	private CourseDBStructure CDBS;

	// Constructor
	
	public CourseDBManager()
	{
		CDBS = new CourseDBStructure(99);
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor); // creating an element using the data provided
		CDBS.add(element); // adding the element created to the structure
	}

	@Override
	public CourseDBElement get(int crn) {
		// TODO Auto-generated method stub
		
		try 
		{
			return CDBS.get(crn); // returning the CRN using the get Method created in Structure Class.
		} 
		catch (IOException e) // Throwing an exception if the CRN is not in the structure.
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		try
		{
			Scanner inputFile = new Scanner(input); // Creating a scanner to read the file
			
			while(inputFile.hasNextLine()) // Going thought the entire file
			{
				String data = inputFile.nextLine(); // Reading the next piece of data
				String[] dataArray = data.split(" "); // Learned to make an array using the split from https://stackoverflow.com/questions/15903170/read-and-split-a-text-file-java
				
				// Adding the information to their corresponding variables.
				
				String courseID = dataArray[0];
				int CRN = Integer.parseInt(dataArray[1]);
				int numberOfCredits = Integer.parseInt(dataArray[2]);
				String instructorName = dataArray[3];
				String roomNumber = dataArray[4];
				
				// Adding the variables to an element and adding the element to the structure
				
				CourseDBElement element = new CourseDBElement(courseID, CRN, numberOfCredits, instructorName, roomNumber);
				CDBS.add(element);
			}	
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}	
	}

	@Override
	public ArrayList<String> showAll() 
	{
		
		return CDBS.showAll(); // Calling the showAll function from the structure class
		
//		// TODO Auto-generated method stub
//		ArrayList<String> dataList = new ArrayList<>();
//		
//		for(int i = 0; i < CDBS.getTableSize(); i++)
//		{
//			if(CDBS.table[i] != null)
//			{
//				for(int j = 0; j < CDBS.table[i].size(); j++)
//				{
//					dataList.add(CDBS.table[i].get(j).toString());
//				}
//			}
//		}
//		
//		return dataList;
//		
	}

}
