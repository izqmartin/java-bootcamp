package shopping_cart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.UserDAO;
import shopping_cart.dao.ProductLineDAO;
import shopping_cart.dao.TransactionDAO;
import shopping_cart.dao.ProductDAO;
import shopping_cart.dao.ShoppingCartDAO;
import shopping_cart.entities.User;
import shopping_cart.entities.ProductLine;
import shopping_cart.entities.Transaction;
import shopping_cart.entities.Product;
import shopping_cart.entities.ShoppingCart;

@Service
@Configurable
public class ShoppingCartServicesImpl implements ShoppingCartServices {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProductLineDAO productLineDAO;
	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private ShoppingCartDAO shoppingCartDAO;

	@Override
	public ShoppingCart getShoppingCart(User user) {
		return userDAO.getClient(user).getShoppingCart();
	}

	@Override
	@Transactional
	public ShoppingCart addProduct(Long productId, int quantity, User user) {
		ShoppingCart shoppingCart = getShoppingCart(user);

		Product product = productDAO.getProduct(productId);

		productLineDAO.createProductLine(product, quantity, shoppingCart);

		shoppingCart.updateTotal();

		return shoppingCartDAO.save(shoppingCart);
	}

	@Override
	@Transactional
	public Transaction buyProducts(User user) {
		// get attached client
		user = userDAO.getClient(user);

		// make new order
		Transaction transaction = transactionDAO.createTransaction(user);

		ShoppingCart shoppingCart = getShoppingCart(user);

		List<ProductLine> ils = new ArrayList<ProductLine>();

		for (ProductLine il : shoppingCart.getItemLines()) {
			il.setOrder(transaction);
			ils.add(il);
		}

		transaction.setTotal(shoppingCart.getTotal());
		transaction.setproductLines(ils);
		user.setShoppingCart(new ShoppingCart());

		return transaction;
	}
}
