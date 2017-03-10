
public class QTestt {

	public static void main(String[] args) {
		PriorityQueue q=new PriorityQueue(10);
		q.enqueue(1,0);
		q.enqueue(2,1);
		q.enqueue(3,2);
		q.enqueue(4,3);
		q.enqueue(5,4);
		q.enqueue(6,5);
		q.enqueue(7,6);
		q.enqueue(1,0);
		q.enqueue(2,1);
		q.enqueue(3,2);
		q.enqueue(4,3);
		q.enqueue(5,9);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}

}
