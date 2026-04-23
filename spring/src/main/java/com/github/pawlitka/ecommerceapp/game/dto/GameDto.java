package com.github.pawlitka.ecommerceapp.game.dto;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.java.BlobJavaType;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    private Long id;
    private String title;
    private Double price;
    private byte[] mainImage;
    private Integer reviewsCount;
    private Double discountInPercentage;
    private Integer rate;
    private String description;
    private Set<GenreDto> genres;
    private Set<PlatformDto> platforms;
}
