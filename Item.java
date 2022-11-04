

public class Item 
{
	private String name;
	private double price;
	
	public Item(String itemName, double itemPrice)
	{
		name = itemName;
		price = itemPrice;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String toString()
	{
		return String.format("Item: %s, %.2f", name, price);
	}
}
