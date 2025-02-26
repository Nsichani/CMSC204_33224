
public class Notation 
{
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		return 0;
		
	}
	
	public static String convertPostfixToInfix (String postfix) throws InvalidNotationFormatException
	{
		return postfix;
		
	}
	
	public static String converInfixToPostfix(String infix) throws InvalidNotationFormatException
	{
		String postFix;
		MyQueue queue1 = new MyQueue();
		MyStack stack1 = new MyStack();
		
		for(int i = 0; i < infix.length(); i++)
		{
			char currentChar = infix.charAt(i);
			
			if(currentChar == ' ') // if current character is a space ignore it.
			{
				continue;
			}
			
			if(Character.isDigit(currentChar)) // if current character is a digit add it to the queue.
			{
				queue1.enqueue(currentChar);
			}
			
			if(currentChar == '(' ) // if current character is a digit push it into the stack.
			{
				stack1.push(currentChar);
			}
			
			
			
		}
		
		return infix;
		
	}
}
