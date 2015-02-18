package shopping_cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shopping_cart.entities.User;
import shopping_cart.entities.UserSession;
import shopping_cart.exceptions.UserNotAuthenticatedException;
import shopping_cart.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserServicesController {

	@Autowired
	private UserServices userServices;
	@Autowired
	private UserSession userSession;

	// Add client
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public @ResponseBody User addUser(@RequestParam("name") String name, @RequestParam("username") String username,
			@RequestParam("password") String password,@RequestParam("creditcard") Long creditcard) {
		return this.userServices.addUser(name, username, password,creditcard);
	}

	// login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestParam("username") String username, @RequestParam("password") String password) {
		User user = this.userServices.login(username, password);
		userSession.setUser(user);
		return user;
	}

}
