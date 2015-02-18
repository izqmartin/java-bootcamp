package shopping_cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shopping_cart.entities.UserSession;
import shopping_cart.entities.Transaction;
import shopping_cart.entities.ShoppingCart;
import shopping_cart.exceptions.UserNotAuthenticatedException;
import shopping_cart.services.ShoppingCartServices;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartServices shoppingCartServices;
	@Autowired
	private UserSession userSession;

	// get shopping cart
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ShoppingCart getShoppingCart() {
		if (userSession.getUser() == null) {
			throw new UserNotAuthenticatedException();
		}

		return shoppingCartServices.getShoppingCart(userSession.getUser());
	}

	// add product to shopping cart
	@RequestMapping(value = "/add-product", method = RequestMethod.POST)
	public @ResponseBody ShoppingCart addProduct(@RequestParam("product_id") Long productId, @RequestParam("quantity") int quantity) {
		if (userSession.getUser() == null) {
			throw new UserNotAuthenticatedException();
		}

		return shoppingCartServices.addProduct(productId, quantity, userSession.getUser());
	}

	// buy products
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public @ResponseBody Transaction buyProducts() {
		if (userSession.getUser() == null) {
			throw new UserNotAuthenticatedException();
		}

		return shoppingCartServices.buyProducts(userSession.getUser());
	}
}