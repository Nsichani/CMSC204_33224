import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> 
{
	// I wasn't really sure how to do a stack/queue with an array list cause in class we only did linked list and array but I found this code sinpet from geeksforgeeks and 
	// I found out I can just use a bunch of methods from the collection framework.
	// I pasted the link below but the code has very little to do with this project anyways but i still added it for transparency
	// https://www.geeksforgeeks.org/when-to-use-queue-over-arraylist-in-java/
	
	private ArrayList<T> queue1;
	private int size = 50;
	
	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return queue1.isEmpty(); // using the premade java .isEmpty to see if there is nothing in the queue
	}

	@Override
	public boolean isFull() 
	{
		// TODO Auto-generated method stub
		return (queue1.size() >= size);  // using the premade java .size to see if the queue has surpassed the size 50.
	} 

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		
		T removedItem = queue1.get(0);
		queue1.remove(0);
		return removedItem;
	}

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return queue1.size(); // using the premade java .size to return the size of the queue
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException 
	{
		if(isEmpty())
		{
			throw new QueueOverflowException();
		}
		
		return queue1.add(e);
	}

	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return queue1.toString(); // using the premade java .toString to return the queue as a string
	}
	
	@Override
	public String toString(String delimiter) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fill(ArrayList<T> list) 
	{
		// TODO Auto-generated method stub
		queue1.addAll(list); // using the premade java .addAll to add the passed list to the queue
		
	}

	

	

}
