public class PriorityQueue 
{
	private Queue pQ[];
	private int size; // number of elements in the priority q
	private int priorityOfLowestItem;
	
	public PriorityQueue(int numberOfPriorities)
	{
		pQ = new Queue[numberOfPriorities+1];
		for (int i=0; i< pQ.length; i++)
		{
			pQ[i] = new Queue();
		}
		size = 0;
		priorityOfLowestItem = pQ.length;
	}
	
	public void enqueue(int intToAdd, int priority)
	{
		if (priority>pQ.length-1)		//limits highest/lowest Priority
			priority=pQ.length-1;
		if (priority<0)
			priority=0;
		
		size++;

		// we definitely want to add intToAdd to the appropriate place in pq
		pQ[priority].enqueue(intToAdd);

		// we do want to possibly update priorityOfHighestItem
		if (priority < priorityOfLowestItem)
		{
			priorityOfLowestItem = priority;
		}
		
	}
	
	
	
	public int dequeue()
	{
		if (isEmpty())
		{
			return -1;
		}
		
		// should return the int with the lowest priority in pq
		// and if there are multiple of this lowest priority, we want
		// to return the one that came in earliest
		int intToReturn;
		
		intToReturn = pQ[priorityOfLowestItem].dequeue();
		size--;
		if (size == 0)
		{
			priorityOfLowestItem = pQ.length;
		}
		else
		{
			for (int i=priorityOfLowestItem;i<pQ.length;i++)
			{
				if (!pQ[i].isEmpty())
				{
					priorityOfLowestItem=i;
					break;
				}
			}
		}
		// we have to worry now if we became empty 
		// and even if we didn't become empty, we may have to update 
		// priorityOfLowestItem
		
		return intToReturn;
	}
	
	public boolean isEmpty()
	{
		return size == 0; // if empty, we also expect priorityOfHighestItem == -1
	}
}