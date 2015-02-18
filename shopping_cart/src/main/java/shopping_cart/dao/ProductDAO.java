package shopping_cart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import shopping_cart.entities.Product;
import shopping_cart.exceptions.ProductNotFoundException;
import shopping_cart.repositories.ProductRepository;

@Component
public class ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProductsByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	public List<Product> getProducts(String description) {
		return productRepository.findByDescriptionLike(description);
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(Long productId) {
		Product product = productRepository.findOne(productId);

		if (product == null) {
			throw new ProductNotFoundException();
		}

		return product;
	}

	public Product createProduct(String description, double price, String category) {
		return this.productRepository.save(new Product(description, price, category));
	}
}
