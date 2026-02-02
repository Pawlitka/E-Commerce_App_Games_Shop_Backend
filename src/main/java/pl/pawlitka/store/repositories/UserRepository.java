package pl.pawlitka.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawlitka.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
