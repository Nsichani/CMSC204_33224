import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class CourseDBStructure extends Object implements CourseDBStructureInterface 
{
	// Class attributes
	
	protected LinkedList<CourseDBElement>[] table;
	
	// Constructors
	
	public CourseDBStructure(String numElements, int size)
	{
		table = new LinkedList[size];
	}
	
	public CourseDBStructure(int num)
	{
		int loadFactoredNum = num / 1.5;
		int tableSize = get4kPrime(loadFactoredNum);
		table = new LinkedList[tableSize];
	}

	@Override
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		
		int tableSlot = element.hashCode(); // Getting the hashCode for the element provided
		
		if(table[tableSlot] == null) // If the location doesn't exist creating a LinkedList and adding the hashCode
		{
			table[tableSlot] = new LinkedList<CourseDBElement>();
			table[tableSlot].add(element);
		}
		else
		{
			table[tableSlot].add(element); // If it already exists adding it automatically.
		}
		
	}
	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	
	@Override
	public ArrayList<String> showAll() 
	{
		// TODO Auto-generated method stub
		
		ArrayList<String> wholeDataBase = new ArrayList<String>();
		
		for(int i = 0; i < table.length; i++)
		{
			if(table[i] != null)
			{
				for(int j = 0; j < table[i].size(); j++)
				{
					CourseDBElement element = table[i].get(j);
					wholeDataBase.add(element.toString());
				}
			}
		}
		
		return wholeDataBase;
	}

	@Override
	public CourseDBElement get(int crn) throws IOException 
	{	
		// TODO Auto-generated method stub
		
		CourseDBElement finder = new CourseDBElement(); // Creating an object
		finder.setCRN(crn); // setting the object created with the CRN provided by user
		int tableSlot = finder.hashCode(); // turning it into it's hashCode
		
		for(int i = 0; i < table.length; i++) // traversing the linked list to see if the CRN is there
		{
			if(finder.getCRN() == table[tableSlot].get(i).getCRN())
			{
				return table[tableSlot].get(i); // If it is returning the index
			}
		}
		
		throw new IOException(); // If not throwing an exception.
	}

	@Override
	public int getTableSize() 
	{
		// TODO Auto-generated method stub
		return table.length;
	}
	
	public static int get4KPrime(int num)
	{
		return 0;
	}

}
