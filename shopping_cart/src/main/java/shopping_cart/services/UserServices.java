package shopping_cart.services;

import shopping_cart.entities.User;

public interface UserServices {

	public User addUser(String name, String user, String password,Long creditCard);

	public User login(String user, String password);


}
