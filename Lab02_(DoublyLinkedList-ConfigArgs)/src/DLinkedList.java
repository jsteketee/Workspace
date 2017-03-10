
public class DLinkedList
{
	
	private DLLNode head;
	private DLLNode tail;
	
	// default constructor to create an empty linked list
	public DLinkedList()
	{
		head = null;
		tail = null;
	}
	public DLLNode getHead()
	{
		return head;
	}
	public DLLNode getTail()
	{
		return tail;
	}
	// constructor that takes in a Node that makes the linked list be of size 1 
	public DLinkedList(DLLNode n)
	{
		head = n;
		tail = n;
	}
	// constructor that takes in a StudentScore that gets made into a Node 
	// that makes the linked list be of size 1 
	public DLinkedList(StudentScore s)
	{
		head = new DLLNode(s);
		tail = head;
	}
	// works whether or not linkedL is empty
	public void addToBeginning(StudentScore ToBeAdded)
	{	
		DLLNode ToAdd = new DLLNode(ToBeAdded);
		if(head==null)
		{
			head=ToAdd;
			tail=head;
		}
		else
		{
			ToAdd.next = this.head;
			this.head = ToAdd;
		}
	}
	//gets Length of list
	public int length()
	{
		int i = -1;
		if (head!=null)
		{
			i=i+2;
			DLLNode temp=head;
			while (temp.next!=null)
			{
				temp=temp.next;
				i++;
			}
		}
		return i;
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
	public boolean delete(StudentScore toDelete)
	{
		DLLNode temp=searchForNode(toDelete);
		boolean deleted=false;
		
		if (temp!=null)
		{
			if(temp==head)
				temp.next=head;
			if(temp==tail)
				temp.prev=tail;
			else
			{
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
			}
			deleted=true;
		}
		
		return deleted;
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
	// clears list
	public void clearList()
	{
		head=null;
	}
	
}

	
	