package shopping_cart.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import shopping_cart.entities.User;
import shopping_cart.entities.Transaction;
import shopping_cart.repositories.TransactionRepository;

@Component
public class TransactionDAO {

	@Autowired
	private TransactionRepository transactionRepository;

	public TransactionDAO() {
	}

	public Transaction createTransaction(User user) {
		return this.transactionRepository.save(new Transaction(new Date(), user));
	}

	public Transaction save(Transaction transaction) {
		return this.transactionRepository.save(transaction);
	}

	public Transaction getTransaction(Transaction transaction) {
		return this.transactionRepository.findOne(transaction.getId());
	}
}
