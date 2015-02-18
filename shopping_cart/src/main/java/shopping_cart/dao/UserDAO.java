package shopping_cart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shopping_cart.entities.User;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.exceptions.UserNotFoundException;
import shopping_cart.exceptions.NameUnavailableException;
import shopping_cart.exceptions.UsernameUnavailableException;
import shopping_cart.exceptions.WrongPasswordException;
import shopping_cart.repositories.UserRepository;

@Component
public class UserDAO {

	@Autowired
	private UserRepository userRepository;

	public User addUser(String name, String username, String password,Long creditcard) {
		if (!this.userAvailable(username)) {
			throw new UsernameUnavailableException();
		}

		if (!this.nameAvailable(name)) {
			throw new NameUnavailableException();
		}

		ShoppingCart sc = new ShoppingCart();
		User user = new User(name, username, password,creditcard, sc);
		return this.userRepository.save(user);
	}

	private boolean nameAvailable(String name) {
		return (this.userRepository.findByName(name) == null);
	}

	private boolean userAvailable(String user) {
		return (this.userRepository.findByUsername(user) == null);
	}

	public User getUserByUsername(String username) {
		User user = this.userRepository.findByUsername(username);

		if (user == null) {
			throw new UserNotFoundException(username);
		}

		return user;
	}

	public User getClient(User user) {
		return getUserByUsername(user.getUser());
	}

	public User login(String username, String password) {
		User user = getUserByUsername(username);

		if (user.isValidPassword(password)) {
			return user;
		} else {
			throw new WrongPasswordException();
		}
	}
}
