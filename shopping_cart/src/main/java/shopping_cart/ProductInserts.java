package shopping_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.ProductDAO;

@Component
public class ProductInserts {

	@Autowired
	private ProductDAO productDAO;

	@Transactional
	public void inserts() {
		if (productDAO.getProducts().isEmpty()) {


			productDAO.createProduct("mouse Genius", 100, "Electronics");
			productDAO.createProduct("Notebook Lenovo", 8000, "Electronics");
			productDAO.createProduct("monitor", 500, "Electronics");
			productDAO.createProduct("table", 400, "furniture");
			productDAO.createProduct("chair", 100, "furniture");
			productDAO.createProduct("door", 60, "furniture");
			productDAO.createProduct("ferrari 458", 243.090, "vehicles");
			productDAO.createProduct("Lamborghini Aventador", 400.995, "vehicles");
		}
	}
}
