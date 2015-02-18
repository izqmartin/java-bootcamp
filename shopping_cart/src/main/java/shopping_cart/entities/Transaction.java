package shopping_cart.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	private Long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "total")
	private double total;

	@OneToMany(mappedBy = "transaction")
	private List<ProductLine> productLines;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	protected Transaction() {
	}

	public Transaction(Date date, User user) {
		this.date = date;
		this.user = user;
	}

	@JsonIgnore
	public Date getDate() {
		return date;
	}

	public String getStringDate() {
		return date.toString();
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<ProductLine> getProductLines() {
		return productLines;
	}

	public void setproductLines(List<ProductLine> productLines) {
		this.productLines = productLines;
	}

	public User getUser() {
		return user;
	}

	public Long getId() {
		return id;
	}

}
