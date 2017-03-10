
public class StackofChars {
	
	private char[] stack;
	int top;
	
	public StackofChars()
	{
		stack= new char[100];
		top=-1;
	}
	public void push(char c)
	{
		stack[++top]=c;
	}
	public String pop()
	{
		String temp;
		if (top==-1)
			temp="Stack is empty";
		else
		{
			temp=Character.toString((stack[top]));
			top--;
		}
		return temp;
	}
	public char peek()
	{
		if(top!=-1)
			return stack[top];
		else 
			return ' ';
	}
	public boolean isEmpty()
	{
		boolean isEmpty=false;
		if (top==-1)
			isEmpty = true;
		
		return isEmpty;
	}
}
