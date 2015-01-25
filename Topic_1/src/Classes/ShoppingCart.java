package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfases.Product;
import Interfases.ShoppingCartVisitor;

public class ShoppingCart implements ShoppingCartVisitor{

	private double total;
	private List<Product> itemList;
	private User user;
	
	public ShoppingCart(){
		itemList = new ArrayList<Product>();
		total=0;
		user= new User("example","example_","1234",0);
	}
	
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Product> getItemList() {
		return itemList;
	}

	public void setItemList(List<Product> itemList) {
		this.itemList = itemList;
	}
	
	

	@Override
	public void add(Product product) {
		itemList.add(product);
		System.out.println("Item: \n" + product);
		total += product.getPrice();
		
	}

	/*@Override
	public void visit(Item item) {
		itemList.add(item);
		System.out.println("Item: \n" + item);
		total += item.getPrice();
	}

	@Override
	public void visit(Offer offer) {
		itemList.add(offer);
		System.out.println("offer: \n" + offer);
		total += offer.getPrice();
	}

	@Override
	public void visit(List<Product> ProductList) {
		for (Product ne : ProductList) {
			ne.accept(this);
		}
		System.out.println("Total: " + total);
	}

	*/
}
