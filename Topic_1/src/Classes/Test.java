package Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JSlider;

import AudioPlayer.AudioPlayer;
import AudioPlayer.PlayingTimer;
import AudioPlayer.SwingAudioPlayer;
import Interfases.Product;

public class Test {

	public static void main(String[] args) {

		Manager martin = new Manager(); 

		//create a Product list and insert products, items & offers
		ProductFactory prodList = ProductFactory.getInstance();
		prodList.addObserver(martin);							//add Orserver to send notification to Manager
		prodList.setProduct(new Item("LEDtv", 100));			//item
		prodList.setProduct(new Item("microwave", 1520.90));	//item
		prodList.setProduct(new Item("iphone", 50));			//item
		prodList.setProduct(new Item("notebook lenovo", 8050));	//item
		List<Product> listOffer = new ArrayList<Product>();
		listOffer.add(new Item("notebook lenovo", 6050));		//item of offer
		prodList.setProduct(new Offer("black friday", 5000, listOffer));	//offer

		//Create a User
		User user= new User("martin izquierdo","izqmartin","1234",123456);
		
		//Create a Shopping Cart
		ShoppingCart cart = new ShoppingCart();
		cart.setUser(user);						//Set user
		try {
			cart.add(prodList.getProduct("LEDtv"));		//add product to a shopping cart
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cart.add(prodList.getProduct("iphone"));	//add product to a shopping cart
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create a new transaction 
		TransactionFactory tranFac= TransactionFactory.getInstance();
		tranFac.addObserver(martin);					//add Orserver to send notification to Manager
		tranFac.getTransaction("Credit_Card", cart);	//make transaction whith credit Card
		tranFac.getTransaction("Cash", cart);			//make transaction whith cash
		tranFac.getTransaction("PayPal", cart);			//make transaction whith cart
		
		
		//Create a audio player
		AudioPlayer audio1= new AudioPlayer();
		
		String dir = "C:/Ring05.wav";
		try {
			audio1.load(dir);							//load file to reproduce
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			audio1.play();								//play the file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
