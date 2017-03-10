import java.io.*;
import java.util.*;


public class ItemListMethods {

	public static void itemsPopulate(String file, ArrayList<Item> list)
	{
		StringTokenizer st;
		try 
		{
			Scanner input = new Scanner(new File(file));
			while(input.hasNext())
			{
				String oneLine=input.next();
				st = new StringTokenizer(oneLine, ",");
				String name = st.nextToken();
				String prStr = st.nextToken();
				String quantityStr = st.nextToken();
				
				list.add(new Item(name, Double.parseDouble(prStr), Integer.parseInt(quantityStr)));
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("No File found.");
		}
	}
	
	public static void displayItems(ArrayList <Item> list)
	{
		System.out.println("\nItem List:");
		for(int i=0; i< list.size(); i++)
			System.out.println(list.get(i).toString());
	}	
}
	