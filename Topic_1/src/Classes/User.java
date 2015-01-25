package Classes;

public class User {

	private String username;
	private String password;
	private String name;
	private int cardNumber;
	
	
	public User(String name,String username,String password,int cardNumber){
		this.name=name;
		this.username=username;
		this.password=password;
		this.cardNumber=cardNumber;
	}
	
	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}



	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name
				+ ", cardNumber=" + cardNumber + "]";
	}
	
	



	
	
}
