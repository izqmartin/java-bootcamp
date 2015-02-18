package shopping_cart.controllers;

import javax.swing.text.html.HTML;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public  String getInfo() {

		return "is working!";
	}
}