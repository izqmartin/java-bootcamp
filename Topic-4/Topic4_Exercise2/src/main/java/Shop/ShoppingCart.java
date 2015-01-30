package Shop;

import java.util.ArrayList;
import java.util.List;

import Products.Product;
import Users.User;

public class ShoppingCart implements ShoppingCartVisitor{

	private double total;
	private List<Product> itemList;
	private User user;
	
	public ShoppingCart(){
		itemList = new ArrayList<Product>();
		total=0;
		user= null;
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
	
	public void remove(Product product)	{
		itemList.remove(product);
		total -= product.getPrice();
	}

	
}
