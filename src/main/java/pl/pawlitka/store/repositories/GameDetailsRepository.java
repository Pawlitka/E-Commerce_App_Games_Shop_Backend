package pl.pawlitka.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawlitka.store.entities.GameDetails;

public interface GameDetailsRepository extends JpaRepository<GameDetails, Long> {
}
