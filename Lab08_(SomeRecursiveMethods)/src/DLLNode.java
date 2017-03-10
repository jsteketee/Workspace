public class DLLNode {
	//StudentScore takes in name and score
	public int data;
	public DLLNode next;
	public DLLNode prev;
	
	public DLLNode (int data)
	{
		this.data=data;
		this.next=null;
		this.prev = null;
	}

}