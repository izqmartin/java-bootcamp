package shopping_cart.exceptions;

public class CreditCardNotFoundException extends RuntimeException {

	public CreditCardNotFoundException() {
		super("Credit Card not found!");
	}
}
