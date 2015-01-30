package Products;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Notifications.Observer;
import Products.Product;
import Shop.ShoppingCartVisitor;
import Transactions.Transaction;

public class Offer implements Product {

	private String name;
	private double price;
	private List<Product> offerList;
	Set<Observer> offerObservers;

	public Offer(String name, double price, List<Product> offerList) {
		this.name = name;
		this.price = price;
		this.offerList = offerList;
		offerObservers = new HashSet<Observer>();
	}

	@Override
	public void accept(ShoppingCartVisitor visitor) {
		visitor.add(this);
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

	public List<Product> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<Product> offerList) {
		this.offerList = offerList;
	}

	@Override
	public String toString() {
		return "Offer [name=" + name + ", price=" + price + ", offerList="
				+ offerList + "]";
	}

	@Override
	public void addObserver(Observer offerObserver) {
		offerObservers.add(offerObserver);

	}

	@Override
	public void removeObserver(Observer offerObserver) {
		offerObservers.remove(offerObserver);

	}

	@Override
	public void doNotify(Transaction transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doNotify(Product offer) {
		Iterator<Observer> it = offerObservers.iterator();
		while (it.hasNext()) {
			Observer itemObserver = it.next();
			itemObserver.doUpdate("the price of offer: " + offer.getName()
					+ " was modified to: " + offer.getPrice());
		}
	}

}
