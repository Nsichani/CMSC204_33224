
public class Notation 
{
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		// Stack and Queue objects
		
		MyQueue queue1 = new MyQueue(1000);
		MyStack stack1 = new MyStack(1000);
		
		// Variable used in method
		
		double finalCalc = 0.0;
		
		for(int i =0; i < postfixExpr.length(); i++) // reading the postfix from left to right
		{
			char currentChar = postfixExpr.charAt(i); // creating a variable for the current character we are at
			
			if(currentChar == ' ')
			{
				continue;
			}
			
			if(currentChar == '(' || Character.isDigit(currentChar)) // if the character is a left parenthesis or a digit pushing it into the stack.
			{
				stack1.push(Double.parseDouble((Character.toString(currentChar)))); // Asked chat gpt how to convert from a char to a string and then to a double. prompt and answer provided below and link.
			}
			
			/*
			 * Prompt:  how to parse a character to a string and then to a double
			 * 
			 * Answer: To parse a character to a string and then to a double, you can follow these steps:

Convert the character to a string: You can use Character.toString(char) to convert the character into a string.
Convert the string to a double: Use Double.parseDouble(string) to parse the string into a double.
Here’s an example in Java:

java
Copy
Edit
public class ParseExample {
    public static void main(String[] args) {
        char character = '5';  // Example character
        String string = Character.toString(character);  // Convert character to string
        double value = Double.parseDouble(string);  // Convert string to double

        System.out.println("The double value is: " + value);  // Output the result
    }
}
Steps in the example:
The character '5' is first converted to the string "5".
The string "5" is then parsed into the double 5.0.
Let me know if you need further clarification or adjustments!
			 * 
			 * Link: https://chatgpt.com/share/67bfa728-2ef4-8011-ae1e-df7135393b14
			 */
			
			if(currentChar == '+' || currentChar == '-'  || currentChar == '/' || currentChar == '*') // if the character is a operator...
			{
				if(stack1.size() < 2) // if the stack is less than size 2 throwing an exception
				{
					throw new InvalidNotationFormatException();
				}
				
				Double secondValue = (double) stack1.pop(); // Popping two values into the stack. Making sure they are doubles so we return correct values
				Double firstValue = (double) stack1.pop();
				
				switch(currentChar)
				{
				case '+':
					finalCalc = firstValue + secondValue; // adding the two values
					break;
				case '-':
					finalCalc = (firstValue) - (secondValue); // subtracting the two values
					break;
				case '*':
					finalCalc = (firstValue) * (secondValue); // multiplying the two values
					break;
				case '/':
					finalCalc = (firstValue) / (secondValue); // dividing the two values
					break;
				}
				
				stack1.push(finalCalc);
			}
			
		}
		

		if (stack1.size() != 1) // making sure the size of the stack is not larger than 1 and if it is throwing an exception
		{
			throw new InvalidNotationFormatException();
		}
		
	
		return (double) stack1.pop(); // returning the popped stack as a double.
		
		
	}
	
	public static String convertPostfixToInfix (String postfix) throws InvalidNotationFormatException
	{
		// Stack and Queue objects
		
		MyQueue queue1 = new MyQueue<>(1000);
		MyStack stack1 = new MyStack(1000);
		
		for(int i =0; i < postfix.length(); i++) // reading the postfix from left to right
		{
			char currentChar = postfix.charAt(i); // creating a variable for the current character we are at
			
			if(currentChar == ' ') // if the character is a space ignoring it
			{
				continue;
			}
			
			if(Character.isDigit(currentChar)) // if the character is a operand pushing it into the stack
			{
				stack1.push(currentChar);
			}
			
			if(currentChar == '+' || currentChar == '-'  || currentChar == '/' || currentChar == '*') // if the character is a operator...
			{
				if(stack1.size() < 2) // if the stack is less than size 2 throwing an exception
				{
					throw new InvalidNotationFormatException();
				}
				
				String secondValue = stack1.pop().toString(); // Popping two values into the stack
				String firstValue = stack1.pop().toString();
				
				stack1.push("(" + firstValue +  currentChar + secondValue + ")"); // pushing the operand + operator + operand format into the stack
			
			}	
			
		}
		
		if (stack1.size() != 1) // making sure the size of the stack is not larger than 1 and if it is throwing an exception
		{
			throw new InvalidNotationFormatException();
		}
		
		return stack1.pop().toString(); // returning the popped stack in the toString format.
		
	}
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
	{
		
	
		MyQueue<Character> queue1 = new MyQueue<>(1000);
		MyStack<Character> stack1 = new MyStack<>(1000);
		
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
			
			if(currentChar == '(') // if current character is a digit push it into the stack.
			{
				stack1.push(currentChar);
			}
			
			if(currentChar == '+' || currentChar == '-'  || currentChar == '/' || currentChar == '*')
			{
				while(!stack1.isEmpty() && precedence(currentChar) > precedence((char)stack1.top()))
				{
					queue1.enqueue(stack1.pop());
				}
				
				stack1.push(currentChar);
			}
			
			if(currentChar == ')') // if the character is a right parenthesis...
			{
				if(stack1.isEmpty())
				{
					throw new InvalidNotationFormatException();
				}
				
				
				while(!stack1.isEmpty() && stack1.top() != '(')  // Popping operators from the top of the stack until a left parenthesis is left at the top.
				{
					queue1.enqueue(stack1.pop());
				}
				
				if(stack1.isEmpty())
				{
					throw new InvalidNotationFormatException();
				}
				
				stack1.pop(); // Popping the left parenthesis from the stack.
					
			}
				
		}
		
		while(!stack1.isEmpty()) // While the infix has been read and not empty popping operators and inserting them into the queue
		{
			if(stack1.top() == '(')
			{
				throw new InvalidNotationFormatException();
			}
			
			queue1.enqueue(stack1.pop());
		}
		
		return queue1.toString();
		
	/*		
		// Stack and Queue objects
		
		MyQueue queue1 = new MyQueue<>(1000);
		MyStack stack1 = new MyStack(1000);
		
	
		// Reading the infix from left to right
		
		for(int i = 0; i < infix.length(); i++)
		{
			char currentChar = infix.charAt(i);
			
			
			if(currentChar == ' ')
			{
				continue;
			}
			
			if(Character.isDigit(currentChar))
			{
				queue1.enqueue(currentChar);
			}
			
			if(currentChar == '(')
			{
				stack1.push(currentChar);
			}
			
			if(currentChar == '+' || currentChar == '-'  || currentChar == '/' || currentChar == '*')
			{
				while(!stack1.isEmpty() && precedence(currentChar) >= precedence((char)stack1.top()))
				{
					queue1.enqueue(stack1.pop());
				}
				
				stack1.push(currentChar);
			}
			
			if(currentChar == ')')
			{
				
				while(stack1.top() != "(")
				{
					queue1.enqueue(stack1.pop());
				}
				
				if(stack1.isEmpty() || stack1.top() != "(")
				{
					throw new InvalidNotationFormatException();
				}
				
				stack1.pop();
			}
			
		}
		
		while(!stack1.isEmpty())
		{
			queue1.enqueue(stack1.pop());
		}
		
		return queue1.toString();
		
		*/
			
	}
	
	
	/* Found out that you can handle precedence by making a separate method through google. Link to the website is pasted below
	 * 
	 * Link: https://embeddedtechhub.com/c-program-to-convert-infix-to-postfix/
	 * */
	
	// Precedence calculator method
	
	public static int precedence(char currentChar)
	{
		if(currentChar == '+' || currentChar == '-')
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
			
	
	
	
}



