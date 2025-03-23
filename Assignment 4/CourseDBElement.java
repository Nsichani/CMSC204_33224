
public class CourseDBElement implements Comparable<CourseDBElement> // I asked ChatGPT how to use a CourseDBElement for my compareTo instead of "Object o" and it told me to add "<CourseDBElement>"
{
	// Class Attributes
	
	private String courseID;
	private int CRN;
	private int numberOfCredits;
	private String roomNumber;
	private String instructorName;
	
	// No-arg Constructor
	
	public CourseDBElement()
	{
		this.courseID = null;
		this.CRN = 0;
		this.numberOfCredits = 0;
		this.roomNumber = null;
		this.instructorName = null;
	}
	
	// Constructors
	
	public CourseDBElement(String courseID, int CRN, int numberOfCredits, String roomNumber, String instructorName)
	{
		this.courseID = courseID;
		this.CRN = CRN;
		this.numberOfCredits = numberOfCredits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}
	
	public CourseDBElement(CourseDBElement element)
	{
		
	}
	
	// Getters and Setters for the attributes
	
	public void setID(String courseID)
	{
		this.courseID = courseID;
	}
	
	public String getID()
	{
		return courseID;
	}
	
	public void setCRN(int CRN)
	{
		this.CRN = CRN;
	}
	
	public int getCRN()
	{
		return CRN;
	}
	
	public void setCredits(int numberOfCredits)
	{
		this.numberOfCredits = numberOfCredits;
	}
	
	public int getCredits()
	{
		return numberOfCredits;
	}
	
	public void setRoomNum(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	public String getRoomNum()
	{
		return roomNumber;
	}
	
	public void setInstructor(String instructorName)
	{
		this.instructorName = instructorName;
	}
	
	public String getInstructor()
	{
		return instructorName;
	}
	
	// Turning the CRN into its hash code.
	
	public int hashCode()
	{
		return Integer.toString(CRN).hashCode();
	}
	
	
	// compareTo method to compare two CRN's of the CourseDBElement class
	
	@Override
	public int compareTo(CourseDBElement anotherElement) 
	{
		int newCRN = anotherElement.getCRN();
		
		if(this.CRN == newCRN)
		{
			return 0;
		}
		else if (this.CRN > newCRN)
		{
			return 1;
		}
		else
		{
			return -1;
		}
		
	}
	
	// toString method
	
	public String toString()
	{
		return "Course:" + courseID + " CRN:" + CRN + " Credits:" + numberOfCredits + " Instructor:" + instructorName + " Room:" + roomNumber + "\n";
	}
	
}
