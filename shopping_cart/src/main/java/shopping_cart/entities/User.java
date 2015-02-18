package shopping_cart.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name="creditCard")
	private Long creditCard;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;

	protected User() {
	}

	public User(String name, String user, String password,Long creditCard, ShoppingCart shoppingCart) {
		this.name=name;
		this.username=user;
		this.password=password;
		this.shoppingCart = shoppingCart;
		this.creditCard=creditCard;
	}

	public User(String name, String user, String password, Long creditCard) {
		this.name = name;
		this.username = user;
		this.password = password;
		this.creditCard=creditCard;
	}

	@JsonIgnore
	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String getName() {
		return name;
	}

	public String getUser() {
		return username;
	}

	public Long getId() {
		return id;
	}

	public Long getCreditCards() {
		return this.creditCard;
	}

	public boolean isValidPassword(String password) {
		return (this.password.equals(password));
	}
}
