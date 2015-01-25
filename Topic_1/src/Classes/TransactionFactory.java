package Classes;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Interfases.Observer;
import Interfases.Product;
import Interfases.Subject;

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
		case "Credit_Card":	Transaction cC = new CreditCard(shoppingCart);
							doNotify(cC);
							return cC;
		case "PayPal" : 	Transaction pP = new PayPal(shoppingCart);
							doNotify(pP);
							return pP;
		default:			Transaction c = new Cash(shoppingCart);
							doNotify(c);
							return c;
		
		}
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
