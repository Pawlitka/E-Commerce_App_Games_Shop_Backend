package com.github.pawlitka.ecommerceapp.game.mapper;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Game;
import com.github.pawlitka.ecommerceapp.game.dto.GameDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface GameMapper {
    GameDto toDto(Game game);

    List<GameDto> toDtoList(List<Game> games);
}
