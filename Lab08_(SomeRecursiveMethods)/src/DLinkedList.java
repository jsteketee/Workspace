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
	}
	// constructor that takes in a int that gets made into a Node 
	// that makes the linked list be of size 1 
	public DLinkedList(int s)
	{
		head = new DLLNode(s);
		tail = head;
		length=1;
	}
	// works whether or not linkedL is empty
	public void addToBeginning(int ToBeAdded)
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
	public boolean search(int s)
	{
		DLLNode temp = head;
		boolean found=false;
		
		while (temp != null)
		{
			if (temp.data==s)
			{
				found=true;
			}
			temp = temp.next;
		}
		
		return found;
	}
	//Takes int and returns Node
	public DLLNode searchForNode(int s)
	{
		
		DLLNode temp = head;
		
		while (temp != null && !(temp.data==s))
		{
			temp = temp.next;
		}
		
		return temp;
	}
	//Swaps two student scores
	public boolean replace(int find, int replace)
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
	public void delete(int toDelete) //temp is never null because of  check in main (case 6)
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
	
	public int findLengthRec()
	{
		if (head==null)
			return 0;
		return findLengthRec(head);
	}
	public int findLengthRec(DLLNode n)
	{
		if (n==tail)
			return 1;
		else 
			return 1+findLengthRec(n.next);
		
	}
	public int findLargestRec()
	{
		if (head==null)
			return -1000;
		if (head.next==null)
			return head.data;
		
		return findLargestRec(head, head.next);
	}
	public int findLargestRec(DLLNode keep, DLLNode n)
	{
		if (n.data > keep.data)
			keep=n;
		if (n==tail)
			return keep.data;
		return findLargestRec(keep,n.next);
		
	}
	
	// smallest in the whole list
	public int findSmallestRec()
	{
		if (head==null)
			return -1000;
		if (head.next==null)
			return head.data;
		
		return findSmallestRec(head, head.next);
	}
	public int findSmallestRec(DLLNode keep, DLLNode n)
	{
		if (keep.data > n.data)
			keep=n;
		if (n==tail)
			return keep.data;
		return findSmallestRec(keep,n.next);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

	
	