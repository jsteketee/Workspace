
public class Item {

	private String name;
	private double price; 
	private int quantity; 
	
	public Item (String n, double p, int q)
	{
		setName(n);
		setPrice(p);
		setQuantitiy(q);
	}
	public void setName(String n)
	{
		name=n;
	}
	public void setQuantitiy(int q) 
	{
		if (q > -1)
			quantity=q;
		else 
			quantity=0;
	}

	public void setPrice(double p) 
	{
		price = p; 
	}
	public String getName()
	{
		return name;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public double getPrice()
	{
		return price;
	}
	public String toString()
	{
		return "  Item: "+getName()+ "  Quantity: "+getQuantity()+"  Price: "+getPrice();
	}
}
