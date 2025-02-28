
public class ArraySum 
{
	public int sumOfArray(Integer[] a, int index)
	{
		// Variable to hold the sum of all the values up to the index
		
		int arraySum = 0;
		
		// Going through the array and adding the values to the arraySum variable up to the index provided
		
		for(int i = 0; i < index + 1; i++)
		{
			arraySum += a[i];
		}
		
		// Returning sum of all the values up to the index
		
		return arraySum;
	}
}
