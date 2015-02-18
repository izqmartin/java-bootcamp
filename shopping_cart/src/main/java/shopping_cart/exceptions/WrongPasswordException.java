package shopping_cart.exceptions;

public class WrongPasswordException extends RuntimeException {

	public WrongPasswordException() {
		super("Wrong password!");
	}
}
