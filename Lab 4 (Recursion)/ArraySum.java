
public class ArraySum 
{
	public int sumOfArray(Integer[] a, int index)
	{
		// Variable to hold the sum of all the values up to the index
		
		int arraySum = 0;
		
		// Going through the array and adding the values to the arraySum variable up to the index provided
		
		// Used this to learn how to do it https://www.geeksforgeeks.org/introduction-to-recursion-2/
		
		if(index < 0)
		{
			return 0;
		}
		
		// Returning sum of all the values up to the index
		
		return a[index] + sumOfArray(a, index-1);
		
	}
}
