package shopping_cart.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shopping_cart.entities.ProductLine;
import shopping_cart.entities.Product;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.repositories.ProductLineRepository;

@Component
public class ProductLineDAO {

	@Autowired
	private ProductLineRepository productLineRepository;
	@Autowired
	private EntityManager em;

	public ProductLineDAO() {
	}

	public void createProductLine(Product product, int quantity, ShoppingCart shoppingCart) {
		this.productLineRepository.save(new ProductLine(product, quantity, shoppingCart));
	}

	public ProductLine save(ProductLine productLine) {
		return this.productLineRepository.save(productLine);
	}
}
