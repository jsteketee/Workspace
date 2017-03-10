
public class TestHeap {

	public static void main(String[] args) {
		
		Heap myHeap = new Heap();
		myHeap.add("1",1);
		myHeap.add("2",2);
		myHeap.add("6",6);
		myHeap.add("4",4);
		
		//myHeap.print();

		System.out.println(myHeap.remove());
		System.out.println("============");
		myHeap.print();
		System.out.println("============");
		System.out.println(myHeap.remove());
		System.out.println("============");
		myHeap.print();
		System.out.println("============");
		System.out.println(myHeap.remove());
		System.out.println("============");
		myHeap.print();
		System.out.println("============");
		System.out.println(myHeap.remove());
		System.out.println("============");
		myHeap.print();
		//System.out.println(myHeap.remove());
		
	}

}
