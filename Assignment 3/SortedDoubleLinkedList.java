import java.util.*;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
	// Private variable
	
	private Comparator<T> comparator;
	
	// Constructor for the Class
	
	public SortedDoubleLinkedList(Comparator<T> comparebaleObject)
	{
		this.comparator = comparebaleObject;
	}
	
	// add() method that adds the element in the correct position
	
	/* public void add(T data) {
	        Node newNode = new Node(data);

	        if (head == null) { // Case: List is empty
	            head = tail = newNode;
	        } else if (comparator.compare(data, head.data) <= 0) { // Case: Insert at the beginning
	            newNode.next = head;
	            head.prev = newNode;
	            head = newNode;
	        } else { // Case: Insert in the middle or end
	            Node<T> current = head;

	            while (current.next != null && comparator.compare(data, current.next.data) > 0) {
	                current = current.next;
	            }

	            newNode.next = current.next;
	            newNode.prev = current;

	            if (current.next != null) { // If inserting before a middle element
	                current.next.prev = newNode;
	            } else { // If inserting at the end
	                tail = newNode;
	            }

	            current.next = newNode;
	        }
	        size++;
	    }
	*/
	public void add(T data)
	{
		Node newNode = new Node(data);
		
		// if the head is empty
		if(head == null)
		{
			head = tail = newNode; // assign the tail and head to the newNode
		}
		else if (comparator.compare(data, head.data) <= 0) // if the value is less than the head
		{
			newNode.next = head; // the next value after newNode is the head value
			head.prev = newNode; // moving head back one
			head = newNode; // assigning it the newNode value
		}
		else
		{
			Node<T> current = head;
			
			while(current.next != null && comparator.compare(data, (T) current.next.data) > 0) // while it is greater than the current position moving onto the next
			{
				current = current.next;
			}
			
			newNode.next = current.next; // the next newNode is the next current value
			newNode.prev = current; // moving newNode to the current value
			
			if(current.next != null)
			{
				current.next.prev = newNode;
			}
			else
			{
				tail = newNode;
			}
			
			current.next = newNode;
		}
		size++; // incrementing size of list
		
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