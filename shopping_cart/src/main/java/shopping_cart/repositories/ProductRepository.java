package shopping_cart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE  p.category = :desc")
	public List<Product> findByCategory(@Param("desc") String category);

	@Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT(CONCAT('%', :desc), '%')")
	public List<Product> findByDescriptionLike(@Param("desc") String name);
}
