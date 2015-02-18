package shopping_cart.exceptions;

public class UsernameUnavailableException extends RuntimeException {

	public UsernameUnavailableException() {
		super("User not available!");
	}
}
