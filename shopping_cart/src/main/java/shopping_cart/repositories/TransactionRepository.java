package shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.Transaction;

@Repository("transactionRepository")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
