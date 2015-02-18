package shopping_cart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shopping_cart.dao.UserDAO;
import shopping_cart.dao.ProductLineDAO;
import shopping_cart.dao.TransactionDAO;
import shopping_cart.entities.User;

@Service
@Configurable
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProductLineDAO itemLinesDAO;
	@Autowired
	private TransactionDAO transactionDAO;

	public UserServicesImpl() {
	}

	@Override
	public User addUser(String name, String user, String password,Long creditCard) {
		return this.userDAO.addUser(name, user, password,creditCard);
	}

	@Override
	public User login(String user, String password) {
		return this.userDAO.login(user, password);
	}


}