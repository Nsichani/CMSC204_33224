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
		int divdedByLoadFactor = (int) (num / 1.5); // Using the load factor to get an estimated/approximate size
		int newNum = get4KPrime(divdedByLoadFactor); // Using the get4kPrime method to get the prime method for the estimated/approximate size to ensure safety
		table = new LinkedList[newNum]; // Making the number found the table size.
	}

	@Override
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		
		int tableSlot = element.hashCode() % table.length; // Getting the hashCode for the element provided
		
		if(table[tableSlot] == null) // If the location doesn't exist... 
		{
			table[tableSlot] = new LinkedList<CourseDBElement>(); // creating a new LinkedList
			table[tableSlot].add(element); // Adding the element into the LinkedList.
			return; // Jumping out of the add method earlier since we already added the element and do not want to overload it.
		}
//		else
//		{
//			 if (table[tableSlot].contains(element))
//			 {
//				 return;
//			 }
//			 else
//			 {
//				 table[tableSlot].add(element);
//			 }
//		}
		
		for(int i = 0; i < table[tableSlot].size(); i++) // If it does exist...
		{
			if(table[tableSlot].get(i).getCRN() == element.getCRN()) // Locating it based on the CRN. If a duplicate is found...
			{
				table[tableSlot].set(i, element); // replacing the existing one with the new one
				return; // jumping out of the add method early since we already added the element and do not want to overload.
			}
		}
		
	//	table[tableSlot].add(element); // Adding the element now the LinkedList if it 
		
	}
	
	@Override
	public ArrayList<String> showAll() 
	{
		// TODO Auto-generated method stub
		
		ArrayList<String> wholeDataBase = new ArrayList<String>(); // Creating an ArrayList
		
		for(int i = 0; i < table.length; i++) // Going through the whole table
		{
			if(table[i] != null) // Making sure there is a value at the current table position
			{
				for(int j = 0; j < table[i].size(); j++) // going through the linked lists of the table
				{
					wholeDataBase.add(table[i].get(j).toString()); // Getting the element with all details (i.e. name, course, crn, etc) and adding the elements to ArrayList
//					CourseDBElement element = table[i].get(j); 
//					wholeDataBase.add(element.toString()); 
				}
			}
		}
		
		return wholeDataBase; // returning the ArrayList
	}

	@Override
	public CourseDBElement get(int crn) throws IOException 
	{	
		// TODO Auto-generated method stub
		
		CourseDBElement finder = new CourseDBElement(); // Creating an object
		finder.setCRN(crn); // setting the object created with the CRN provided by user
		int tableSlot = finder.hashCode() % table.length; // turning it into it's hashCode
		
		// Checking to see if there is anything at the position to avoid null pointer error
		
		if(table[tableSlot] == null) // Catching this issue helps to avoid crashes and helps JUNit tests.
		{
			throw new IOException();
		}
		
		for(int i = 0; i < table[tableSlot].size(); i++) // traversing the linked list to see if the CRN is there
		{
			if(table[tableSlot].get(i).getCRN() == crn) // if the CRN if found and matching to the one provided by user...
			{
				return table[tableSlot].get(i); // returning the index
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
	
	 static boolean isPrime(int num)  // Did using the In-Class Practice
	 {
	        if (num < 2) 
	        {
	        	return false;
	        }
	        	
	        
	        for (int i = 2; i * i <= num; i++)
	        {
	            if (num % i == 0) return false;
	        }
	        
	        return true;
	    }
	
	public static int get4KPrime(int num)
	{
		while(!isPrime(num) || num % 4 != 3) // if the number is not prime and also doesn't meet the 4k+3 requirements...
		{
			num++; // Incrementing the number until it does meet the requirements.
		}
		
		
		return num; // First value found that meets the requirements is returned.
	}
	
	

}
