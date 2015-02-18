package shopping_cart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import shopping_cart.dao.ProductDAO;
import shopping_cart.entities.Product;

@Service
@Configurable
public class ProductServicesImpl implements ProductServices {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> getProductsByDescription(String description) {
		return productDAO.getProducts(description);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productDAO.getProductsByCategory(category);
	}


	@Override
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

}
