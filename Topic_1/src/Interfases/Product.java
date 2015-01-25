package Interfases;

public interface Product extends Subject {

	public void accept(ShoppingCartVisitor visitor);

	public String getName();

	public double getPrice();

	public void setPrice(double price);

	public void setName(String name);
}
