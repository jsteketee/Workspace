import java.util.*;
public class HowManyStudents 
{
	public static void printTheNumbers(int list[])
	{
		for (int i=0; i < list.length; i++)
		{
			System.out.println(list[i]);
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner input= new Scanner(System.in);
		int HowManyStudents;
		
		System.out.println("How Many Numbers Will You Enter?");
		HowManyStudents= input.nextInt();
		int scores[]=new int [HowManyStudents];
		
		
		int i; i=0;
		while ( i <= HowManyStudents)
		{
			System.out.println("Enter Score #"+(i+1));
			scores[i]= input.nextInt();
			i++;
		}
		
		//we have all the scores
		System.out.println("The unsorted scores are:/n");
		printTheNumbers(scores);
		
		

	}

}
