package shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.ShoppingCart;

@Repository("shoppingCartRepository")
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

	@Query("SELECT sc FROM ShoppingCart sc INNER JOIN sc.user c WHERE c.username = :user")
	public ShoppingCart findByClient(@Param("user") String user);
}
