
public class QueueOfStrings {
	
	private DLinkedList list;
	
	public QueueOfStrings()
	{
		list = new DLinkedList();
	}
	public QueueOfStrings(String string)
	{
		list = new DLinkedList(string);
	}
	
	public void enqueue(String s)
	{
		list.addToBeginning(s);
	}
	public String dequeue()
	{
		if (list.getHead()!=null)
			return list.deleteTail();
		else
			return "End of Queue";
	}
	public boolean empty()
	{
		if (list.getHead()!=null)
			return false;
		else 
			return true;
	}
}
