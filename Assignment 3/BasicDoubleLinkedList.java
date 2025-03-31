
import java.util.*;

public class BasicDoubleLinkedList<T> implements Iterable
{
	// Class Attributes
	
	protected Node<T> head;
	protected Node<T> tail;
	protected int size;
	
	// Constructor 
	
	public BasicDoubleLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void addToEnd(T data)
	{
		
		
		if(tail == null)
		{
			tail = head = new Node(data); 
		}
		else
		{
			Node endOfList = new Node(data);
			tail.next = endOfList;
			endOfList.prev = tail;
			tail = endOfList;
		}
		
		size++;
	}
	
	public void addToFront(T data)
	{
		
		
		if(head == null)
		{
			head = tail = new Node(data);
		}
		else
		{
			Node frontOfList = new Node(data);
			head.prev = frontOfList;
			frontOfList.next = head;
			head = frontOfList;
		}
		
		size++;
	}
	
	public T getFirst()
	{
		return head.data;
	}
	
	public T getLast()
	{
		return tail.data;
	}
	
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator(head);
	}
	
	public Node remove(T targetData, Comparator<T> comparator)
	{
		// Asked chatgpt to explain we the logic of updating the previous and next reference nodes since I was a bit confused on how the javaDoc wanted use to adjust these
		
		Node<T> current = head;
		
		for(current = head; current != null; current = current.next) // looping through the list
		{
			if(comparator.compare(targetData, current.data) == 0) // if the data is found then removing it
			{
				// Updating the targetData nodes previous pointer
				
				if(current.prev != null) 
				{
					current.prev.next = current.next; // if there is a previous node to the one found then making sure that it jumps over the node we want to remove and connects to the "next next" one
				}
				else
				{
					head = current.next; // if its the head value moving head to the next node to lose pointer to head
				}
				
				// Updating the targetData nodes next pointer 
				
				if(current.next != null)
				{
					current.next.prev = current.prev; // if it has a next value making sure to go back to its previous and connect them losing the pointer to current.
				}
				else
				{
					tail  = current.prev; // if its the tail moving the tail to the previous node to lose pointer to current tail
				}
				
				size--;
				return new Node<T> (targetData);
			}
		}
		return null;
	}
	
	public T retrieveFirstElement() 
	{
		if(head != null)
		{
			Node<T> headData = head;
			if(head.next != null)
			{
				head = head.next;
				head.prev = null;
			}
			else
			{
				head = tail = null;
			}
			return headData.data;
		}
		else
		{
			return null;
		}
	}
	
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
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> toString = new ArrayList<>(); // creating a  list to hold all the values
		Node<T> current = head; // starting at the head for the loop
		
		while(current != null)
		{
			toString.add(current.data); // adding the current node to the list
			current = current.next; // moving it to the next node
		}
		
		return toString;
	}
	
	public static class Node<T>
	{
		T data;
		Node prev;
		Node next;
		
		Node(T dataNode)
		{
			this.data = dataNode;
			this.prev = null;
			this.next = null;
		}
	}
	
	public class DoubleLinkedListIterator implements ListIterator<T>
	{
		
		// Class Attributes
        
        Node<T> head;
        Node<T> tail;
        Node<T> current = head;

        // Constructor 
        
        public DoubleLinkedListIterator(Node<T> head)
        {
            this.current = head;
            this.head = head;
        }
        
        
		@Override
		public boolean hasNext()
        {
            return current != null;
        }

		@Override
		public T next() 
		{
		 if(!hasNext())
		 {
			 throw new NoSuchElementException();
	     }
	     else
	     {
	    	 T data =  (T) current.data;
	    	 tail = current;
	    	 current = current.next;
	    	 return data;
	     }
			
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return tail != null;
		}

		@Override
		public T previous() 
		{
			if(!hasPrevious())
			{
				throw new NoSuchElementException();
			}
			else
			{
				T current = tail.data;
				tail = tail.prev;
				return current;
			}
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException
		{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(T e) throws UnsupportedOperationException
		{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException
		{
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}	

}
