package pl.pawlitka.store.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;

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
    private String platformId;

}
