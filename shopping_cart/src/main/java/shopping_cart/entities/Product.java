package shopping_cart.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@JoinColumn(name = "category")
	private String category;

	protected Product() {
	}

	public Product(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getDescription() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public Long getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

}
