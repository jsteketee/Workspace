public class DLLNode {
	//String takes in name and score
	public Object data;
	public DLLNode next;
	public DLLNode prev;
	
	public DLLNode (Object data)
	{
		this.data=data;
		this.next=null;
		this.prev = null;
	}

}