package Interfases;

import Classes.Transaction;

public interface Subject {

	public void addObserver(Observer shoppingCartObserver);

	public void removeObserver(Observer shoppingCartObserver);

	public void doNotify(Transaction transaction);

	public void doNotify(Product product);

}
