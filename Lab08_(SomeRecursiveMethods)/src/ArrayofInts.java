
public class ArrayofInts {

	public static void main(String[] args) {
		
		int[] list = {0};
		
		System.out.println("Sum Method:");
		int a= sum(list);
		System.out.println(a);
		
		System.out.println("allEvens Method");
		boolean b= allEvens(list);
		System.out.println(b);
		
		System.out.println("oneNeg Method");
		boolean n=atLeastOneNegative(list);
		System.out.println(n);
	}
	
	public static boolean atLeastOneNegative(int[] list)
	{
		if (list.length==0)
			return false;
		return atLeastOneNegative(list, 0);
	}
	public static boolean atLeastOneNegative(int[] list, int idx)
	{
		if (list[idx]<0)
			return true;
		if (idx == list.length-1)
			return false;
		return atLeastOneNegative(list, idx+1);
	}
	
	public static boolean allEvens(int [] list)
	{
		if (list.length==0)
			return true;
			
		return allEvens(list, 0);
	}
	public static boolean allEvens(int[] list, int idx)
	{
		if( list[idx]%2!=0)
		{
			return false;
		}
		if (idx==list.length-1)
		{
			return true;
		}			
			
			return allEvens(list, idx+1);
		
	}
	
	public static int sum (int[] list) //base case
	{
		if (list.length==0)
			return 0;
		return sum(list, 0);
	}
	
	public static int sum (int[] list, int idx)
	{
		if (idx==list.length-1)	//stopping condition
			return list[idx];
		else{
			return list[idx]+sum(list, idx+1); //adds idx value to sum of next idx value. 
		}
	}
}
