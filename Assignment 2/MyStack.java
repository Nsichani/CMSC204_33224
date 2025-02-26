

import java.util.ArrayList;


public class MyStack<T> implements StackInterface<T> 
{
	private ArrayList<T> stack1;
	private int size = 50;
	
	@Override
	public boolean isEmpty() 
	{
		return stack1.isEmpty(); // using the premade java .isEmpty to see if there is nothing in the stack
	}

	@Override
	public boolean isFull() 
	{	
		return (stack1.size() >= size); // using the premade java .size to see if the stack has surpassed the size 50.
	}

	@Override
	public T pop() throws StackUnderflowException 
	{
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		
		return stack1.remove(stack1.size() -1);
	}

	@Override
	public T top() throws StackUnderflowException 
	{
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		
		return stack1.get(stack1.size() -1);
	}

	@Override
	public int size() 
	{
		return stack1.size(); // using the premade java .size to return the size of the stack
	}

	@Override
	public boolean push(T e) throws StackOverflowException 
	{
		if(isFull())
		{
			throw new StackOverflowException();
		}
		
		return stack1.add(e);
		
	}
	
	public String toString()
	{
		return stack1.toString(); // using the premade java .toString to return the stack as a string
	}

	@Override
	public String toString(String delimiter)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fill(ArrayList<T> list) {
		// TODO Auto-generated method stub
		stack1.addAll(list); // using the premade java .addAll to add the passed list to the stack
		
	}


	}
