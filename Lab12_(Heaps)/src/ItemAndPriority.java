
public class ItemAndPriority 
{
	private String dataItem;
	private int priorityValue;
	
	public ItemAndPriority(String s, int p)
	{
		dataItem = s;
		priorityValue = p;
	}

	public int getPriority()
	{
		return priorityValue;
	}

	public String getData()
	{
		return dataItem;
	}
}