package pl.pawlitka.store.repositories;

import pl.pawlitka.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}