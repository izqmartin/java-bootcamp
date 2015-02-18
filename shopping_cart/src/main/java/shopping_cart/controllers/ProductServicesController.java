package shopping_cart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shopping_cart.entities.Product;
import shopping_cart.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductServicesController {

	@Autowired
	private ProductServices productServices;

	// get all
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {
		return productServices.getProducts();
	}

	// search by description
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody List<Product> getProducts(@RequestParam("query") String query) {
		return productServices.getProductsByDescription(query);
	}


	// get all within a category
	@RequestMapping(value = "/categories/{category}", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProduct(@PathVariable("category") String category) {
		return productServices.getProductsByCategory(category);
	}
}
