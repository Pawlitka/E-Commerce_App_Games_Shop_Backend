package pl.pawlitka.store.repositories;

import pl.pawlitka.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}