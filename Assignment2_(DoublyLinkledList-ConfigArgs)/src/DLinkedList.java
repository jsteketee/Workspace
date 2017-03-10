public class DLinkedList
{
	
	private DLLNode head;
	private DLLNode tail;
	private int length;
	
	// default constructor to create an empty linked list
	public DLinkedList()
	{
		head = null;
		tail = null;
		int length = 0;
	}
	
	//provides access to private variables.
	public DLLNode getHead()
	{
		return head;
	}
	public DLLNode getTail()
	{
		return tail;
	}
	public int getLength()
	{
		return length;
	}
	
	// constructor that takes in a Node that makes the linked list be of size 1 
	public DLinkedList(DLLNode n)
	{
		head = n;
		tail = n;
		if (n!=null)
			length=1;
		else
			length=0;
	}
	// constructor that takes in a StudentScore that gets made into a Node 
	// that makes the linked list be of size 1 
	public DLinkedList(StudentScore s)
	{
		head = new DLLNode(s);
		tail = head;
		if (head!=null)
			length=1;
		else length=0;
	}
	// works whether or not linkedL is empty
	public void addToBeginning(StudentScore ToBeAdded)
	{	
		length++;
		DLLNode ToAdd = new DLLNode(ToBeAdded);
		if(head==null)
		{
			head=ToAdd;
			tail=head;
		}
		else
		{
			ToAdd.next = this.head;
			this.head.prev = ToAdd;
			this.head = ToAdd;
		}
	}
	
	//checks to see if node Exists
	public boolean search(StudentScore s)
	{
		DLLNode temp = head;
		boolean found=false;
		
		while (temp != null)
		{
			if (temp.data.compareTo(s)==0)
			{
				found=true;
			}
			temp = temp.next;
		}
		
		return found;
	}
	//Takes StudentScore and returns Node
	public DLLNode searchForNode(StudentScore s)
	{
		
		DLLNode temp = head;
		
		while (temp != null && !(temp.data.compareTo(s)==0))
		{
			temp = temp.next;
		}
		
		return temp;
	}
	//Swaps two student scores
	public boolean replace(StudentScore find, StudentScore replace)
	{
		DLLNode n = searchForNode(find);
		Boolean replaced=false;
		if (n != null)
		{
			n.data = replace;
			replaced= true;
		}
		
		return replaced;
	}
	//deletes node
	public void delete(StudentScore toDelete) 
	//temp is never null because of  check in main (case 6)
	{
		DLLNode temp=searchForNode(toDelete);
	
		if (length==1)
		{
			head=null;
			tail=null;
		}
		else
		{
			if (temp!=head && temp!=tail )
			{
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
				temp=null;
			}
			if (temp==head)
			{
				head=temp.next;
				head.prev = null;
			}
			if (temp==tail)
			{
				tail=temp.prev;
				tail.next = null;
			}
		}
		length--;
	}
	//prints data of each node. 
	public void printList()
	{
		DLLNode temp = head;
		while (temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println();
	}

	//prints data of each node. 
	public void printListBack()
	{
		DLLNode temp = tail;
		while (temp!=null)
		{
			System.out.println(temp.data);
			temp=temp.prev;
		}
		System.out.println();
	}
	
	// clears list
	public void clearList()
	{
		head=null;
		tail=null;
		length=0;
	}
	
}

	
	