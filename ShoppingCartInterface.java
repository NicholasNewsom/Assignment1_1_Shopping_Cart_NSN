

public interface ShoppingCartInterface 
{
	/**
	 * gets number of items in cart
	 * @return int of the number of items in cart
	 */
	public int getCurrentSize();
	
	/**
	 * checks if the cart is empty
	 * @return true if it is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * adds a new item to the cart
	 * @param newItem the item that will be added
	 * @return true if successful, false otherwise
	 */
	public boolean add(Item newItem);
	
	/**
	 * removes a item from the cart at random
	 * @return the new item if successful, otherwise null
	 */
	public Item remove();
	
	/**
	 * removes a specified item from the cart
	 * @param anItem the item that will be removed
	 * @return true if successful, false otherwise
	 */
	public boolean remove(Item anItem);
	
	/**
	 * clears cart of all items
	 */
	public void clear();
	
	/**
	 * counts how many times an item appears in the cart
	 * @param anItem the item to be counted
	 * @return int for the number of times it appears in the cart
	 */
	public int getFrequencyOf(Item anItem);
	
	/**
	 * checks if cart contains a certain item
	 * @param anItem item to be checked for
	 * @return true if in cart, false otherwise
	 */
	public boolean contains(Item anItem);
	
	/**
	 * retrieves items from the cart and puts them in an array
	 * @return new array of the items in the cart
	 */
	public Object[] copyToArray();
	
	/**
	 * checks the price of an item
	 * @param anItem item whose price will be checked
	 * @return price of the item
	 */
	public double getPrice(Item anItem);
	
	/**
	 * sum of the prices of all items in the cart
	 * @return total of all item's prices
	 */
	public double getTotal();
}
