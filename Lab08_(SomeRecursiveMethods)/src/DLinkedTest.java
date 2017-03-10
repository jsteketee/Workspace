
public class DLinkedTest {

	public static void main(String[] args) {
		DLinkedList list = new DLinkedList();
		list.addToBeginning(-7);
		list.addToBeginning(5);
		list.addToBeginning(9);
		list.addToBeginning(10);
		list.addToBeginning(0);
		
		System.out.println("RecLength:");
		System.out.println(list.findLengthRec());
		
		System.out.println("RecLargestVal:");
		System.out.println(list.findLargestRec());
		
		System.out.println("RecSmallestVal:");
		System.out.println(list.findSmallestRec());
	}

}
