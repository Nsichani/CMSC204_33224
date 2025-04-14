
public class TreeNode<T> 
{
	// Class Attributes (used https://www.geeksforgeeks.org/implementing-a-binary-tree-in-java/)
	
	protected T key;
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	
	// Constructors
	
	public TreeNode(T dataNode)
	{
		this.key = dataNode;
		this.left = this.right = null;
	}
	
	public TreeNode(TreeNode<T> node)
	{
		this.key = node.getData();
		this.left = this.right = node;
	}
	
	// getData Method to return the data in the tree
	
	public T getData()
	{
		return this.key;
	}
}
