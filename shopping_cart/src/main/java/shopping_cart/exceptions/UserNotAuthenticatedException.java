package shopping_cart.exceptions;

public class UserNotAuthenticatedException extends RuntimeException {

	public UserNotAuthenticatedException() {
		super("The User is not authenticated");
	}
}
