/*
 * Assignment #1 
 * 
 * Author:       Jack_Steketee
 * Date :        1/4/14
 * Description: 
 * Populates an array list from text file, including student name, score. 
 * Offers a variety of options to view, create, delete, and modify entries. 
 */

import java.io.*;
import java.util.*;
public class StudentOperations {
	
	//Creates Scanner and populates the student list. 
	public static void readPopulate (ArrayList <StudentScore> list, String inFileName)
	{
		try
		{
			Scanner input = new Scanner(new File(inFileName));
			while(input.hasNextLine())
			{
				String name=input.next();
				int score=input.nextInt();
				list.add(new StudentScore(name, score));
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("No Text File Found");
		}
	}
	
	// displays list.
	public static void displayList(ArrayList <StudentScore> list)
	{
		System.out.println("\nStudent List\n---------");
		for(int i=0; i< list.size(); i++)
			System.out.println(list.get(i).toString());
	}
	
	//Sorts List
	public static void selectionsSort(ArrayList <StudentScore>  list)
	{	
			for(int pass= 1; pass< list.size(); pass++)
			{
				for (int i=0; i < (list.size()-pass); i++)
				{
					if (list.get(i).compareTo(list.get(i+1)) > 0)
						swap ( list, i,i+1);
				}
			}	
	}
	
	// Swaps the index of two students.
	public static void swap( ArrayList <StudentScore>  list, int first, int second )
	{
		StudentScore hold1=list.get(first);
		StudentScore hold2=list.get(second);
	    list.set(first, hold2);
	    list.set(second,hold1);
	}
	
	//Looks up student by name and prints student information.
	public static int searchByName(ArrayList <StudentScore> list, String name)
	{
		int i;
		if(list.size()==0){
			System.out.println("Student does not exist");
			i=-1;
		}
			
		for (i=0;i<list.size();i++)
		{
			if (list.get(i).getName().equals(name)){
				System.out.println("\n"+list.get(i).toString());
				break;
			}
			if(i==list.size()-1){
				System.out.println("Student does not exist");
				i=-1;
				break;	
			}
		}
		return i;
	}
	
	//Finds student by name and edits that students score. 
	public static void editScore(ArrayList <StudentScore> list, String name, int score)
	{
		int i=0;
		for (;i<list.size();i++)
		{
			if (list.get(i).getName().equals(name))
			{
				list.get(i).setScore(score);
				break;
			}
		}	
	}

	public static void main(String[] args) 
	{
		
		//Initializes ArrayList and Populates From Text File
		ArrayList <StudentScore> studentList = new ArrayList<StudentScore>();
		readPopulate(studentList, args[0]);
		
		
		//Two Scanners For User Input
		Scanner scanInt=new Scanner(System.in);
		Scanner scanStr=new Scanner(System.in);
		
		System.out.println("Operation Key:\n1.Add Student\n2.Find Student\n3.Find Student With Max\n"
				+ "4.Find Student With Min\n5.Display Sorted List\n6.Delete Student\n7.Change Student Score\n8.Quit");
		
		boolean showMenu = true;
		
		//while loop displays menu options. 
		while (showMenu)
		{
			System.out.println("\nPlease Enter Operation Number.");
			int choice=0; 
			choice=scanInt.nextInt();	
			switch (choice)
			{
			
				case 1:
					System.out.println("Enter new student name.");
					String name = scanStr.next();
					System.out.println("Enter new student score");
					int score = scanInt.nextInt();
					studentList.add(new StudentScore(name,score));
						break;
				case 2:
					System.out.println("Enter the name of the student you would like to search.");
					String searchName= scanStr.next();
					searchByName(studentList, searchName);
					break;
				case 3:
					selectionsSort(studentList);
					if (studentList.size()!=0)
					{
						System.out.println("\nBest Student Score");
						System.out.println(studentList.get(0).toString());
					}
					else 
						System.out.println("Student list is empty.");
						
					break;
				case 4:
					selectionsSort(studentList);
					
					if (studentList.size()!=0)
					{
						System.out.println("\nWorst Student Score");
						System.out.println(studentList.get(studentList.size()-1).toString());
					}
					else 
						System.out.println("Student list is empty");
					break;
				case 5:
					selectionsSort(studentList);
					displayList(studentList);
					break;
				case 6:
					System.out.println("Enter the name of defective student");
					String eraseName = scanStr.next();
					System.out.println("\nThe following student is being removed..");
					int i=searchByName(studentList, eraseName);
					if(studentList.size()>0 && !(i==-1))
					{
						studentList.remove(i);
					}
					else System.out.println("");
					break;
				case 7:
					System.out.println("Enter the name of the student you would like to access.");
					String editName= scanStr.next();
					System.out.println("Enter "+editName+"'s new score.");
					int newScore= scanInt.nextInt();
					editScore(studentList, editName, newScore);
					searchByName(studentList, editName);
					break;
				case 8:
					System.out.println("Program is shutting down.");
					showMenu = false;
					break;
				default:
					System.out.println("Follow instructions!!!");
					
			}
		}
		
	}
}
