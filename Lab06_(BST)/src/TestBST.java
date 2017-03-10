import java.util.Random;

public class TestBST 
{
	public static void main(String[] args) 
	{
		
		Random ran= new Random();
		
		//testing
		
		//Full Tree
		BSTree tree= new BSTree(33);
		tree.insert(10);
		tree.insert(22);
		tree.insert(33);
		tree.insert(44);
		tree.insert(55);
		tree.insert(66);
		tree.insert(77);
		System.out.println("The inorder print is:");
		tree.inOrderPrint();
		
		System.out.println("\n The Max and Min are:");
		System.out.println(tree.findMax());
		System.out.println(tree.findMin());
		System.out.println();
		
		
		//testing empty tree
		System.out.println("Inorder Print, Max, Min of empty tree are:");
		BSTree sapling= new BSTree();
		sapling.inOrderPrint();
		System.out.println(sapling.findMax());
		System.out.println(sapling.findMin());
		
		BSTree randTree = new BSTree();
		for(int i=0;i<10;i++)
		{
			randTree.insert(ran.nextInt(100));
		}
		System.out.println("The inorder print of our random tree is:");
		randTree.inOrderPrint();
	}
}
