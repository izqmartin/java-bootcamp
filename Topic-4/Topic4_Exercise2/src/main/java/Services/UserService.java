package Services;

import Notifications.Manager;
import Products.Product;
import Shop.ShoppingCart;
import Transactions.Transaction;
import Transactions.TransactionFactory;
import Users.User;

public class UserService implements Services{

	private User user;
	private ShoppingCart shoppingcart;
	private Transaction transaction;
	private TransactionFactory transactionfactory;
	private Manager manager;
	
	public UserService(){
		manager = new Manager("martin","pmartin.izq@gmail.com");
	}
	
	@Override
	public void CreateShoppingCart() {
		shoppingcart= new ShoppingCart();
		shoppingcart.setUser(user);			//Set user
	}

	@Override
	public ShoppingCart ReadShoppingCart() {
		return shoppingcart;
	}

	@Override
	public void UpdateShoppingCart(Product product, String operation) {
		if(operation.equals("INSERT")){
			shoppingcart.add(product);
		}
		else{
			if(operation.equals("DELETE")){
				shoppingcart.remove(product);
				
			}
			else{
				System.out.println("ERROR: operation can only be \"INSERT\" or \"DELETE\"");
			}
		}
		
	}
	
	@Override
	public void DeleteShoppingCart() {
		shoppingcart = null;
		
	}
	
	

	@Override
	public void CreateUser(String name, String username, String password,
			int cardNumber, String email) {
		user= new User(name,username,password,cardNumber,email);
		
	}

	@Override
	public User ReadUser() {
		return user;
	}

	@Override
	public void UpdateUser(String name, String password, int cardNumber,
			String email) {
		
		if(name!=null){
			user.setName(name);
		}
		if(password!=null){
			user.setPassword(password);
		}
		if(cardNumber!=0){
			user.setCardNumber(cardNumber);
		}
		if(email!=null){
			user.setEmail(email);
		}
		
	}

	@Override
	public void DeleteUser() {
		user= null;
		
	}
	
	@Override
	public void uploadPhoto(String link){
		user.addPhoto(link);
	}
	
	@Override
	public void addFriend(User friend){
		user.addFriend(friend);
	}
	
	@Override
	public void likePhoto(String link,String friendName){
		user.likePhoto(link, friendName);
	}
	
	
	@Override
	public void CreateTransaction(String transactionType) {
		transactionfactory= TransactionFactory.getInstance();
		transactionfactory.addObserver(manager);
		transactionfactory.getTransaction(transactionType, shoppingcart);
	}

	@Override
	public Transaction ReadTranscation() {
		return transaction;
	}

	@Override
	public void CreateManager(String name, String email) {
		System.out.println("You don't have permission to do that");
		
	}

	@Override
	public Manager ReadManager() {
		System.out.println("You don't have permission to do that");
		return null;
	}

	@Override
	public void UpdateManager(String email) {
		System.out.println("You don't have permission to do that");
		
	}

	@Override
	public void DeleteManager() {
		System.out.println("You don't have permission to do that");
		
	}

	@Override
	public void CreateProduct(String name, double price, String porductType) {
		System.out.println("You don't have permission to do that");
		
	}

	@Override
	public Product ReadProduct() {
		System.out.println("You don't have permission to do that");
		return null;
	}

	@Override
	public void UpdateProduct(String name, double price, String offerName) {
		System.out.println("You don't have permission to do that");
		
	}

	@Override
	public void DeleteProduct(String name) {
		System.out.println("You don't have permission to do that");
		
	}



	
}
