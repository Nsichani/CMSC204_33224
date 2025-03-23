import java.util.*;

public class BasicDoubleLinkedList<T>
{
	// Variables
	
	public Node<T> head;
	protected Node<T> tail;
	public int size;
	
	public BasicDoubleLinkedList() 
	{
		this.head = null;
		this.tail = null;
		int size = 0;
	}
	
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
		return  head.data;
	}
	
	// getLast() method returns the last value in the list
	
	public T getLast()
	{
		return tail.data;
	}
	
	// iterator() method that returns the inner iterator class
	
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
		
	}
	
	// remove() method that removes the first instance of the target data
	

	public Node<T> remove (T targetData, Comparator<T> comparator)
	{
		 Node<T> current = head;
		 
		 for(current = head; current != null; current = current.next) // going through the list
		 {
			 if(comparator.compare(targetData, current.data) == 0) // if the data is found then removing it
			 {
				 if(current == head) // if its the head value
				 {
					 head = head.next; // moving head to the next value aka removing current head pointer
					 head.prev = null;
				 }
			 }
			 else if (current == tail) // if tail value 
			 {
				 tail = tail.prev; // moving tail to previous value and losing pointer to current tail
				 tail.next = null;
			 }
			 else // removing the value from the middle if that is where its located
			 {
				 current.prev.next = current.next;
	             current.next.prev = current.prev;
			 }
			 
			 size--;  // Decrementing size
	         return current;  
		 }
		 
		 return null; // if i can't find anything returning null
	
	}
	
	// retrieveFirstElement() method returns the first value in the list and removes it
	
	public T retrieveFirstElement()
	{
		
		T data = head.data; // assigning the data to the head value
		head = head.next; // moving head to the next node (essentially getting rid of the current head)
		
		size--; // decrement the size
		return data; // returning the old head prior to removal
	}
	
	
	// retrieveLastElement() method returns the last value in the list and removes it
	
	public T retrieveLastElement()
	{
		if(tail != null)
		{
			Node<T> tailData = tail;
			
			if(tail.prev != null)
			{
				tail = tail.prev;
				tail.next = null;
			}
			else
			{
				head = tail = null;
			}
			
			return tailData.data;
		}
		else
		{
			return null;
		}
	}
	
	// toArrayList() method that converts the list to an array list
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> toString = new ArrayList(); // creating a  list to hold all the values
		Node<T> current = head; // starting at the head for the loop
		
		while(current != null)
		{
			toString.add(current.data); // adding the current node to the list
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
            this.next = null;
            this.prev = null;
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
        	if(current != null && current.prev != null)
        	{
        		return false;
        	}
        	else
        	{
        		return true;
        	}
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
                 current =  current.prev;
                 return current.data;
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
