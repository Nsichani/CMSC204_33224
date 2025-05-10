
public class Town implements Comparable<Town>{
	
	private String name;

	// Constructor
	
	public Town(String name)
	{
		this.name = name;
	}
	
	// Copy Constructor 
	
	public Town(Town copyTown)
	{
		this(copyTown.name);
	}
	
	// getName method
	
	public String getName()
	{
		return this.name;
	}
	
	// compareTo method
	
	public int compareTo(Town o)
	{
		return this.name.compareTo(o.name);
	}
	
	// toString method
	
	public String toString()
	{
		return name.toString();
	}
	
	// hashCode method
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	// equals method
	
	public boolean equals(Object o)
	{
		Town comp = (Town) o;
		return this.name.compareTo(comp.name) == 0;
	}
	

}
