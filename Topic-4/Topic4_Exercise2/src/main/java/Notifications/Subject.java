package Notifications;

import Products.Product;
import Transactions.Transaction;

public interface Subject {

	public void addObserver(Observer shoppingCartObserver);

	public void removeObserver(Observer shoppingCartObserver);

	public void doNotify(Transaction transaction);

	public void doNotify(Product product);

}
