package Services;

import Notifications.Manager;
import Products.Product;
import Shop.ShoppingCart;
import Transactions.Transaction;
import Users.Photo;
import Users.User;

public interface Services {
	// Shopping cart CRUD
	/**
	 * Create shopping cart with user data.
	 */
	public void CreateShoppingCart();	
	/**
	 * Return Shopping cart data.
	 */
	public ShoppingCart ReadShoppingCart();
	/**
	 * Insert or delete a shopping cart product depending on the parameter operation. 
	 * if DELETE removes the product, if INSERT inserts the product.
	 * @param product
	 * @param operation (DELETE or INSERT)
	 */
	public void UpdateShoppingCart(Product product, String operation);
	/**
	 * Delete complete Shopping cart
	 */
	public void DeleteShoppingCart();
	
	
	//User CRUD
	/**
	 * Create user with the parameters.
	 * @param name
	 * @param username
	 * @param password
	 * @param cardNumber
	 * @param email
	 */
	public void CreateUser(String name,String username,String password,int cardNumber,String email);
	/**
	 * read user data.
	 * @return user
	 */
	public User ReadUser();
	/**
	 * update user data from a single username. (username can't be modified.)
	 * @param name can be modified
	 * @param password can be modified
	 * @param cardNumber can be modified
	 * @param email can be modified
	 */
	public void UpdateUser(String name,String password,int cardNumber,String email);
	/**
	 * Delete complete User.
	 */
	public void DeleteUser();
	
	/**
	 * Upload photo to the user gallery.
	 * @param link url photo
	 */
	public void uploadPhoto(String link);
	
	
	/**
	 * add user like a friend
	 * @param user friend
	 */
	public void addFriend(User user);
	/**
	 * Like photo with url "link" in name of "friendname"
	 * @param link
	 * @param friendname
	 */
	public void likePhoto(String link,String friendname);
	
	
	//Transactions CRUD
	/**
	 * Create transaction from a created cart on a actual user. select type of transaction on "transactionType" String.
	 * @param transactionType can be "CREDIT_CARD", "CASH" or "PAYPAL".
	 */
	public void CreateTransaction(String transactionType);
	/**
	 * Read  and return Transaction data. 
	 * @return Transaction
	 */
	public Transaction ReadTranscation();
	
	//Manager CRUD
	/**
	 * Create manager with name and email data.
	 * @param name
	 * @param email
	 */
	public void CreateManager(String name, String email);
	/**
	 * read and return manager data.
	 * @return Manager
	 */
	public Manager ReadManager();
	/**
	 * Update Manager data. Only can update email field.
	 * @param email
	 */
	public void UpdateManager(String email);
	/**
	 * Delete complete manager.
	 */
	public void DeleteManager();
	
	
	// Product CRUD
	/**
	 * Create item or offer depending on the value of the string productType.
	 * @param name item or offer name
	 * @param price item price, null if is offer.
	 * @param porductType "ITEM" or "OFFER".
	 */
	public void CreateProduct(String name, double price,String porductType);
	/**
	 * Read and Return Product data. 
	 * @return Product
	 */
	public Product ReadProduct();
	/**
	 * Update item price if offerName is NULL. otherwise Insert element (name and price) in the offer list.
	 * @param name item name
	 * @param price item price
	 * @param offerName offer name (can be NULL)
	 */
	public void UpdateProduct(String name, double price, String offerName);
	/**
	 * Delete complete Product.
	 * @param name of product (item or offer)
	 */
	public void DeleteProduct(String name);
	
	
}
