/*
 * Assignment #2
 * 
 * Author:       Jack_Steketee
 * Date :        3/4/15
 * Description: 
 * Populates a DL list from text file, including student name, score. 
 * Offers a variety of options to view, create, delete, and modify entries. 
 */

import java.io.*;
import java.util.*;

public class DLLStudentOperations 
{
	//Creates Scanner and populates the student list. 
	//Method Works
	public static void readPopulate (DLinkedList list, String inFileName)
	{
		try
		{
			Scanner input = new Scanner(new File(inFileName));
			while(input.hasNextLine())
			{
				String name=input.next();
				int score=input.nextInt();
				list.addToBeginning(new StudentScore(name, score));
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("No Text File Found");
		}
	}
	
	public static void updateFile (DLinkedList list , String outFileName)
	{
		try {
			PrintStream output=new PrintStream(new File(outFileName));
			DLLNode temp=list.getHead();
			while(temp!=null)
			{
				output.println(temp.data.getName()+" , "+temp.data.getScore());
				temp=temp.next;
			}
		
		} catch (FileNotFoundException e) {
			
			System.out.println("Error updating file");
		}
	}
	
	public static void displayList(DLinkedList list)
	{
		System.out.println("\nStudent List("+list.getLength()+"): \n---------");
		list.printList();
	}
	
	public static void sort(DLinkedList list)
	{	
		boolean sorting=true;
		DLLNode temp=list.getHead();
		while(sorting)
		{
			sorting=false;
			while(temp!=null && temp.next!=null)
			{
				if(temp.data.compareTo(temp.next.data)>0)
				{
					swap(list, temp.data, temp.next.data);
					sorting=true;
				}
				temp=temp.next;
			}
			temp=list.getHead();
		}
	}
	public static StudentScore searchByName(DLinkedList list, String name)
	{
		StudentScore student=null;
		DLLNode temp = list.getHead();
		while(temp!=null)
		{
			if (temp.data.getName().equals(name))
			{
				System.out.println("\n"+temp.data.toString());
				student=temp.data;
			}	
			temp=temp.next;
		}	
		if (student==null)
			System.out.println("Error: Student does not exist.");
		return student;
	}
	public static void swap(DLinkedList list, StudentScore a, StudentScore b )
	{
		list.replace(b, a);
		list.replace(a, b);
	}
	public static void main(String[] args)
	{
		//Declares empty list 
		DLinkedList SList = new DLinkedList();
		readPopulate(SList, args[0]);
		sort(SList);
		// and populates.
		
		//Two Scanners for user input. 
		Scanner scanInt=new Scanner(System.in);
		Scanner scanStr=new Scanner(System.in);
		
		boolean showMenu = true;
		//while loop displays menu options. 
		while (showMenu)
		{
			//Operation key
			System.out.println("\n**************\nOperation Key:\n1.Add Student\n2.Find Student\n3.Find Student With Max\n"
					+ "4.Find Student With Min\n5.Display Sorted List\n6.Delete Student\n7.Change Student Score\n8.Quit\n9.Clear List\n**************");
			
			//Choice input
			System.out.println("\nPlease Enter Operation Number.");
			int choice=0; 
			choice=scanInt.nextInt();	
			switch (choice)
			{
				//Add Student
				case 1:
					System.out.println("Enter new student name.");
					String name = scanStr.next();
					System.out.println("Enter new student score");
					int score = scanInt.nextInt();
					SList.addToBeginning(new StudentScore(name,score));
					System.out.println("The following student has been added:");
					searchByName(SList, name);
					sort(SList);
					break;
				//Student Lookup	
				case 2: 
					System.out.println("Enter the name of the student you would like to search.");
					String searchName= scanStr.next();
					searchByName(SList, searchName);
					break;
				//Max Score
				case 3:
					if (SList.getHead()!=null)
					{
						System.out.println("\nBest Student Score:");
						System.out.println(SList.getHead().data.toString());
					}
					else 
						System.out.println("Student list is empty.");
					break;
				//MinScore
				case 4:					
					if (SList.getHead()!=null)
					{
						System.out.println("\nWorst Student Score:");
						System.out.println(SList.getTail().data.toString());
					}
					else 
						System.out.println("Student list is empty.");
					break;
				//Display Sorted List
				case 5: 
					displayList(SList);
					break;
				//Delete STudent
				case 6:
					System.out.println("Enter the name of defective student.");
					String eraseName = scanStr.next();
					System.out.println("\nThe following student is being removed..");
					StudentScore toDelete=searchByName(SList, eraseName);
					if (toDelete!=null)
						SList.delete(toDelete);
					break;
				case 7:
					System.out.println("Enter the name of the student you would like to access.");
					String editName= scanStr.next();
					System.out.println("Enter "+editName+"'s new score.");
					int newScore= scanInt.nextInt();
					System.out.println("Searching for student..");
					StudentScore student=searchByName(SList, editName);
					if (student!=null)
					{
						SList.replace(student,new StudentScore (editName,newScore));
						System.out.println("Updated student:");
						searchByName(SList, editName);
					}	
					break;
				case 8:
					System.out.println("Program is shutting down.");
					showMenu=false;
					break;
				case 9:
					SList.clearList();
					System.out.println("List is cleared.");
					break;
				default:
					System.out.println("Please enter a valid command");
					break;
			}
		}
		//Calls upon method that overrides input file with the changes made. 
		updateFile(SList,args[0]);
	}
}
