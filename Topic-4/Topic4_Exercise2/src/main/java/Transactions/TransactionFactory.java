package Transactions;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Notifications.Observer;
import Products.Product;
import Shop.ShoppingCart;
import Notifications.Subject;

public class TransactionFactory implements Subject{

	private static TransactionFactory transactionFactory = null;
	Set<Observer> transactionObservers;
	
	private TransactionFactory() {
		transactionObservers = new HashSet<Observer>();

	}
	
	public static TransactionFactory getInstance() {
		if (transactionFactory == null) {
			transactionFactory = new TransactionFactory();
		}
		return transactionFactory;
	}
	
	public Transaction getTransaction(String transactionType,ShoppingCart shoppingCart){
		switch(transactionType){
		case "CREDIT_CARD":	if(shoppingCart.getUser().getCardNumber()!=0 && shoppingCart.getUser().getName()!=null){
								Transaction cC = new CreditCard(shoppingCart);
								doNotify(cC);
								return cC;
							}
							break;
		case "PAYPAL" : 	if(shoppingCart.getUser().getEmail()!=null && shoppingCart.getUser().getPassword()!=null){
								Transaction pP = new PayPal(shoppingCart);
								doNotify(pP);
								return pP;
							}
							break;
		default:			Transaction c = new Cash(shoppingCart);
							doNotify(c);
							return c;
		}
		System.out.println("Transaction failed, missing user data");
		return null;
	}

	
	@Override
	public void addObserver(Observer transactionObserver) {
		transactionObservers.add(transactionObserver);		
	}

	@Override
	public void removeObserver(Observer transactionObserver) {
		transactionObservers.remove(transactionObserver);
		
	}

	@Override
	public void doNotify(Transaction transaction) {
		Iterator<Observer> it = transactionObservers.iterator();
		while (it.hasNext()) {
			Observer transactionObserver = it.next();
			transactionObserver.doUpdate("\nA transaction was done with the number: "+ transaction.getTransactionNumber());
		}
		
	}

	@Override
	public void doNotify(Product product) {
		// TODO Auto-generated method stub
		
	}
	
	

}
