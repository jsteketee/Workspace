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

public class DLLStudentOperationsDLL 
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
	
	//Method Works
	public static void displayList(DLinkedList list)
	{
		System.out.println("Student List: \n---------");
		list.printList();
	}
	
	public static void sort(DLinkedList list)
	{	
		boolean sorted=false;
		DLLNode temp=list.getHead();
		while(!sorted)
		{
			sorted=true;
			while(temp.next!=null)
			{
				if(temp.data.compareTo(temp.next.data)>0)
				{
					swap(list, temp.data, temp.next.data);
					sorted=false;
				}
				temp=temp.next;
			}
			temp=list.getHead();
		}
	}
	public static void swap(DLinkedList list, StudentScore a, StudentScore b )
	{
		list.replace(b, a);
		list.replace(a, b);
	}
	public static void main(String[] args)
	{
		//Declares empty list 
		DLinkedList Slist = new DLinkedList();
		readPopulate(Slist, args[0]);
		// and populates.
		
		//Two Scanners for user input. 
		Scanner scanInt=new Scanner(System.in);
		Scanner scanStr=new Scanner(System.in);
		
		//Operation key
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
			/*
				case 1:
					showMenu= false;
					break;
				case 2: 
					break;
				case 3:
					break;
				case 4:
					break;
				case 5: 
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break; 
					*/
				default:
					showMenu=false;
					break;
			}
		}	
		
		
		displayList(Slist);
		sort(Slist);
		
	
		System.out.println();
		displayList(Slist);
		
		/*
		
		System.out.println(Slist.getHead().data);
		System.out.println();
		swap(Slist, Slist.getHead().next.data, Slist.getTail().data);
		displayList(Slist);
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
