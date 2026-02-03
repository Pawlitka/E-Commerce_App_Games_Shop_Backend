package pl.pawlitka.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawlitka.store.entities.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
