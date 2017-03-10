import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class codespace {

	public static void main(String[] args) 
	{
		int MAX_ROLL = 8; 
		int MIN_ROLL = -2; 
		Random rand = new Random();
		for(int i =0; i<100; i++)
			System.out.println(rand.nextInt(MAX_ROLL+1-MIN_ROLL)+MIN_ROLL); 
		
	
	}
/*tring[] s = {"a","b","c","d","e","f"};  
		for (String a : s)
		{
			System.out.println(a);
		}
		Collections.shuffle(Arrays.asList(s));
		System.out.println("after shuffle:");
		for (String a : s)
		{
			System.out.println(a);
		}
	}
	
	
	
	
	
	
	
	 public static String everyOther(String value)
	    {
	        StringBuffer skip = new StringBuffer();
	        int start;

	        if (value.length() % 2 == 0)
	        {
	            start = 1;
	        }
	        else
	        {
	            start = 0;
	        }

	        for (int posit = start; posit < value.length(); posit+=2)
	        {
	            skip.append(value.charAt(posit));
	        }

	        return skip.toString();
	    }
	    */
}
