package pl.pawlitka.store.mappers;

import org.mapstruct.Mapper;
import pl.pawlitka.store.dtos.UserDto;
import pl.pawlitka.store.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
