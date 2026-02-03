package pl.pawlitka.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pawlitka.store.entities.GameDetails;

import java.util.List;
import java.util.Optional;


public interface GameDetailsRepository extends JpaRepository<GameDetails, Long> {
    @Query(value = "SELECT g FROM GameDetails g WHERE g.active = TRUE")
    List<GameDetails> findAllActive();

    @Query(value = "SELECT g FROM GameDetails g WHERE g.active = TRUE AND g.id = :id")
    Optional<GameDetails> findById(@Param("id") Long id);
}
