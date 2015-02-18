package shopping_cart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shopping_cart.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String user);

	public User findByName(String name);
}