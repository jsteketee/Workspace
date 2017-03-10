
public class TestBSTree2 {

	public static void main(String[] args) {
		
		BSTree2 oak= new BSTree2(8);
		
		oak.insert(7);
		oak.insert(55);
		oak.insert(4);
		oak.insert(42);
		oak.insert(5);
		oak.insert(2);
		oak.insert(10);
		
		oak.inOrderPrint();
		System.out.println();
		System.out.println(oak.findMax());
		System.out.println(oak.findMin());
		System.out.println();
		
		//testing empty oak
		BSTree2 sapling= new BSTree2();
		sapling.inOrderPrint();
		System.out.println(sapling.findMax());
		System.out.println(sapling.findMin());
		
		System.out.println();
		BSTree2 test = new BSTree2();
		test.insert(13);
		test.insert(45);
		test.insert(10);
		test.insert(9);
		test.insert(54);
		test.insert(11);
		test.inOrderPrint();
		System.out.println();
		System.out.println(test.findMax());
		System.out.println(test.findMin());
		

	}

}
