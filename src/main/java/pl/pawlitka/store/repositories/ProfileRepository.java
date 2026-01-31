package pl.pawlitka.store.repositories;

import pl.pawlitka.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}