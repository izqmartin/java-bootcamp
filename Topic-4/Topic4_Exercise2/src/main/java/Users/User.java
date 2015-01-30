
package Users;

import java.util.ArrayList;

/**
 * Provide methods for create users.
 * @author Martin Izquierdo
 *
 */
public class User {

	private String username;
	private String password;
	private String name;
	private int cardNumber;
	private String email;
	private ArrayList<Photo> gallery;
	private ArrayList<User> friends;
	
//	/**
//	 * Constructor with parameters 
//	 * @param name name of user.
//	 * @param username a nickname.
//	 * @param password a password.
//	 * @param cardNumber Credit card number.
//	 */
//	public User(String name,String username,String password,int cardNumber){
//		this.name=name;
//		this.username=username;
//		this.password=password;
//		this.cardNumber=cardNumber;
//	}
	/**
	 * Constructor with parameters 
	 * @param name
	 * @param username
	 * @param password
	 * @param cardNumber
	 * @param email
	 */
	public User(String name,String username,String password,int cardNumber,String email){
		this.name=name;
		this.username=username;
		this.password=password;
		this.cardNumber=cardNumber;
		this.email=email;
		gallery= new ArrayList<Photo>();
		friends= new ArrayList<User>();
	}
	
	/**
	 * Return Username
	 * @return String
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * Set Username
	 * @param username a nickname
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * Return Password
	 * @return String
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Set Password
	 * @param password a password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * Return Name
	 * @return String
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set name
	 * @param name name of user.
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Return Credit Card Number
	 * @return int
	 */
	public int getCardNumber() {
		return cardNumber;
	}


	/**
	 * Set Credit Card Number
	 * @param cardNumber credit card number
	 */
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Return email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * set email	
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * return gallery
	 * @return ArrayList<Photo>
	 */
	public ArrayList<Photo> getGallery() {
		return gallery;
	}
	/**
	 * set Gallery
	 * @param gallery
	 */
	public void setGallery(ArrayList<Photo> gallery) {
		this.gallery = gallery;
	}
	/**
	 * Add photo to the user gallery
	 * @param link url photo
	 */
	public void addPhoto(String link){
		Photo photo=new Photo(link);
		gallery.add(photo);
	}

	/**
	 * get arraylist of friends
	 * @return ArrayList<User>
	 */
	public ArrayList<User> getFriends() {
		return friends;
	}

	/**
	 * set ArrayList of Friends 
	 * @param friends
	 */
	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	
	/**
	 * Add friend to the arraylist of friends if this is not already added
	 * @param user
	 */
	public void addFriend(User friend){
		if(!friends.contains(friend)){
		friends.add(friend);
		}
	}
	/**
	 * if exist friend in the list friends, is removed.
	 * @param user
	 */
	public void removeFriend(User friend){
		if(friends.contains(friend)){
			friends.remove(friend);
		}
	}
	
	public void likePhoto(String link,String friendName){
		for(int i=0;i<gallery.size();i++){
			if(gallery.get(i).getLink()==link){
				gallery.get(i).Like(friendName);
			}
		}
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", name=" + name + ", cardNumber=" + cardNumber + ", email="
				+ email + ", gallery=" + gallery + ", friends("+friends.size()+")=" + friends + "]";
	}



}
