import java.util.ArrayList;
public class Stack {
	
	private ArrayList<String> myStack;
	private int top;
	
	public Stack()
	{
		myStack= new ArrayList<String>();
		top=-1;
	}
	public void push(String s)
	{
		myStack.add(s);
		top++;
	}
	public String pop()
	{
		String temp="";
		if (top==-1)
			System.out.println("Stack is empty");
		else
		{
			temp= myStack.remove(top);
			top--;
		}
		return temp;
	}
	public String peek()
	{
		if(top!=-1)
			return myStack.get(top);
		else 
		{
			System.out.println("Stack is Empty");
			return "";
		}
			
	}
	public boolean isEmpty()
	{
		boolean isEmpty=false;
		if (top==-1)
			isEmpty = true;
		
		return isEmpty;
	}
}
