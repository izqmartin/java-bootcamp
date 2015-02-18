package shopping_cart.exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String user) {
		super("Username " + "\"" + user + "\"" + "not found");
	}
}
