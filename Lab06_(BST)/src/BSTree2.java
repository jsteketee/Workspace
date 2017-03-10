import java.lang.reflect.Array;


public class BSTree2 
{
	
	private int tree[];
	
	public BSTree2() 
	{
		tree = new int [1000];
		for(int i=0;i<tree.length; i++)
			tree[i]=-1;
	}
	public BSTree2(int n)
	{
		tree = new int [1000];
		for(int i=0;i<tree.length; i++)
			tree[i]=-1;
		tree[0]=n;
	}
	
	public int findMax()
	{
		int tempIdx=0;
		boolean stop=false;
		
		if (tree[tempIdx]==-1)
			stop=true;
		while (!stop)
		{
			if (tree[2*tempIdx+2]!=-1)
			{
				tempIdx=2*tempIdx+2;
				//System.out.println("here");
			}
				
			else 
				stop=true;
		}
		return tree[tempIdx];
	}

	public int findMin()
	{
		int tempIdx=0;
		boolean stop=false;
		
		if (tree[tempIdx]==-1)
			stop=true;
		while (!stop)
		{
			if (tree[2*tempIdx+1]!=-1)
				tempIdx=2*tempIdx+1;
			else 
				stop=true;
		}
		return tree[tempIdx];
	}
	
	public void insert(int n) 
	{
		int toAdd=n;
		int tempIdx=0;
		
		boolean stop = false;
		if (tree[tempIdx] == -1)
			tree[tempIdx] = toAdd;
		else {
			while (!stop) {
				if (n < tree[tempIdx]) 
				{
					tempIdx = 2*tempIdx+1;
					if (tree[tempIdx] == -1) 
					{
						tree[tempIdx]=toAdd;
						stop = true;
					}
				}
				else {
					tempIdx = 2*tempIdx+2;
					if (tree[tempIdx] == -1) {
						tree[tempIdx] = toAdd;
						stop = true;
					}
				}
			}
		}
	}
	public void inOrderPrint()
	   {
		inOrderPrint(0);
	   }

	   private void inOrderPrint(int stRootIdx)
	   {
		if (tree[stRootIdx] != -1)
	        {
			inOrderPrint(2*stRootIdx+1);
			System.out.println(tree[stRootIdx]);
			inOrderPrint(stRootIdx*2+2);
	        }
	   }
}
