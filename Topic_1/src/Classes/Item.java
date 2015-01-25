package Classes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Interfases.Observer;
import Interfases.Product;
import Interfases.ShoppingCartVisitor;

public class Item implements Product {

	private String name;
	private double price;
	Set<Observer> itemObservers;

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
		itemObservers = new HashSet<Observer>();

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
		doNotify(this);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	@Override
	public void accept(ShoppingCartVisitor visitor) {
		visitor.add(this);
	}

	@Override
	public void addObserver(Observer itemObserver) {
		itemObservers.add(itemObserver);
	}

	@Override
	public void removeObserver(Observer itemObserver) {
		itemObservers.remove(itemObserver);
	}

	@Override
	public void doNotify(Product item) {
		Iterator<Observer> it = itemObservers.iterator();
		while (it.hasNext()) {
			Observer itemObserver = it.next();
			itemObserver.doUpdate("the price of item: " + item.getName()
					+ " was modified to: " + item.getPrice());
		}
	}

	public void doNotify(Transaction transaction) {
	}
}
