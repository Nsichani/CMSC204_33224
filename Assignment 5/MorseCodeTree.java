import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface
{
	// Class Attributes
	
	TreeNode<String> root;
	
	// Constructor
	
	public MorseCodeTree()
	{
		buildTree();
	}

	@Override
	public TreeNode getRoot() 
	{
		// TODO Auto-generated method stub
		return root; // returning the root.
	}

	@Override
	public void setRoot(TreeNode newNode) 
	{
		// TODO Auto-generated method stub
		root = newNode; // setting the first node to the root.
	}

	@Override
	public void insert(Object code, Object result) {
		// TODO Auto-generated method stub
		addNode(root, code, result); // using a java method to insert a node.
	}

	@Override
	public void addNode(TreeNode root, Object code, Object letter) 
	{
		// TODO Auto-generated method stub
		
		// Creating a Tree Node object for the root
		
		// Creating a Tree Node object for the root
		
		TreeNode<String> obj = root;
		String route = (String) code;
						
		// Going through the code and deciding if i go left for right
						
		for (int i = 0; i < route.length(); i++)
		{
			char c = route.charAt(i);
			if(c == '.')
			{
				if (obj.left == null)
				{
					obj.left = new TreeNode<>("");
				}	
				
				obj = obj.left;
				
			}
			
			else if(c == '-')
			{
				if (obj.right == null)
				{
					obj.right = new TreeNode<>("");
				}	
				
				obj = obj.right;
				
			}
		}
				
		
		
//		TreeNode<String> obj = root;
//		
//		// Going through the code and deciding if i go left for right
//		
//		for(char n : ((String) code).toCharArray()) // Converting the code to a array of characters and going through.
//		{
//			if(n == '.') // if a period is first then get the left child of that root.
//			{
//				obj = obj.left;
//			}
//			else if (n == '-') // if its a underscore then get the right child of that root.
//			{
//				obj = obj.right;
//			}
//		}
//		
//		obj = new TreeNode<String>((String) letter);
		
		
	}

	@Override
	public Object fetch(String code)
	{
		// TODO Auto-generated method stub
		return fetchNode(root, code);
	}

	@Override
	public Object fetchNode(TreeNode root, Object code) 
	{
		// TODO Auto-generated method stub
		 // ** Copied from my addNode **
		
		// Creating a Tree Node object for the root
		
		TreeNode<String> obj = root;
				
		// Going through the code and deciding if i go left for right
				
		for(char n : ((String) code).toCharArray()) // Converting the code to a array of characters and going through.
		{
			if(n == '.') // if a period is first then get the left child of that root.
			{
				obj = obj.left;
			}
			else if (n == '-') // if its a underscore then get the right child of that root.
			{
				obj = obj.right;
			}
		}
		
		return obj.getData(); // returning the data in the TreeNode obj created.
	}

	@Override
	public LinkedConverterTreeInterface delete(Object data) throws UnsupportedOperationException 
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		root = new TreeNode<String>(""); // assigning root the empty string value
		
		// Adding the letters into the tree using the diagram on the word doc for accuracy
		
		// Level 1
		
		insert(".", "e");
		insert("-","t");
		
		// Level 2
		
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("..","m");
		
		// Level 3
		
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		
		// Level 4 
		
		insert("....","h");
		insert("...-","V");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
		
	}

	@Override
	public ArrayList toArrayList() {
		// TODO Auto-generated method stub
		
		// Creating an Array List
		
		ArrayList<String> toArrayList = new ArrayList<String>();
		
		// Using the LNR method to fill the Array List
		
		LNRoutputTraversal(root, toArrayList);
		
		// Returning the Array List
		
		return toArrayList;
	}

	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		// TODO Auto-generated method stub
		
		// Checking to see if the root is null
		
		if(root == null)
		{
			return; // if so jumping out of the method
		}
		else if(root != null) // if not the case
		{
			LNRoutputTraversal(root.left, list); // Running the traversal for the left child
			list.add(root.getData()); // Adding the data into the list
			LNRoutputTraversal(root.right, list); // Then running the traversal for the right child
		}
			
		
	}
	
}
