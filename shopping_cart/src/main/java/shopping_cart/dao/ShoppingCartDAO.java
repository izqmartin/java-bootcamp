package shopping_cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shopping_cart.entities.ShoppingCart;
import shopping_cart.repositories.ShoppingCartRepository;

@Component
public class ShoppingCartDAO {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private UserDAO userDAO;

	public ShoppingCart save(ShoppingCart sc) {
		return shoppingCartRepository.save(sc);
	}
}
