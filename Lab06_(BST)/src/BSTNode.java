
public class BSTNode 
{
	
	public BSTNode parent;
	public int key; 
	public BSTNode left; 
	public BSTNode right; 
	
	public BSTNode (int key)
	{
		this.key = key;
		this.parent=null;
		this.left= null; 
		this.right = null; 
		
	}
}
