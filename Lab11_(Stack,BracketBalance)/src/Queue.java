
import java.util.ArrayList;


public class Queue 
{
	private ArrayList<String> theQ; // enqueue to the end, dequeue from the beginning
	
	public Queue()
	{
		theQ = new ArrayList<String>(); // creates an empty array list 
	}
	
	public void enqueue(String s)
	{
		theQ.add(s);  // adds to the end
	}
	
	public String dequeue()
	{
		if (isEmpty())
		{
			return null;
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