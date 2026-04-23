package com.github.pawlitka.ecommerceapp.game.mapper;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Platform;
import com.github.pawlitka.ecommerceapp.game.dto.PlatformDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlatformMapper {
    PlatformDto toDto (Platform platform);

    List<PlatformDto> toDtoList(List<Platform> platforms);
}
