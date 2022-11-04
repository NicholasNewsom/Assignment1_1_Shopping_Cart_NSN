package CS;

public class ShoppingCart implements ShoppingCartInterface
{
	private ResizableArrayBag<Item> Shoppingcart;
	int lastSize = 0;
	
	/**
	 * creating Shopping cart
	 */
	public ShoppingCart()
	{
		Shoppingcart = new ResizableArrayBag<Item>();
	}
	
	/**
	 * gets number of items in cart
	 * @return int of the number of items in cart
	 */
	public int getCurrentSize() 
	{
		return Shoppingcart.getCurrentSize();
	}

	/**
	 * checks if the cart is empty
	 * @return true if it is empty, false otherwise
	 */
	public boolean isEmpty() 
	{
		return Shoppingcart.isEmpty();
	}
	
	/**
	 * adds a new item to the cart
	 * @param newItem the item that will be added
	 * @return true if successful, false otherwise
	 */
	public boolean add(Item newItem) 
	{
		return Shoppingcart.add(newItem);
	}

	/**
	 * removes a item from the cart at random
	 * @return the new item if successful, otherwise null
	 */
	public Item remove() 
	{
		return Shoppingcart.remove();
	}

	/**
	 * removes a specified item from the cart
	 * @param anItem the item that will be removed
	 * @return true if successful, false otherwise
	 */
	public boolean remove(Item anItem) 
	{
		return Shoppingcart.remove(anItem);
	}

	/**
	 * clears cart of all items
	 */
	public void clear() 
	{
		Shoppingcart.clear();
	}

	/**
	 * counts how many times an item appears in the cart
	 * @param anItem the item to be counted
	 * @return int for the number of times it appears in the cart
	 */
	public int getFrequencyOf(Item anItem) 
	{
		return Shoppingcart.getFrequencyOf(anItem);
	}

	/**
	 * checks if cart contains a certain item
	 * @param anItem item to be checked for
	 * @return true if in cart, false otherwise
	 */
	public boolean contains(Item anItem) 
	{
		return Shoppingcart.contains(anItem);
	}

	/**
	 * retrieves items from the cart and puts them in an array
	 * @return new array of the items in the cart
	 */
	public Object[] copyToArray() 
	{
		return Shoppingcart.toArray();
	}

	/**
	 * checks the price of an item
	 * @param anItem item whose price will be checked
	 * @return price of the item
	 */
	public double getPrice(Item anItem) 
	{
		return anItem.getPrice();
	}

	/**
	 * sum of the prices of all items in the cart
	 * @return total of all item's prices
	 */
	public double getTotal() 
	{
		double totalPrice = 0;
		Object[] cart = Shoppingcart.toArray();
		
		for(int i = 0; i < Shoppingcart.getCurrentSize(); i++)
		{
			totalPrice = totalPrice + ((Item) cart[i]).getPrice();
		}
		return totalPrice;
	}
	
	public String toString()
	{
		String list = "";
		Object[] cart = Shoppingcart.toArray();
		
		for(int i = 0; i < Shoppingcart.getCurrentSize(); i++)
		{
			list += cart[i] + "\n";
		}
		return list;
	}
	
}
