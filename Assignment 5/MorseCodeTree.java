import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    // Class Attributes
    TreeNode<String> root;

    // Constructor
    public MorseCodeTree() {
        buildTree();
    }

    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    @Override
    public void insert(String code, String result){
        addNode(root, code, result);
    }

    @Override
    public void addNode(TreeNode<String> root, String code, String letter) 
    {
    	// I was having some issues with my if-else statements as the test cases kept saying the .left was null therefore I asked it to help me debug
    	// so it changed the condition of the if-statement and told me to add an else that would correctly handle the issue but everything else was left untouched and i wrote the else statements myself.
    	
    	TreeNode obj = root;
    	
    	for(int i =0; i < code.length(); i++)
    	{
    		// creating a variable for the switch
    		
    		char indexCharacter = code.charAt(i);
    		
    		// Using a switch to properly add 
    		
    		switch(indexCharacter)
    		{
    		case '.':
    			
    			if(i == code.length() -1)
    			{
    				obj.left = new TreeNode<String>(letter); 
    			}
    			else
    			{
    				obj = obj.left;
    			}
    			break;
    		
    		case '-':
    			
    			if (i == code.length() -1)
    			{
    				obj.right = new TreeNode<String>(letter);
    			}
    			else
    			{
        			obj = obj.right;
    			}
    			break;
    		}
    	}
    }

    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        TreeNode<String> obj = root;

        for (char n : code.toString().toCharArray()) 
        {
            if (n == '.') 
            {
                obj = obj.left;
            } 
            else if (n == '-') 
            {
                obj = obj.right;
            }
        }

        return obj.getData();
    }

//    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException  {
        throw new UnsupportedOperationException();
    }

//    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void buildTree() {
        root = new TreeNode<>("");

        // Level 1
        insert(".", "e");
        insert("-", "t");

        // Level 2
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");

        // Level 3
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");

        // Level 4
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> toArrayList = new ArrayList<>();
        LNRoutputTraversal(root, toArrayList);
        return toArrayList;
    }

    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root == null) return;

        LNRoutputTraversal(root.left, list);
        list.add(root.getData());
        LNRoutputTraversal(root.right, list);
    }

	

	

	

	
}