import java.util.ArrayList;


public class ProcessItems 
{

	public static void main(String[] args) 
	{
		ArrayList <Item> list = new ArrayList<Item>();
		ItemListMethods.itemsPopulate(args[0],list);
		ItemListMethods.displayItems(list);
	}

}
