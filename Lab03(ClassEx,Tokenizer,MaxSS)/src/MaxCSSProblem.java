public class MaxCSSProblem {

	public static int startIdx, endIdx, tempStart; 
	
	public static void displaySubsequence(int list[], int s, int e)
	{
		if (endIdx==-1)
		{
			System.out.println("empty subsequence");
		}
		else
		{
			System.out.println("start and end index is "+startIdx+" and "+ endIdx);
			System.out.println("The max subsequence contains:");
			for (int i=s; i<=e; i++)
			{
				System.out.print(list[i]+" ");
			}
		}
	}
	// this is the linear algorithm to solve it
	public static int maxCSS3(int list[])
	{
		int maxSum = 0;
		int currSum = 0;
		tempStart=0;
		startIdx = 0; 
		endIdx = -1;
		for (int ei=0;  ei<list.length; ei++)
		{
			currSum += list[ei];

			// check if the currSum is best yet
			if (currSum >= maxSum)
			{
				maxSum = currSum;
				endIdx = ei;
				startIdx=tempStart;
			}
			
			// check if the sum becomes negative and set si, ei appropriately
			if (currSum < 0)
			{
				currSum = 0;
				tempStart=ei+1;
				
			}
			
		}
		
		return maxSum;
	}
	
	// a bit better than brute-force way
	public static int maxCSS2(int list[])
	{
		int maxSum = 0;
		tempStart=0;
		startIdx = 0; 
		endIdx = -1;
		
		for (int si=0; si < list.length; si++)
		{
			int currSum = 0;
			for (int ei=si; ei < list.length; ei++)
			{
				currSum += list[ei]; // currSum = currSum + list[i];
				
				if (currSum > maxSum)
				{
					maxSum = currSum;
					startIdx=si;
					endIdx=ei;
					
				}
			}
			
		}
		
		return maxSum;
	}

	
	// brute-force look at EVERY subsequence
	public static int maxCSS1(int list[])
	{
		int maxSum = 0;
		tempStart=0;
		startIdx = 0; 
		endIdx = -1;
		
		for (int si=0; si < list.length; si++)
		{
			for (int ei=si; ei < list.length; ei++)
			{
				int currSum = 0;
				for (int i=si; i<=ei; i++)
				{
					currSum += list[i]; // currSum = currSum + list[i];
				}
				
				if (currSum > maxSum)
				{
					maxSum = currSum;
					startIdx=si;
					endIdx=ei;
				}
			}
			
		}
		
		
		return maxSum;
	}
	
	public static void main(String[] args) 
	{
		int nums[] = {6,10,16, -100, -2,50};
		int maxCSSum;
		//tests each method
		maxCSSum = MaxCSSProblem.maxCSS3(nums);
		System.out.println("The maximum sum of a continuous subsequence is " + maxCSSum);
		displaySubsequence(nums, startIdx, endIdx);
		System.out.println("\n");
		
		maxCSSum = MaxCSSProblem.maxCSS2(nums);
		System.out.println("The maximum sum of a continuous subsequence is " + maxCSSum);
		displaySubsequence(nums, startIdx, endIdx);
		System.out.println("\n");
		
		maxCSSum = MaxCSSProblem.maxCSS1(nums);
		System.out.println("The maximum sum of a continuous subsequence is " + maxCSSum);
		displaySubsequence(nums, startIdx, endIdx);
		System.out.println("\n");
		
	}

}