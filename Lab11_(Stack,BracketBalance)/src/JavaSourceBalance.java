import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class JavaSourceBalance 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		//vars
		
		
		
		
		StackofChars stack = new StackofChars();  //stack created
		String inFileName = args[0];					//in file text name
		Scanner input = new Scanner(new File(inFileName));
		
		while (input.hasNextLine())
		{
			String line=input.nextLine();			//grabs a line
			int length = line.length();				//gets line length
			for(int i=0; i<length;i++)				//checks characters of line string
			{										//from zero to length. 
				if (line.charAt(i)=='}' || line.charAt(i)=='{')
				{	
					stack.push(line.charAt(i));        //adds char to stack if {,}
					
				}
			}
		}
		
		int countLeft=0;
		
		
		while (!stack.isEmpty())
		{
			if (stack.pop().equals("}"))
			{
				countLeft++;
			}
			if (stack.pop().equals("{"))
				countLeft--;
			if (countLeft<0)
				break;
		}
		
		if (countLeft==0)
			System.out.println("---curly braces are balanced.");
		else
			System.out.println("---curly braces are unbalanced");
		
		
	}
}
