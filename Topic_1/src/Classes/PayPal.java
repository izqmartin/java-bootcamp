package Classes;

import Interfases.Product;

public class PayPal extends Transaction{
	private String username;
	private String password;
	
	public PayPal(ShoppingCart shoppingCart){
		total=shoppingCart.getTotal();
		transactionNumber++;
		username=shoppingCart.getUser().getUsername();
		password=shoppingCart.getUser().getPassword();
		calculateDiscount(shoppingCart);
	}

	@Override
	public void calculateDiscount(ShoppingCart shoppingCart) {
		Product item1 = shoppingCart.getItemList().get(0);

		for (Product prod : shoppingCart.getItemList()) {
			if ((prod.getPrice()) <= (item1.getPrice())) {
				item1 = prod;
			}
		}
		totalWhithDiscount = total - item1.getPrice();
		System.out.println("paypal: " + totalWhithDiscount);
	}
}
