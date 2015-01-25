package Classes;


public class CreditCard extends Transaction{
	private String name;
	private int cardNumber;
	public CreditCard(ShoppingCart shoppingCart){
		total=shoppingCart.getTotal();
		name=shoppingCart.getUser().getName();
		cardNumber=shoppingCart.getUser().getCardNumber();
		transactionNumber++;
		calculateDiscount();
	}

	@Override
	public void calculateDiscount() {
		totalWhithDiscount = total - (total * 0.10);
		
		System.out.println("credit card: " + totalWhithDiscount);
	}
}
