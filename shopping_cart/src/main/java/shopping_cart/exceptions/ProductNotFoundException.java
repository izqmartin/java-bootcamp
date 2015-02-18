package shopping_cart.exceptions;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {
		super("Product not found!");
	}
}
