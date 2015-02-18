package shopping_cart.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "shopping_cart_id")
	private Long id;

	@OneToMany(mappedBy = "shoppingCart")
	private List<ProductLine> productLines;

	@Column(name = "total")
	private double total;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "shoppingCart")
	private User user;

	public ShoppingCart() {
	}

	public List<ProductLine> getItemLines() {
		return productLines;
	}

	public Long getId() {
		return id;
	}

	@JsonIgnore
	public boolean isEmpty() {
		return this.productLines.isEmpty();
	}

	public double getTotal() {
		return this.total;
	}

	private void setTotal(double total) {
		this.total = total;
	}

	public void updateTotal() {
		double total = 0;
		for (ProductLine il : productLines) {
			total += il.getSubTotal();
		}

		setTotal(total);
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
