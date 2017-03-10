
public class DivideConquer 
{	
	public static void rearrange(int list[])
	{
		System.out.println("Unsorted List:");
		printList(list);
		rearrange(list, 0, list.length-1);
		System.out.println("Sorted List:");
		printList(list);
		System.out.println();
	}
	
	public static void rearrange(int list[], int sIdx , int eIdx )
	{
		//basecase
		if (eIdx-sIdx ==0 )
		{
			return;
		}
		
		int midIdx = (sIdx + eIdx) / 2; // we know that it is integer div.
		rearrange(list, sIdx, midIdx);
		rearrange(list, midIdx+1, eIdx);
		
		conquer(list, sIdx, midIdx, eIdx);
		
		
	   
	
		
	}
	public static void conquer(int list[], int sIdx, int midIdx, int eIdx)
	{
		int tempList[] = new int[eIdx - sIdx + 1];
		int leftIdx=sIdx;
		int rightIdx=midIdx+1;
		int i=0;

		// copies the odds from left half
		while (leftIdx<=midIdx && list[leftIdx]%2!=0)
		{
			tempList[i] = list[leftIdx];
			leftIdx++;
			i++;
		}
		// copies odds from right half
		while (rightIdx <=eIdx &&  list[rightIdx]%2!=0)
		{
			tempList[i] = list [rightIdx];
			rightIdx++;
			i++;
		}
		
		while (leftIdx<=midIdx)
		{
			tempList[i] = list[leftIdx];
			leftIdx++;
			i++;
		}
		while (rightIdx<=eIdx)
		{
			tempList[i] = list [rightIdx];
			rightIdx++;
			i++;
		}
		int listIdx = sIdx;
		for (int j=0; j < tempList.length; j++, listIdx++)
		{
			list[listIdx] = tempList[j];
		}
	}
	public static void printList(int list[])
	{
		for (int i=0; i< list.length; i++)
		{
			System.out.print(list[i]+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		int[] AllEvensButOne = {2,2,2,2,5,2,2,2,2};
		rearrange(AllEvensButOne);
		
		int[] AllOddsButOne = {1,1,1,1,2,1,1,1,1};
		rearrange(AllOddsButOne);
		int[] AllEvensButOneAtEnd = {2,2,2,2,2,1};
		rearrange(AllEvensButOneAtEnd);
		int[] AllOddsButOneAtEnd = {1,1,1,1,1,2};
		rearrange(AllOddsButOneAtEnd);
		int[] ListOfTwo = {2,3};
		rearrange(ListOfTwo);
		
	}
}
