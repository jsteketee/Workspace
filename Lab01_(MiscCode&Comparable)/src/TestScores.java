
public class TestScores 
{

	
	public static void displayList(StudentScore [] a)
	{
	for (int i=0; i<a.length; i++)
		System.out.println(a[i]);
	}
	
	public static void selectionsSort(StudentScore [] a)
	{	
			for(int pass= 1; pass< a.length; pass++)
			{
				for (int i=0; i < (a.length-pass); i++)
				{
					if (a[i].compareTo(a[i+1]) > 0)
						swap ( a, i,i+1);
				}
			}
			
	}
	
	public static void swap( StudentScore nums[], int first, int second )
	{
	    StudentScore hold;
	    hold           = nums[ first ];
	    nums[ first ]  = nums[ second ];
	    nums[ second ] = hold;
	}
	
	public static void main(String[] args) {
		
		
		
		StudentScore s1 = new StudentScore("joe", 45); 
		StudentScore s2 = new StudentScore("john", 95); 
		StudentScore s3 = new StudentScore("sam", 94); 
		StudentScore s4 = new StudentScore("will", 35); 
		StudentScore s5 = new StudentScore("Josh", 75); 
		StudentScore s6 = new StudentScore("tom", 75); 
		StudentScore s7 = new StudentScore("jack", 65); 
		StudentScore s8 = new StudentScore("ian", 94); 
		StudentScore s9 = new StudentScore("tim", 93); 
		StudentScore s10 = new StudentScore("tyler", 35); 
		
		StudentScore [] studentList = {s1, s2, s3, s4, s5, s6,s7,s8,s9,s10};
		
		displayList(studentList);
		
		System.out.println("\n\n");
		
		selectionsSort(studentList);
		
		displayList(studentList);
	}

}
