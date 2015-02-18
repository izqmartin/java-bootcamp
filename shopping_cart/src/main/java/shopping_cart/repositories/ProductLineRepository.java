package shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.ProductLine;

@Repository("productLineRepository")
public interface ProductLineRepository extends JpaRepository<ProductLine, Long> {

}
