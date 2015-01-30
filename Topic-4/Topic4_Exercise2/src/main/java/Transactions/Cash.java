package Transactions;

import Products.Product;
import Shop.ShoppingCart;

public class Cash extends Transaction{
	
	public Cash(ShoppingCart shoppingCart){
		total=shoppingCart.getTotal();
		transactionNumber++;
		calculateDiscount(shoppingCart);
	}

	@Override
	public void calculateDiscount(ShoppingCart shoppingCart) {
		Product item1 = shoppingCart.getItemList().get(0);

		for (Product prod : shoppingCart.getItemList()) {

			if ((prod.getPrice()) >= (item1.getPrice())) {
				item1 = prod;
			}
		}
		totalWhithDiscount = total - (item1.getPrice() * 0.9);
		
		System.out.println("cash: " + totalWhithDiscount);
	}
			
}
