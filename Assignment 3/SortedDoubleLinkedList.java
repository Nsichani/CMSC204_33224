import java.util.*;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
	// Private variable
	
	private Comparator<T> comparator;
	
	// Constructor for the Class
	
	public SortedDoubleLinkedList(Comparator<T> comparebaleObject)
	{
		this.comparator = comparator;
	}
	
	// add() method that adds the element in the correct position
	
	public void add(T data)
	{
		Node newNode = new Node(data);
		
		

	}
	
	// addToEnd method that is not supported
	
	public void addToEnd(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	// addToFront method that is not supported
	
	public void addToFront(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	// iterator() method that calls the inner iterator class through its super class
	
	public ListIterator<T> iterator()
	{
		return super.iterator();
	}
	
	// remove() method that calls the remove method from its super class
	
	public Node remove(T data, Comparator<T> comparator)
	{
		return super.remove(data, comparator);
	}
	
}