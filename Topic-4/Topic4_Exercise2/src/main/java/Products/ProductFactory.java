package Products;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Notifications.Observer;
import Products.Product;
import Transactions.Transaction;
import Notifications.Subject;

public class ProductFactory implements Subject {

	private static ProductFactory productFactory = null;
	private static ArrayList<Product> productList;
	Set<Observer> productObservers;

	private ProductFactory() {
		productObservers = new HashSet<Observer>();
	}

	public static ProductFactory getInstance() {
		if (productFactory == null) {
			productFactory = new ProductFactory();
			productList = new ArrayList<Product>();
		}
		return productFactory;
	}

	public Product getProduct(String name) throws Exception {
		for (Product prod : productList) {
			if (prod.getName() == name) {
				return prod;
			}
		}
		throw new Exception("The item " + name + " doesn't exist.");
	}

	public void setProduct(Product product) {
		productList.add(product);
		doNotify(product);
	}

	@Override
	public void addObserver(Observer productObserver) {
		productObservers.add(productObserver);
	}

	@Override
	public void removeObserver(Observer productObserver) {
		productObservers.remove(productObserver);
	}

	@Override
	public void doNotify(Transaction transaction) {
		// TODO Auto-generated method stub
	}

	@Override
	public void doNotify(Product product) {
		Iterator<Observer> it = productObservers.iterator();
		while (it.hasNext()) {
			Observer itemObserver = it.next();
			itemObserver.doUpdate("the Product \"" + product.getName()
					+ "\" whith price: \"" + product.getPrice()
					+ "\" was added.");
		}
	}

}
