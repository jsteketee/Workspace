public class BSTree {

	private BSTNode root;

	public BSTree() 
	{
		BSTNode root = null;
	}

	public BSTree(int key) {
		root = new BSTNode(key);
	}
	
	public int findMax()
	{
		BSTNode temp=root;
		boolean stop=false;
		if (temp==null)
			return 999;
		else
		{
			while (!stop)
			{
				if (temp.right!=null)
					temp=temp.right;
				else 
					stop=true;
			}
		return temp.key;
		}
	}
	
	public int findMin()
	{
		BSTNode temp=root;
		boolean stop=false;
		if (temp==null)
			return 999;
		else
		{
			while (!stop)
			{
				if (temp.left!=null)
					temp=temp.left;
				else 
					stop=true;
			}
		return temp.key;
		}
	}
	
	public void insert(int key) 
	{
		BSTNode toAdd = new BSTNode(key);
		BSTNode temp = root;
		BSTNode prev = root;
		boolean stop = false;
		if (temp == null)
			root = toAdd;
		else {
			while (!stop) {
				prev = temp;
				if (key < temp.key) {
					temp = temp.left;

					if (temp == null) {
						toAdd.parent = prev;
						prev.left = toAdd;
						stop = true;
					}
				} else {
					temp = temp.right;
					if (temp == null) {
						toAdd.parent = prev;
						prev.right = toAdd;
						stop = true;
					}
				}
			}
		}
	}
	public void inOrderPrint()
	   {
		inOrderPrint(root);
	   }

	   private void inOrderPrint(BSTNode stRoot)
	   {
		if (stRoot != null)
	        {
			inOrderPrint(stRoot.left);
			System.out.println(stRoot.key);
			inOrderPrint(stRoot.right);
	        }
	   }
}
