
public class TestQueueOfStrings {

	public static void main(String[] args) {
	
		QueueOfStrings list = new QueueOfStrings();
		
		
		
		list.enqueue("first");
		list.enqueue("second");
		list.enqueue("third");
		list.enqueue("fourth");
		list.enqueue("fifth");
		
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println();
	
		
		list.enqueue("a");
		list.enqueue("b");
		System.out.println(list.dequeue());
		 
		System.out.println(list.empty());

		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		System.out.println(list.dequeue());
		
		System.out.println("is list empty?");
		System.out.println(list.empty());
		
	}

}
