package shopping_cart.services;

import shopping_cart.entities.User;
import shopping_cart.entities.Transaction;
import shopping_cart.entities.ShoppingCart;

public interface ShoppingCartServices {

	public ShoppingCart getShoppingCart(User user);

	public ShoppingCart addProduct(Long productId, int quantity, User user);

	public Transaction buyProducts(User user);
}
