
public class Road implements Comparable<Road>{
	
	// Class variables
	
	private Town source;
	private Town destination;
	private int degrees;
	private String name;

	// Constructor
	
	public Road(Town source, Town destination, int degrees, String name)
	{
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;
	}
	
	// Constructor with preset weight
	
	public Road(Town source, Town destination, String name)
	{
		this.source = source;
		this.destination = destination;
		this.degrees = 1;
		this.name = name;
	}
	
	// contains method
	
	public boolean contains(Town town)
	{
		String townName = town.getName();
		return townName.equals(source.getName()) || townName.equals(destination.getName());
	}
	
	// toString method
	
	public String toString()
	{
		return this.name;
	}
	
	// getName method
	
	public String getName()
	{
		return this.name;
	}
	
	// getDesitnation method
	
	public Town getDestination()
	{
		return this.destination;
	}
	
	// getSource method
	
	public Town getSource()
	{
		return this.source;
	}
	
	// compareTo method
	
	public int compareTo(Road o)
	{
		return this.name.compareTo(o.name);
	}
	
	// getWeight method
	
	public int getWeight()
	{
		return this.degrees;
	}
	
	// equals method
	
	public boolean equals(Object o)
	{
		Road road = (Road) o;
		boolean sameD = road.source.equals(this.source) && road.destination.equals(this.destination);
		boolean oppD = road.source.equals(this.destination) && road.destination.equals(this.source);
		return sameD || oppD;
	}
	
}
