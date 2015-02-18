package shopping_cart.exceptions;

public class NameUnavailableException extends RuntimeException {

	public NameUnavailableException() {
		super("Name not available!");
	}
}
