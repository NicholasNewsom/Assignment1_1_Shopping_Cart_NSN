

public class ApplicationCart {

	public static void main(String[] args) 
	{
		ShoppingCart shoppingCart = new ShoppingCart();
		System.out.println("Is the cart empty: "+ shoppingCart.isEmpty());
		
		Item item1 = new Item("Avocado", 0.89);
		Item item2 = new Item("Small Pumpkin", 2.50);
		Item item3 = new Item("Pork Chops", 14.11);
		Item item4 = new Item("Alani Energy Drink", 2.50);
		Item item5 = new Item("Reese's Cups", 0.99);
		
		shoppingCart.add(item1);
		shoppingCart.add(item2);
		shoppingCart.add(item3);
		shoppingCart.add(item4);
		shoppingCart.add(item5);
		
		System.out.println("The items currently in the cart are: \n"+ shoppingCart );
		System.out.println("Is item 1 currently inside the cart?: "+ shoppingCart.contains(item1));
		System.out.println("How many times does item 3 appear in the cart?: "+ shoppingCart.getFrequencyOf(item3));
		System.out.println("The price of item 5 is: "+ item5.getPrice());
		System.out.println("The total price of all items in the cart is: "+ shoppingCart.getTotal());
		
		shoppingCart.remove(item3);
		shoppingCart.remove(item5);
		shoppingCart.remove();
		
		System.out.println("After removing several items, our carts contents are now: \n"+ shoppingCart);
		
		shoppingCart.clear();
		
		System.out.println("The cart has been emptied: "+ shoppingCart.isEmpty());

	}

}
