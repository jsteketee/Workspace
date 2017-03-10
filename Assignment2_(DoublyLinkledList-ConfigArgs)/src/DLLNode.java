public class DLLNode {
	//StudentScore takes in name and score
	public StudentScore data;
	public DLLNode next;
	public DLLNode prev;
	
	public DLLNode (StudentScore data)
	{
		this.data=data;
		this.next=null;
		this.prev = null;
	}

}