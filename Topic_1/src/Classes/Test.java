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

		ProductFactory prodList = ProductFactory.getInstance();
		prodList.addObserver(martin);
		prodList.setProduct(new Item("LEDtv", 100));
		prodList.setProduct(new Item("microwave", 1520.90));
		prodList.setProduct(new Item("iphone", 50));
		prodList.setProduct(new Item("notebook lenovo", 8050));
		List<Product> listOffer = new ArrayList<Product>();
		listOffer.add(new Item("notebook lenovo", 6050));
		prodList.setProduct(new Offer("black friday", 5000, listOffer));

		User user= new User("martin izquierdo","izqmartin","1234",123456);
		
		ShoppingCart cart = new ShoppingCart();
		cart.setUser(user);
		try {
			cart.add(prodList.getProduct("LEDtv"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cart.add(prodList.getProduct("iphone"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TransactionFactory tranFac= TransactionFactory.getInstance();
		tranFac.addObserver(martin);
		tranFac.getTransaction("Credit_Card", cart);
		tranFac.getTransaction("Cash", cart);
		tranFac.getTransaction("PayPal", cart);
		
		
		SwingAudioPlayer sap= new SwingAudioPlayer();
		sap.setVisible(true);
		
		AudioPlayer audio1= new AudioPlayer();
		
		String dir = "C:/Ring05.wav";
		try {
			audio1.load(dir);
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
			audio1.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
