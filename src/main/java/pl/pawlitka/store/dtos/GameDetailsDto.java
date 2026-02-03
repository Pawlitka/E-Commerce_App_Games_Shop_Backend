package pl.pawlitka.store.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.pawlitka.store.entities.Genre;

import java.util.List;


@AllArgsConstructor
@Getter
public class GameDetailsDto {
    private Long id;
    private Double price;
    private Integer discountInPercentage;
    private Integer reviews;
    private Integer numberOfStars;
    private String description;
    private String title;
    private PlatformDto platform;
    private List<GenreDto> genres;
}
