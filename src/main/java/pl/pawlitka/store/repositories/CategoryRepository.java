package pl.pawlitka.store.repositories;

import pl.pawlitka.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}