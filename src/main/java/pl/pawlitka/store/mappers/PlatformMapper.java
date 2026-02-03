package pl.pawlitka.store.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.pawlitka.store.dtos.GameDetailsDto;
import pl.pawlitka.store.entities.GameDetails;
import pl.pawlitka.store.entities.Platform;

@Mapper(componentModel = "spring")
public interface PlatformMapper {
    GameDetailsDto toDto(Platform platform);
}
