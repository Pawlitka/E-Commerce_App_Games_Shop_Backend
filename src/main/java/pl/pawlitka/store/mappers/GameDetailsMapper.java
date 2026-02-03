package pl.pawlitka.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pawlitka.store.dtos.GameDetailsDto;
import pl.pawlitka.store.entities.GameDetails;

@Mapper(componentModel = "spring")
public interface GameDetailsMapper {
     @Mapping(source = "platform.id", target = "platformId")
     GameDetailsDto toDto(GameDetails gameDetails);
}
