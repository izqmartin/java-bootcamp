package shopping_cart.services;

import java.util.List;

import shopping_cart.entities.Product;

public interface ProductServices {

	public List<Product> getProductsByDescription(String description);

	public List<Product> getProductsByCategory(String category);

	
	public List<Product> getProducts();
}