
import java.util.ArrayList;


	public class Queue 
	{
		private ArrayList<Integer> theQ; // enqueue to the end, dequeue from the beginning
		
		public Queue()
		{
			theQ = new ArrayList<Integer>(); // creates an empty array list 
		}
		
		public void enqueue(int s)
		{
			theQ.add(s);  // adds to the end
		}
		
		public int dequeue()
		{
			if (isEmpty())
			{
				return (Integer) null;
			}
			else
			{
				return theQ.remove(0); // remove from the beginning
			}
		}
		
		public boolean isEmpty()
		{
			return theQ.size() == 0;
		}

	}