package com.github.pawlitka.ecommerceapp.game.mapper;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Genre;
import com.github.pawlitka.ecommerceapp.game.dto.GenreDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDto toDto(Genre genre);

    List<GenreDto> toDtoList(List<Genre> genres);
}
