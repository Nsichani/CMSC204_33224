import java.util.*;

public class BasicDoubleLinkedList<T>
{
	// Variables
	
	private Node head;
	private Node tail;
	private int size;
	
	// getSize() method to return the size of the list
	
	public int getSize()
	{
		return size;
	}
	
	// addToEnd() method to add a value to the end of the list
	
	public void addToEnd(T data)
	{
		Node newNode = new Node(data);
		
		if(tail == null)
		{
			head = newNode; // assigning the tail to the newNode
			tail = newNode; // assigning the head to one since if there is no tail there is no head.
		}
		else
		{
			tail.next = newNode; // assigning the next tail value to the newNode value
			tail = newNode; // moving the tail to point to the new node.
		}
		size++;
	}
	
	// addToFront() method to add a value to the front of the list
	
	public void addToFront(T data)
	{
		Node newNode = new Node(data);
		
		if(head == null) // if there is no head then...
		{
			head = newNode; // assigning the head to the newNode
			tail = newNode; // assigning the tail to one since if there is no head there is no tail.
		}
		else // if there is a head then...
		{
			newNode.next = head; // assigning the next value of the new node to hold the current value of the head
			head = newNode; // moving the head to point to the new node
		}
		size++;
	}
	
	// getFirst() method returns the first value in the list
	
	public T getFirst()
	{
		return (T) head.data;
	}
	
	// getLast() method returns the last value in the list
	
	public T getLast()
	{
		return (T) tail.data;
	}
	
	// iterator() method that returns the inner iterator class
	
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
		
	}
	
	// remove() method that removes the first instance of the target data
	
	public BasicDoubleLinkedList.Node<T> remove (T targetData, Comparator<T> comparator)
	{
		return null;
		
	}
	
	// retrieveFirstElement() method returns the first value in the list and removes it
	
	public T retrieveFirstElement()
	{
		T data = (T) head.data; // assigning the data to the head value
		head = head.next; // moving head to the next node (essentially getting rid of the current head)
		
		size--; // decrement the size
		return data; // returning the old head prior to removal
	}
	
	
	// retrieveLastElement() method returns the last value in the list and removes it
	
	public T retrieveLastElement()
	{
		T data = (T) tail.data; // assigning the data to the tail value
		tail = tail.prev; // moving tail to the previous node (essentially getting rid of the current tail)
		
		size--; // decrement the size
		return data; // returning the old tail prior to removal
	}
	
	// toArrayList() method that converts the list to an array list
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> toString = new ArrayList(); // creating a  list to hold all the values
		Node current = head; // starting at the head for the loop
		
		while(head.next != null)
		{
			toString.add((T) current.data); // adding the current node to the list
			current = current.next; // moving it to the next node
		}
		
		return toString;
	}
	
	
	// Inner Node Class
	
    public static class Node<T>
    {
        T data; // node to store data
        Node next; // node to store next value
        Node prev; // node to store previous value
        
        // Constructor
        
        public Node(T dataNode)
        {
            this.data = dataNode;
            this.next = next;
            this.prev = prev;
        }
    }
    
    // Inner Iterator Class
    
    public  class DoubleLinkedListIterator  implements ListIterator<T>
    {
        private Node<T> current; // node to store data currently
        
        // Constructor
        
        public DoubleLinkedListIterator()
        {
            this.current = head;
        }
        
        // hasNext() method to check to see if there is a value in the next position.
        
        public boolean hasNext()
        {
            return current != null;
        }
        
        // next() method to move onto the next node/position in the list
        
        public T next() throws NoSuchElementException
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            else
            {
                T data =  current.data;
                current = current.next;
                return data;
            }
        }
        
        // hasPrevious() method to check to see if there is a value in the previous position.
        
        public boolean hasPrevious()
        {
            return current != null && current.prev != null;
        }
        
        // next() method to move onto the previous node/position in the list
        
        public T previous() throws NoSuchElementException
        {
            if(!hasPrevious())
            {
                throw new NoSuchElementException();
            }
            else
            {
            	T data =  current.data;
                current = current.prev;
                return data;
            }
        }
        
        // All methods that come with the ListIterator that do not need to be implemented as per project guidelines/directions. 
        
        public void remove() throws UnsupportedOperationException
        {
            throw new UnsupportedOperationException();
        }
        
        public void add(T addData) throws UnsupportedOperationException
        {
        	throw new UnsupportedOperationException();
        }

		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		
  
        
    }

    
}
