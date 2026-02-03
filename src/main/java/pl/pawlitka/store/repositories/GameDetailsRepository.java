package pl.pawlitka.store.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pawlitka.store.entities.GameDetails;
import pl.pawlitka.store.entities.Product;

import java.util.List;


public interface GameDetailsRepository extends JpaRepository<GameDetails, Long> {
    @Query(value = "SELECT g FROM GameDetails g WHERE g.active = TRUE")
    List<GameDetails> findAllActive();
}
