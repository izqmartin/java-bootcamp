package shopping_cart.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException {

	public ShoppingCartNotFoundException() {
		super("Shopping cart not found!");
	}
}
