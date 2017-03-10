
public class TestPriorityQueue {

	public static void main(String[] args) {
		PriorityQueue MyQ = new PriorityQueue(10);
		
		MyQ.enqueue("1st String(3)", 3);
		MyQ.enqueue("2nd String(3)",3);
		MyQ.enqueue("nine",9);
		MyQ.enqueue("AlsoHigh(10)",10);
		MyQ.enqueue("Highest,(11)",11);
		
		
		System.out.println(MyQ.dequeue());
		System.out.println(MyQ.dequeue());
		System.out.println(MyQ.dequeue());
		System.out.println(MyQ.dequeue());
		System.out.println(MyQ.dequeue());
		
		
	}

}
