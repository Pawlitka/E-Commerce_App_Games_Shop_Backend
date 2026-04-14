package com.github.pawlitka.ecommerceapp.game.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.type.descriptor.java.BlobJavaType;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    @DecimalMin(value = "0.0")
    private Double price;

    @Column(name = "main_image")
    private BlobJavaType mainImage;

    @Column(name = "reviews_count")
    @Min(0)
    private Integer reviewsCount;

    @Column(name="discount_in_percentage")
    @Min(0)
    @Max(1)
    private Integer discountInPercentage;

    @Column(name="rate")
    @Min(0)
    @Max(5)
    private Integer rate;

    @Column(name="description")
    private String description;

    @ManyToMany
    @JoinTable(
            name="game_genre",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();
}
